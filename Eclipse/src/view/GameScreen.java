package view;

import processing.core.PApplet;

public class GameScreen extends Screen {
	

	public GameScreen(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(game, 0, 0);
	}
}
