package model;

import processing.core.PApplet;

public class Knight extends Element {
	
	private boolean isJumping;

	public Knight(PApplet app, String iconAddress, int posX, int posY) {
		super(app, iconAddress, posX, posY);
		// TODO Auto-generated constructor stub
		isJumping = false;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(icon, posX, posY);
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isJumping() {
		return isJumping;
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}
}
