package com.proyectoparcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    // ip casa: 192.168.1.68
    // puerto: 5357

    private ImageView imgBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBg = findViewById(R.id.imgBg);
    }

    public void startClient(){
        new Thread(
                () -> {

                    Socket socket = new Socket();

                }
        ).start();
    }
}