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
		int posX1 = knights[0].getPosX();
		
		if(!knights[0].isJumping()) {
			if(knights[0].getPosX() < 1351) {
				knights[0].setPosX(posX1 += 1);
			}
		}
		victory();
	}
	
	// Jugador 2
	
	public void moveP2() {
		int posX2 = knights[1].getPosX();
		
		if(!knights[1].isJumping()) {
			if(knights[1].getPosX() < 1351) {
				knights[1].setPosX(posX2 += 1);
			}
		}
		victory();
	}
	
	//=============================================================//
	// Saltar
	//=============================================================//
	
	// Jugador 1
	
	public void jumpP1() {
		knights[0].setJumping(true);
	}
	
	// Jugador 2
	
	public void jumpP2() {
		knights[0].setJumping(false);
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
