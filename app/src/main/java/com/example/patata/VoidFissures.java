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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class VoidFissures extends AppCompatActivity {
    Button btnBackToHomepage;
    RecyclerView rv_servicelist;
    RVServiceListAdapte rvServiceListAdapter;
    ArrayList<ServiceList> serviceLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.void_fissures);
        btnBackToHomepage = findViewById(R.id.btnBackToHomepage);
        btnBackToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VoidFissures.this, MainActivity.class);
                startActivity(intent);
            }
        });

        serviceLists = new ArrayList<>();
        rv_servicelist = findViewById(R.id.rv_servicelist);
        rv_servicelist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvServiceListAdapter = new RVServiceListAdapte(VoidFissures.this, serviceLists);
        rv_servicelist.setAdapter(rvServiceListAdapter);
        rv_servicelist = findViewById(R.id.rv_servicelist);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


}