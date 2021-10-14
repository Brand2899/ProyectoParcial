package view;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Screen {
	
	protected PApplet app;
	protected PImage home, gameInst, playerWait, gameScreen, game;
	
	public Screen(PApplet app) {
		this.app = app;
		home = app.loadImage("img/Home.jpg");
		gameInst = app.loadImage("img/GameInstructions.jpg");
		playerWait = app.loadImage("img/PlayerWait.jpg");
		game = app.loadImage("img/Game.jpg");
	}
	
	public abstract void draw();
}
