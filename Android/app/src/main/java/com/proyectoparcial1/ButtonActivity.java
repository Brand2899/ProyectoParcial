package com.proyectoparcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;

public class ButtonActivity extends AppCompatActivity {

    private TCPSingleton tcp;

    private Button bnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        tcp = TCPSingleton.getInstance();

        bnJump = findViewById(R.id.bnJump);

        bnJump.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    Instruction1 inst1;
                    String json;

                    inst1 = new Instruction1(true);
                    json = gson.toJson(inst1);
                    tcp.send(json);
                }
        );
    }
}

// Iconos diseñados por: "https://www.flaticon.es/autores/smashicons"
// Iconos diseñados por: "https://www.freepik.com"
