package com.example.patata;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class WarframeVoidFissure extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VoidFissureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warframe_void_fissure);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch data from the API
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WarframeApi api = retrofit.create(WarframeApi.class);
        api.getVoidFissures().enqueue(new Callback<List<Fissure>>() {
            @Override
            public void onResponse(Call<List<Fissure>> call, Response<List<Fissure>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    updateUI(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Fissure>> call, Throwable t) {
                // Manejar errores
            }
        });
    }

    private void updateUI(List<Fissure> fissures) {
        adapter = new VoidFissureAdapter(fissures);
        recyclerView.setAdapter(adapter);
    }
}

