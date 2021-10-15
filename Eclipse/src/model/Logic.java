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
	
	//=============================================================//
	// Mover Caballeros
	//=============================================================//
	
	// Jugador 1
	
	public void moveP1() {
		int posX = knights[0].getPosX();
		int posY = knights[0].getPosY();
		
		if(knights[0].getPosX() < 1351) {
			knights[0].setPosX(posX += 1);
		}
		if(knights[0].getPosY() < 700) {
			knights[0].setPosY(posY += 1);
		}
		victory();
	}
	
	// Jugador 2
	
	public void moveP2() {
		int posX = knights[1].getPosX();
		int posY = knights[1].getPosY();
		
		if(knights[1].getPosX() < 1351) {
			knights[1].setPosX(posX += 1);
		}
		if(knights[1].getPosY() < 900) {
			knights[1].setPosY(posY += 1);
		}
		victory();
	}
	
	//=============================================================//
	// Saltar
	//=============================================================//
	
	// Jugador 1
	
	public void jumpP1() {
		if(knights[0].getPosY() == 700) {
			knights[0].setPosY(660);
		}
	}
	
	// Jugador 2
	
	public void jumpP2() {
		if(knights[1].getPosY() == 900) {
			knights[1].setPosY(860);
		}
	}
	
	//=============================================================//
	// Decidir Victoria
	//=============================================================//
	
	public void victory() {
		if(knights[0].getPosX() == 1350 || knights[1].getPosX() == 1350) {
			if(knights[0].getPosX() < knights[1].getPosX()) {
				System.out.println("Gana Jugador 2");
			} else if(knights[0].getPosX() > knights[1].getPosX()) {
				System.out.println("Gana Jugador 1");
			}else {
				System.out.println("Empate");
			}
		}
	}
}
