package com.example.patata.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.patata.R;

public class AllFunctions extends AppCompatActivity {
Button btnCycles,btnIrVoidFissures,btnIrrDroptable,IrNews, btnIrVoidTrader,btnIrNightWave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_functions);
        btnCycles = findViewById(R.id.WorldState);
        btnIrVoidFissures = findViewById(R.id.btnIrVoidFissures);
        btnIrrDroptable = findViewById(R.id.btnIrrDroptable);
        IrNews = findViewById(R.id.IrNews);
        btnIrNightWave = findViewById(R.id.btnIrNightWave);
        btnIrVoidTrader = findViewById(R.id.btnIrVoidTrader);

        btnIrVoidTrader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, VoidTraderActivity.class);
                startActivity(intent);
            }
        });
        btnIrNightWave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, NightWaveActivity.class);
                startActivity(intent);
            }
        });

        btnIrVoidFissures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, WarframeVoidFissure.class);
                startActivity(intent);
            }
        });
        IrNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, NewsActivity.class);
                startActivity(intent);
            }
        });
        btnIrrDroptable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, DropTableActivity.class);
                startActivity(intent);
            }
        });

        btnCycles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, CyclesActivity.class);
                startActivity(intent);
            }
        });
    }
}