package com.example.patata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnVoidFissures,btnArbitrations, btnInicioSesion,btnDroptable,btnAll;

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


    }}