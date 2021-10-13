package view;

import processing.core.PApplet;

public class Main extends PApplet {
	
	private int screen;
	private HomeScreen homeScreen;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1800, 1000);
	}
	
	public void setup() {
		screen = 0;
		homeScreen = new HomeScreen(this);
	}
	
	public void draw() {
		changeScreen();
	}
	
	//=============================================================//
	// Cambiador de pantallas
	//=============================================================//
	
	public void changeScreen() {
		switch(screen) {
		
		// Pantalla Home
		case 0:
			homeScreen.draw();
			break;
		}
	}
}
