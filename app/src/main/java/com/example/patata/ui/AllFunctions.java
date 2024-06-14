package com.example.patata.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.patata.MainActivity;
import com.example.patata.R;

public class AllFunctions extends AppCompatActivity {
Button btnCycles,btnIrVoidFissures,backToHome,btnIrrDroptable,IrNews, btnIrVoidTrader,btnIrNightWave, btnIrAlerts,incurtions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_functions);

        incurtions = findViewById(R.id.incursions);
        btnCycles = findViewById(R.id.WorldState);
        btnIrVoidFissures = findViewById(R.id.btnIrVoidFissures);
        btnIrrDroptable = findViewById(R.id.btnIrrDroptable);
        IrNews = findViewById(R.id.IrNews);
        btnIrNightWave = findViewById(R.id.btnIrNightWave);
        btnIrAlerts = findViewById(R.id.btnIrAlerts);
        btnIrVoidTrader = findViewById(R.id.btnIrVoidTrader);
        backToHome = findViewById(R.id.backToHome);

        incurtions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, ArchonHuntActivity.class);
                startActivity(intent);
            }
        });

        btnIrAlerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

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
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllFunctions.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}