package com.proyectoparcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.controls.templates.TemperatureControlTemplate;
import android.widget.Button;
import android.widget.ImageView;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private ImageView imgBg;

    private TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBg = findViewById(R.id.imgBg);

        tcp = TCPSingleton.getInstance();
    }
}