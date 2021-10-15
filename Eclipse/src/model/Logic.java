package model;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private Knight[] knights;
	private Wall[] walls;
	private Hole[] holes;
	private final int NUMBER_WALLS = 6;
	private final int NUMBER_HOLES = 6;
	
	public Logic(PApplet app) {
		this.app = app;
		knights = new Knight[2];
		walls = new Wall[NUMBER_WALLS];
		holes = new Hole[NUMBER_HOLES];
		createKnights();
		createWalls();
		createHoles();
	}
	
	//=============================================================//
	// M�todo Draw
	//=============================================================//
	
	public void draw() {
		for(int i = 0; i < holes.length; i++) {
			holes[i].draw();
		}
		
		for(int i = 0; i < walls.length; i++) {
			walls[i].draw();
		}
		
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
	// Crear Muros
	//=============================================================//
	
	public void createWalls() {
		int x1 = (int) app.random(150, 550);
		int x2 = (int) app.random(551, 950);
		int x3 = (int) app.random(951, 1350);
		
		walls[0] = new Wall(app, "img/Wall.png", x1, 660);
		walls[1] = new Wall(app, "img/Wall.png", x2, 660);
		walls[2] = new Wall(app, "img/Wall.png", x3, 660);
		
		walls[3] = new Wall(app, "img/Wall.png", x1, 860);
		walls[4] = new Wall(app, "img/Wall.png", x2, 860);
		walls[5] = new Wall(app, "img/Wall.png", x3, 860);
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
				//System.out.println("PosX: " + posX + "\n");
			} else {
				posX = walls[i].getPosX() - random;
				//System.out.println("PosX: " + posX + "\n");
			}
			holes[i] = new Hole(app, "img/Hole.png", posX, posY + 30);
		}
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
			knights[0].setPosY(640);
		}
	}
	
	// Jugador 2
	
	public void jumpP2() {
		if(knights[1].getPosY() == 900) {
			knights[1].setPosY(840);
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
