package com.example.patata.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.adapters.InventoryAdapter;
import com.example.patata.R;
import com.example.patata.models.InventoryItem;
import com.example.patata.models.VoidTrader;
import com.example.patata.network.RetrofitClient;
import com.example.patata.network.VoidTraderApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class VoidTraderActivity extends AppCompatActivity {
    private Button btnIrAllFunctions;

    private RecyclerView recyclerView;
    private InventoryAdapter inventoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_void_trader);
         btnIrAllFunctions = findViewById(R.id.btnIrAllFunctions);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnIrAllFunctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VoidTraderActivity.this, AllFunctions.class);
                startActivity(intent);
            }
        });


        fetchVoidTraderData();
    }

    private void fetchVoidTraderData() {
        VoidTraderApi apiService = RetrofitClient.getRetrofitInstance().create(VoidTraderApi.class);
        Call<VoidTrader> call = apiService.getVoidTrader();

        call.enqueue(new Callback<VoidTrader>() {
            @Override
            public void onResponse(Call<VoidTrader> call, Response<VoidTrader> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<InventoryItem> inventory = response.body().getInventory();
                    inventoryAdapter = new InventoryAdapter(inventory);
                    recyclerView.setAdapter(inventoryAdapter);
                }
            }

            @Override
            public void onFailure(Call<VoidTrader> call, Throwable t) {
                // Handle the error
            }

        });
    }
}
