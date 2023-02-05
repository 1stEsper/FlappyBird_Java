package flappybird;

import java.awt.Graphics2D;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



import javax.imageio.ImageIO;

import pkg2dgamesframework.QueueList;

public class ChimneyGroup {
	private QueueList<Chimney> chimneys; 
	
	private BufferedImage chimneyImage, chimneyImage2; 
	
	public static int SIZE=6;  
	
	private int topChimneyY=-350; 
	private int bottomChimneyY = 200; 
	
	
	public Chimney getChimney(int i) {
		return chimneys.get(i);
	}
	
	public int getRandomY() {
		Random random= new Random();
		int a;
		//Tao ra 10 level cua do kho 
		a= random.nextInt(10);
		//cho a nhan voi 35 px dde dich chuyen toa do Y cua ong khoi (minh co the nhan voi bat ki so nao, mien la phuf hop, o day 35px la phu hop)
		return a*35; 
		
	}
	
	public ChimneyGroup() {
		try {
			chimneyImage=ImageIO.read(new File ("Assets/chimney.png"));
			chimneyImage2=ImageIO.read(new File ("Assets/chimney2.png"));
		}catch(IOException ex) {}

		
		chimneys = new QueueList<Chimney>(); 
		Chimney cn; 
		
		
		for (int i=0; i<SIZE/2; i++) {
			
			int deltaY=getRandomY();
			
			//Moi vong lap se push 1 capong khoi len 
			cn = new Chimney(830+i*300,bottomChimneyY+ deltaY,74,400 );
			chimneys.push(cn);
			
			cn = new Chimney(830+i*300,topChimneyY+ deltaY,74,400 );
			chimneys.push(cn);
			
		}
	}
	
	public void update() {
		for (int i=0; i<SIZE; i++) {
			//Tuong duong voi ham chimneys.get(i).setPosX(chimneys.get(i).getPosX()-2);
			chimneys.get(i).update(); 
		}
		
		if(chimneys.get(0).getPosX()<-74) {
			
			int deltaY=getRandomY(); 
			
			Chimney cn; 
			cn = chimneys.pop(); 
			cn.setPosX(chimneys.get(4).getPosX()+300);
			cn.setPosY(bottomChimneyY+deltaY);
			cn.setIsBehindBird(false);
			chimneys.push(cn);
			
			cn = chimneys.pop(); 
			cn.setPosX(chimneys.get(4).getPosX());
			cn.setPosY(topChimneyY+ deltaY);
			cn.setIsBehindBird(false);
			chimneys.push(cn);
		}
	}
	
	//Khoi tao lai ong khoi, de khi moi lan reset game thi no se dua lai vi tri ban ddau 
	public void resetChimneys() {
		chimneys = new QueueList<Chimney>(); 
		Chimney cn; 
		
		
		for (int i=0; i<SIZE/2; i++) {
					
					int deltaY=getRandomY();
					
					//Moi vong lap se push 1 capong khoi len 
					cn = new Chimney(830+i*300,bottomChimneyY+ deltaY,74,400 );
					chimneys.push(cn);
					
					cn = new Chimney(830+i*300,topChimneyY+ deltaY,74,400 );
					chimneys.push(cn);
					
				}
	}
	
	public void paint(Graphics2D g2) {
		for (int i=0; i<6; i++) {
			if (i%2==0)
				g2.drawImage(chimneyImage, (int)chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
			else
				g2.drawImage(chimneyImage2, (int)chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
		}
	}
}
