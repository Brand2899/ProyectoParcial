package com.proyectoparcial1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPSingleton extends Thread{

    private Socket socket;
    private BufferedWriter bw;
    private BufferedReader br;

    // SINGLETON
    private static TCPSingleton instance;

    private TCPSingleton(){

    }

    public static TCPSingleton getInstance(){
        if(instance == null){
            instance = new TCPSingleton();
            instance.start();
        }
        return instance;
    }
    // SINGLETON

    public void run(){
        // ip casa: 192.168.1.68
        // puerto: 5357

        try {
            socket = new Socket("192.168.1.68", 5357);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            br = new BufferedReader(new InputStreamReader(is));
            bw = new BufferedWriter(new OutputStreamWriter(os));

            while (true){
                String line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String msg){
        new Thread(
                () -> {
                    try {
                        bw.write(msg + "\n");
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
