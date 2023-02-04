package flappybird;

import pkg2dgamesframework.Objects;

public class Chimney extends Objects {
	public Chimney(int x, int y, int w, int h) {
		super(x, y, w, h); 
	}
	
	public void update() {
		setPosX(getPosX()-2);// dat -2 o day nham set toc do di chuyen cua ong khoi, -2 cung chinh la toc do di chuyen cua ground o lop ground da lam
		//2 toc do cua ong khoi cung nhumat dat nen de bang nhau (-2)
	}

}
