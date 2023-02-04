package flappybird;

import pkg2dgamesframework.Objects;

public class Bird extends Objects {
	//Toc do roi cua con chim hien tai bang 0, vt <0 thi di len , vt lon hon 0 thi di xuong
	private float vt=0; 
	
	private boolean isFlying = false; 
	
	//Lay toa do cua chim
	public Bird(int x, int y, int w, int h) {
		super(x,y,w,h);
	}
	
	//them method nay de method resetGame been class FlappyBird co the cap nhat lai vi tri ban dau la = 0
	public void setVt(float vt) {
		this.vt=vt; 
	}
	
	//Moi lan update thi cai toc do nay tang them 1 gia tri bang bien g cua class FlappyBird
	public void update(long deltaTime) {
		//Vi van toc roi co gia toc nen no se thay doi theo thoi gian 
		vt+=FlappyBird.g;
		//nen do do vi tri cung phai tang them "vt"
		this.setPosY(this.getPosY()+vt);
		
		//Khi van toc vt<0, thi no dang di len ~dang bay va nguoc lai
		if(vt<0) isFlying = true; 
		else isFlying = false;
		
	}
	
	public void fly() {
		//Ban dau se di len nhung sau do se di xuong cham lai vi co luc can cua trong luc "g"
		vt= -3; 
		
	}
	
	//Viet ham kiem tra dang bay hay k?
	public boolean getIsFlying() {
		return isFlying;
	}

}
