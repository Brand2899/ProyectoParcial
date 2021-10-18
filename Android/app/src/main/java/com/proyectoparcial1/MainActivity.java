package com.proyectoparcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.TemperatureControlTemplate;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private ImageView imgBg;
    private Button checkConection;

    private TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBg = findViewById(R.id.imgBg);
        checkConection = findViewById(R.id.checkConection);

        tcp = TCPSingleton.getInstance();

        checkConection.setOnClickListener(
                (v) -> {
                    if(tcp.isConected()){
                        if(tcp.isConected()){
                            Intent intent = new Intent(this, ButtonActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}