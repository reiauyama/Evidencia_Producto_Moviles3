package com.example.patata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AllFunctions extends AppCompatActivity {
Button btnCycles,btnIrVoidFissures,btnIrrDroptable,IrNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_functions);
        btnCycles = findViewById(R.id.WorldState);
        btnIrVoidFissures = findViewById(R.id.btnIrVoidFissures);
        btnIrrDroptable = findViewById(R.id.btnIrrDroptable);
        IrNews = findViewById(R.id.IrNews);

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