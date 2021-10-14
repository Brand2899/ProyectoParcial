package model;

import processing.core.PApplet;

public class Knight extends Element {

	public Knight(PApplet app, String iconAddress, int posX, int posY) {
		super(app, iconAddress, posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(icon, posX, posY);
	}

}
