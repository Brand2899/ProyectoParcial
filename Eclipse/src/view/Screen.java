package view;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Screen {
	
	protected PApplet app;
	protected ControlP5 cp5;
	protected PImage home, gameInst, playerWait, gameScreen;
	
	public Screen(PApplet app) {
		this.app = app;
		this.cp5 = new ControlP5(app);
		home = app.loadImage("img/Home.jpg");
		gameInst = app.loadImage("img/GameInstructions.jpg");
		playerWait = app.loadImage("img/PlayerWait.jpg");
	}
	
	public abstract void draw();
}
