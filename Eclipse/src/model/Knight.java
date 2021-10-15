package model;

import processing.core.PApplet;

public class Knight extends Element {
	
	private int score;

	public Knight(PApplet app, String iconAddress, int posX, int posY) {
		super(app, iconAddress, posX, posY);
		// TODO Auto-generated constructor stub
		score = 0;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
