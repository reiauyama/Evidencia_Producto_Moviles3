package com.example.patata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.patata.ui.AllFunctions;
import com.example.patata.ui.DropTableActivity;
import com.example.patata.ui.InicioSesion;
import com.example.patata.ui.WarframeVoidFissure;

public class MainActivity extends AppCompatActivity {
    Button btnVoidFissures,btnArbitrations, btnInicioSesion,btnDroptable,btnAll, btnCycles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnDroptable = findViewById(R.id.btnDroptable);
        btnInicioSesion = findViewById(R.id.btnInicioSesion);
        btnVoidFissures = findViewById(R.id.btnVoidFissures);
        btnAll= findViewById(R.id.btnAll);

        btnVoidFissures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WarframeVoidFissure.class);
                startActivity(intent);
            }
        });


        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InicioSesion.class);
                startActivity(intent);
            }
        });
        btnDroptable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DropTableActivity.class);
                startActivity(intent);
            }
        });
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllFunctions.class);
                startActivity(intent);
            }
        });


    }}