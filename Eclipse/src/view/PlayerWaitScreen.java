package view;

import processing.core.PApplet;

public class PlayerWaitScreen extends Screen{

	public PlayerWaitScreen(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(playerWait, 0, 0);
	}
}
