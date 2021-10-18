package view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPSingleton extends Thread{
	
	private ServerSocket server;
	private ArrayList<Session> sessions;
	
	private Main observer;
    private static TCPSingleton onlyInstance;

    public static TCPSingleton getInstance(){
        if (onlyInstance == null){
            onlyInstance = new TCPSingleton();
            onlyInstance.start();
        }
        return onlyInstance;
    }
    
    private TCPSingleton() {
    	
    }
    
    public void setMain(Main observer) {
    	this.observer = observer;
    }
	
    public void run() {
    	try {
    		sessions = new ArrayList<Session>();
			server = new ServerSocket(5050);
			
            while(true) {
            	System.out.println("Esperando Cliente");
            	Socket socket = server.accept();
            	Session session = new Session(socket, this.sessions.size());
            	session.setObserver(observer);
				session.start();
				sessions.add(session);
				System.out.println("Cliente conectado");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ArrayList<Session> getSessions(){
    	return sessions;
    }
    
    public void setSessions (ArrayList<Session> sessions) {
    	this.sessions = sessions;
    }
}
