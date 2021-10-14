package model;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private Knight[] knights;
	private Wall[] walls;
	private final int NUMBER_WALLS;
	
	public Logic(PApplet app) {
		
		NUMBER_WALLS = 3;
		this.app = app;
		knights = new Knight[2];
		walls = new Wall[NUMBER_WALLS];
		createKnights();
	}
	
	//=============================================================//
	// Método Draw
	//=============================================================//
	
	public void draw() {
		knights[0].draw();
		knights[1].draw();
	}
	
	//=============================================================//
	// Crear Caballeros
	//=============================================================//
	
	public void createKnights() {
		knights[0] = new Knight(app, "img/KnightP1.png", 0, 700);
		knights[1] = new Knight(app, "img/KnightP2.png", 0, 900);
	}
}
