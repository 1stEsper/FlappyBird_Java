package flappybird;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



import javax.imageio.ImageIO;

import pkg2dgamesframework.QueueList;

public class ChimneyGroup {
	private QueueList<Chimney> chimneys; 
	
	private BufferedImage chimneyImage, chimneyImage2; 
	
	public static int SIZE=6;  
	
	public Chimney getChimney(int i) {
		return chimneys.get(i);
	}
	
	public ChimneyGroup() {
		try {
			chimneyImage=ImageIO.read(new File ("Assets/chimney.png"));
			chimneyImage2=ImageIO.read(new File ("Assets/chimney2.png"));
		}catch(IOException ex) {}

		
		chimneys = new QueueList<Chimney>(); 
		Chimney cn; 
		
		
		for (int i=0; i<SIZE/2; i++) {
			//Moi vong lap se push 1 capong khoi len 
			cn = new Chimney(830+i*300,350,74,400);
			chimneys.push(cn);
			
			cn = new Chimney(830+i*300,-300,74,400);
			chimneys.push(cn);
			
		}
	}
	
	public void update() {
		for (int i=0; i<SIZE; i++) {
			//Tuong duong voi ham chimneys.get(i).setPosX(chimneys.get(i).getPosX()-2);
			chimneys.get(i).update(); 
		}
		
		if(chimneys.get(0).getPosX()<-74) {
			Chimney cn; 
			cn = chimneys.pop(); 
			cn.setPosX(chimneys.get(4).getPosX()+300);
			chimneys.push(cn);
			
			cn = chimneys.pop(); 
			cn.setPosX(chimneys.get(4).getPosX());
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
