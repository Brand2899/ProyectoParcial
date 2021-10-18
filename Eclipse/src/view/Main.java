package view;

import com.google.gson.Gson;

import controller.Controller;
import controller.Instructions1;
import processing.core.PApplet;

public class Main extends PApplet implements Observer {
	
	private Controller c;
	private int screen;
	private HomeScreen homeScreen;
	private InstructionScreen instructionScreen;
	private PlayerWaitScreen playerWaitScreen;
	private GameScreen gameScreen;
	private boolean jump;
	
	private TCPSingleton tcp;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
		
		// Iconos diseñados por: "https://www.flaticon.es/autores/smashicons"
		// Iconos diseñados por: "https://www.freepik.com"
	}
	
	public void settings() {
		size(1500, 1072);
	}
	
	public void setup() {
		c = new Controller(this);
		tcp = TCPSingleton.getInstance();
		tcp.setMain(this);
		
		screen = 0; // Pantalla inicial debe ser 0
		homeScreen = new HomeScreen(this);
		instructionScreen = new InstructionScreen(this);
		playerWaitScreen = new PlayerWaitScreen(this);
		gameScreen = new GameScreen(this);
		jump = false;
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
			screen = 3;
			break;
			
		// Pantalla Juego
		case 3:
			gameScreen.draw();
			c.draw();
			c.move();
			break;
		}
	}
	
	//=============================================================//
	// Prueba de salto
	//=============================================================//
	
	public void keyPressed() {
		if(key == CODED) {
			if(keyCode == RIGHT) {
				c.jumpP1();
			}
			if(keyCode == LEFT) {
				c.jumpP2();
			}
		}
	}

	@Override
	public void onMessage(Session s, String msg) {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();
		Instructions1 inst = gson.fromJson(msg, Instructions1.class);

		jump = inst.getJump();
		
		if(s.getID() == 0) {
			if(jump) {
				c.jumpP1();
			}
		}
		if(s.getID() == 1) {
			if(jump) {
				c.jumpP2();
			}
		}
	}	
}
