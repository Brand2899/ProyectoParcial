package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {
	
	private Controller c;
	private int screen;
	private HomeScreen homeScreen;
	private InstructionScreen instructionScreen;
	private PlayerWaitScreen playerWaitScreen;
	private GameScreen gameScreen;
	
	
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;

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
		screen = 3; // Pantalla inicial debe ser 0
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
	
	
	//=============================================================//
	// Iniciar Server
	//=============================================================//
	
	public void startServer() {
		new Thread(
				() -> {
					try {
						ServerSocket server = new ServerSocket(5357);
						System.out.println("Esperando cliente");
						socket = server.accept();
						System.out.println("Cliente conectado");
						
						InputStream is = socket.getInputStream();
			            OutputStream os = socket.getOutputStream();

			            br = new BufferedReader(new InputStreamReader(is));
			            bw = new BufferedWriter(new OutputStreamWriter(os));
			            
			            while(true) {
							System.out.println("Esperando mensaje");
							String line = br.readLine();
							System.out.println("Recibido: " + line);
							
							Gson gson = new Gson();
							
							
			            }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
	}
}
