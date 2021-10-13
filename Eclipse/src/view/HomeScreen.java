package view;

import processing.core.PApplet;

public class HomeScreen extends Screen {

	public HomeScreen(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(home, 0, 0);
	}

}
