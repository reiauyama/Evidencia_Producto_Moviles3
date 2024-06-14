package com.example.patata.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.R;
import com.example.patata.adapters.AlertAdapter;
import com.example.patata.models.Alert;
import com.example.patata.network.AlertsApi;
import com.example.patata.network.AlertsClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// AlertsActivity.java
public class AlertsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlertAdapter alertAdapter;
    private List<Alert> alertList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerts);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        alertAdapter = new AlertAdapter(alertList, this);
        recyclerView.setAdapter(alertAdapter);

        fetchAlerts();
    }

    private void fetchAlerts() {
        AlertsApi alertsApi = AlertsClient.getClient().create(AlertsApi.class);
        Call<List<Alert>> call = alertsApi.getAlerts();
        call.enqueue(new Callback<List<Alert>>() {
            @Override
            public void onResponse(Call<List<Alert>> call, Response<List<Alert>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    alertList.clear();
                    alertList.addAll(response.body());
                    alertAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Alert>> call, Throwable t) {
                Toast.makeText(AlertsActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
