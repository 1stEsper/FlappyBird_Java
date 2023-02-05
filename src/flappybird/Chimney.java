package flappybird;

import pkg2dgamesframework.Objects;
import java.awt.*;

public class Chimney extends Objects {
	private Rectangle rect; 
	
	//XD con chim di qua ong khoi hay chua, false nghia la chim van chua bay qua
	private boolean isBehindBird = false;
	
	public Chimney(int x, int y, int w, int h) {
		super(x, y, w, h);
		rect = new Rectangle(x, y, w, h);
	}
	
	public void update() {
		setPosX(getPosX()-2);// dat -2 o day nham set toc do di chuyen cua ong khoi, -2 cung chinh la toc do di chuyen cua ground o lop ground da lam 2 toc do cua ong khoi cung nhumat dat nen de bang nhau (-2)

		//cap nhat vi tri lien tuc cua ong khoi
		rect.setLocation((int)this.getPosX(), (int)this.getPosY()); 
		
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void setIsBehindBird(boolean b) {
		isBehindBird = b; 
	}
	public boolean getIsBehindBird() {
		return isBehindBird; 
	}

}
