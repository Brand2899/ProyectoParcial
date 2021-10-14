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
	
	public void move() {
		int posX1 = knights[0].getPosX();
		int posX2 = knights[1].getPosX();
		
		//if(knights[0].isJumping() == false) {
			if(knights[0].getPosX() < 1351) {
				knights[0].setPosX(posX1 += 1);
			}
		//}
		if(!knights[1].isJumping()) {
			if(knights[1].getPosX() < 1351) {
				knights[1].setPosX(posX2 += 2);
			}
		}
		victory();
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
	
	public void jumpP1() {
		for(int i = 0; i < 1000000; i++) {
			knights[0].setJumping(true);
			System.out.println("");
		}
		knights[0].setJumping(false);
	}
	
	public void jumpP2() {
		for(int i = 0; i < 1000000; i++) {
			knights[1].setJumping(true);
		}
		knights[1].setJumping(false);
	}
}
