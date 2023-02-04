package flappybird;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;

import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.GameScreen;

public class FlappyBird extends GameScreen {
	private BufferedImage birds;
	private Animation bird_anim;
	
	private BufferedImage chimney; 
	
	public static float g=0.1f; // tao bien gia toc 
	
	private Bird bird; 
	private Ground ground; 
	
	private ChimneyGroup chimneyGroup; 
	
	private int BEGIN_SCREEN=0; 
	private int GAMEPLAY_SCREEN = 1;
	private int GAMEOVER_SCREEN =2;
	
	private int CurrentScreen = BEGIN_SCREEN; 
	
	public FlappyBird() {
		super(800,600); 
		try {
			birds =ImageIO.read(new File("Assets/bird_sprite.png"));
		}catch(IOException ex) {}
		
		bird_anim=new Animation(100); 
		AFrameOnImage f; 
		f =new AFrameOnImage(0, 0, 60, 60);
		bird_anim.AddFrame(f); 
		f =new AFrameOnImage(60, 0, 60, 60);
		bird_anim.AddFrame(f); 
		f =new AFrameOnImage(120, 0, 60, 60);
		bird_anim.AddFrame(f); 
		f =new AFrameOnImage(60, 0, 60, 60);
		bird_anim.AddFrame(f); 
		
		bird =new Bird(350,250,50,50);
		ground =new Ground(); 
		
		chimneyGroup = new ChimneyGroup();
		
		BeginGame();
	}
	public static void main(String[] args) {
		new FlappyBird(); 
	}
	
	//datt lai toa do cua con chim ve nhu ban dau 
	private void resetGame() {
		bird.setPos(350, 250);
		bird.setVt(0);
	}

	@Override
	public void GAME_UPDATE(long deltaTime) {
		if(CurrentScreen==BEGIN_SCREEN) {
			resetGame(); 
		}
		else if(CurrentScreen==GAMEPLAY_SCREEN) {
			bird_anim.Update_Me(deltaTime); 
			bird.update(deltaTime);
			ground.Update();
			
			chimneyGroup.update(); 
			
			//Xet vi tri cua con chim, neu cham dat thi se hien thi man hinh game over 
			if(bird.getPosY() + bird.getH() > ground.getYGround())
				CurrentScreen = GAMEOVER_SCREEN;
			
		}
		else {
			
		}
		
		
		
	}
	
	//Method nay de ve cac object ra man hinh tro choi
	@Override
	public void GAME_PAINT(Graphics2D g2) {
		//Ve ong khoi
		chimneyGroup.paint(g2);
		
		//Ve mat dat
		ground.Paint(g2);
		
		
		if(bird.getIsFlying())
			bird_anim.PaintAnims((int)bird.getPosX(), (int)bird.getPosY(), birds, g2, 0, -1);
		else 
			bird_anim.PaintAnims((int)bird.getPosX(), (int)bird.getPosY(), birds, g2, 0, 0);
		
		
		if(CurrentScreen==BEGIN_SCREEN) {
			g2.setColor(Color.red);
			g2.drawString("Press space to play game ", 200,300); 
		}
		if (CurrentScreen==GAMEOVER_SCREEN) {
			g2.setColor(Color.red);
			g2.drawString("Press space turn back begin screen ", 200,300); 
		}
		
	}

	@Override
	public void KEY_ACTION(KeyEvent e, int Event) {
		if(Event ==KEY_PRESSED) {
			if(CurrentScreen==BEGIN_SCREEN) {
				CurrentScreen = GAMEPLAY_SCREEN;
			}
			else if (CurrentScreen==GAMEPLAY_SCREEN) {
				bird.fly();  
			}
			else if (CurrentScreen==GAMEOVER_SCREEN){
				CurrentScreen = BEGIN_SCREEN;
			}
			
		}
	}

}
