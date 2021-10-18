package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import controller.Instructions1;

public class Session extends Thread{
	
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	private int id;
	private Instructions1 inst;
	private Main observer;
	
	public Session(Socket socket, int id) {
		this.socket = socket;
		this.id = id;
	}
	
	public void run() {
		try {
			InputStream is = socket.getInputStream();
	        OutputStream os = socket.getOutputStream();

	        br = new BufferedReader(new InputStreamReader(is));
	        bw = new BufferedWriter(new OutputStreamWriter(os));
	        
	        while(true) {
	        	System.out.println("Esperando mensaje");
				String line = br.readLine();
				System.out.println("Recibido: " + line);
				observer.onMessage(this, line);
	        }
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setObserver(Main observer) {
		this.observer = observer;
	}
	
	public int getID() {
		return id;
	}
	
	public Instructions1 getInst() {
		return inst;
	}
}
