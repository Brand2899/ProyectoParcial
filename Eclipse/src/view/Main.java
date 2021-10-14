package view;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {
	
	private Controller c;
	private int screen;
	private HomeScreen homeScreen;
	private InstructionScreen instructionScreen;
	private PlayerWaitScreen playerWaitScreen;
	private GameScreen gameScreen;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(1500, 1072);
	}
	
	public void setup() {
		c = new Controller(this);
		screen = 3;
		homeScreen = new HomeScreen(this);
		instructionScreen = new InstructionScreen(this);
		playerWaitScreen = new PlayerWaitScreen(this);
		gameScreen = new GameScreen(this);
	}
	
	public void draw() {
		changeScreen();
	}
	
	//=============================================================//
	// Lector de Click por pantalla
	//=============================================================//
	
	public void mouseClicked() {
		switch(screen) {
		
		// Pantalla Home
		case 0:
			if((mouseX > 529 && mouseY > 691) && (mouseX < 966 & mouseY < 867)) {
				//si hace click adentro del boton de jugar
				screen = 1;
			}
			break;
			
		// Pantalla Instrucciones
		case 1:
			//si hace click adentro de la pantalla
			screen = 2;
			break;
			
		// Pantalla Esperar jugadores <temp>
		case 2:
			screen = 3;
			break;
		// </temp>
		}
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
			
		// Pantalla Instrucciones
		case 1:
			instructionScreen.draw();
			break;
			
		// Pantalla Esperar jugadores
		case 2:
			playerWaitScreen.draw();
			break;
			
		// Pantalla Juego
		case 3:
			gameScreen.draw();
			c.draw();
			c.move();
			break;
		}
	}
}
