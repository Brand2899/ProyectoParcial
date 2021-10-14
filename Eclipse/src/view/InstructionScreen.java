package view;

import processing.core.PApplet;

public class InstructionScreen extends Screen {

	public InstructionScreen(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(gameInst, 0, 0);
	}
}
