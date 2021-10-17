package model;

import processing.core.PApplet;
import processing.core.PFont;

public class Logic {
	
	private PApplet app;
	private Knight[] knights;
	private Wall[] walls;
	private Hole[] holes;
	private final int NUMBER_WALLS = 6;
	private final int NUMBER_HOLES = 6;
	private int vel1;
	private int vel2;
	PFont title;
	PFont font;
	
	public Logic(PApplet app) {
		this.app = app;
		knights = new Knight[2];
		walls = new Wall[NUMBER_WALLS];
		holes = new Hole[NUMBER_HOLES];
		vel1 = 1;
		vel2 = 1;
		title = app.createFont("Georgia", 25);
		font = app.createFont("Arial Bold", 50);
		createKnights();
		createWalls();
		createHoles();
	}
	
	//=============================================================//
	// Método Draw
	//=============================================================//
	
	@SuppressWarnings("static-access")
	public void draw() {
		for(int i = 0; i < holes.length; i++) {
			holes[i].draw();
		}
		
		for(int i = 0; i < walls.length; i++) {
			walls[i].draw();
		}
		
		knights[0].draw();
		knights[1].draw();
		
		app.fill(0);
		app.textFont(title);
		app.textAlign(app.LEFT);
		app.text("Puntaje jugador 1: " + knights[0].getScore(), 40, 100);
		app.text("Puntaje jugador 2: " + knights[1].getScore(), 40, 145);
		
		victory();
	}
	
	//=============================================================//
	// Crear Caballeros
	//=============================================================//
	
	public void createKnights() {
		knights[0] = new Knight(app, "img/KnightP1.png", 0, 700);
		knights[1] = new Knight(app, "img/KnightP2.png", 0, 900);
	}
	
	//=============================================================//
	// Crear Muros
	//=============================================================//
	
	public void createWalls() {
		int x1 = (int) app.random(300, 600);
		int x2 = (int) app.random(601, 900);
		int x3 = (int) app.random(901, 1200);
		
		int x4 = (int) app.random(300, 600);
		int x5 = (int) app.random(601, 900);
		int x6 = (int) app.random(901, 1200);
		
		walls[0] = new Wall(app, "img/Wall.png", x1, 700);
		walls[1] = new Wall(app, "img/Wall.png", x2, 700);
		walls[2] = new Wall(app, "img/Wall.png", x3, 700);
		
		walls[3] = new Wall(app, "img/Wall.png", x4, 900);
		walls[4] = new Wall(app, "img/Wall.png", x5, 900);
		walls[5] = new Wall(app, "img/Wall.png", x6, 900);
	}
	
	//=============================================================//
	// Crear Huecos
	//=============================================================//
	
	public void createHoles() {
		for(int i = 0; i < walls.length; i++) {
			
			int random = (int) app.random(50, 150);
			int posY = walls[i].getPosY();
			int posX = 0;
			
			if(random % 2 == 0) {
				posX = walls[i].getPosX() + random;
			} else {
				posX = walls[i].getPosX() - random;
			}
			holes[i] = new Hole(app, "img/Hole.png", posX, posY + 60);
		}
	}
	
	//=============================================================//
	// Mover Caballeros
	//=============================================================//
	
	// Jugador 1
	
	public void moveP1() {
		int posX = knights[0].getPosX();
		int posY = knights[0].getPosY();
		
		if(knights[0].getPosX() < 1350) {
			knights[0].setPosX(posX += vel1);
		}
		if(knights[0].getPosY() < 700) {
			knights[0].setPosY(posY += vel1);
		}
		touchWall();
		touchHole();
	}
	
	// Jugador 2
	
	public void moveP2() {
		int posX = knights[1].getPosX();
		int posY = knights[1].getPosY();
		
		if(knights[1].getPosX() < 1350) {
			knights[1].setPosX(posX += vel2);
		}
		if(knights[1].getPosY() < 900) {
			knights[1].setPosY(posY += vel2);
		}
		touchWall();
		touchHole();
	}
	
	//=============================================================//
	// Saltar
	//=============================================================//
	
	// Jugador 1
	
	public void jumpP1() {
		if(knights[0].getPosY() == 700) {
			knights[0].setPosY(640);
			vel1 = 1;
		}
	}
	
	// Jugador 2
	
	public void jumpP2() {
		if(knights[1].getPosY() == 900) {
			knights[1].setPosY(840);
			vel2 = 1;
		}
	}
	
	//=============================================================//
	// Tocar Muro
	//=============================================================//
	
	public void touchWall() {
		for(int i = 0; i < 3; i++) {
			if(knights[0].getPosY() == 700) {
				if(knights[0].getPosX() + 30 == walls[i].getPosX()) {
					calcScore(true, 0);
				}
			}
		}
		for(int i = 3; i < 6; i++) {
			if(knights[1].getPosY() == 900) {
				if(knights[1].getPosX() + 30 == walls[i].getPosX()) {
					calcScore(true, 1);
				}
			}
		}
	}
	
	//=============================================================//
	// Tocar Hueco
	//=============================================================//
	
	public void touchHole() {
		for(int i = 0; i < 3; i++) {
			if(knights[0].getPosY() == 700) {
				if(knights[0].getPosX() + 20 == holes[i].getPosX()) {
					if(vel1 == 1) {
						calcScore(false, 0);
					}
					vel1 = 0;
				}
			}
		}
		for(int i = 3; i < 6; i++) {
			if(knights[1].getPosY() == 900) {
				if(knights[1].getPosX() + 20 == holes[i].getPosX()) {
					if(vel2 == 1) {
						calcScore(false, 1);
					}
					vel2 = 0;
				}
			}
		}
	}
	
	//=============================================================//
	// Calcular puntaje
	//=============================================================//
	
	public void calcScore(boolean op, int player) {
		if(op) {
			int score = knights[player].getScore() + 100;
			knights[player].setScore(score);
		} else {
			int score = knights[player].getScore() - 50;
			knights[player].setScore(score);
		}
	}
	
	//=============================================================//
	// Decidir Victoria
	//=============================================================//
	
	@SuppressWarnings("static-access")
	public void victory() {
		
		if(knights[0].getPosX() == 1350 || knights[1].getPosX() == 1350) {
			if(knights[0].getScore() < knights[1].getScore()) {
				app.fill(255);
				app.textFont(font);
				app.textAlign(app.CENTER);
				app.text("Gana Jugador 2", 750, 500);
			} else if(knights[0].getScore() > knights[1].getScore()) {
				app.fill(255);
				app.textFont(font);
				app.textAlign(app.CENTER);
				app.text("Gana Jugador 1", 750, 500);
			}else if(knights[0].getScore() == knights[1].getScore()){
				app.fill(255);
				app.textFont(font);
				app.textAlign(app.CENTER);
				app.text("Empate", 750, 500);
			}
		}
	}
}
