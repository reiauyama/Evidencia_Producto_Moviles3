package com.example.patata;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DropTableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DropAdapter adapter;
    private List<Drop> dropList;
    private EditText searchBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_table);

        recyclerView = findViewById(R.id.recyclerView);
        searchBox = findViewById(R.id.searchBox);

        dropList = new ArrayList<>();
        adapter = new DropAdapter(dropList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WarframeDropApi api = retrofit.create(WarframeDropApi.class);
        api.getDrops().enqueue(new Callback<List<Drop>>() {
            @Override
            public void onResponse(Call<List<Drop>> call, Response<List<Drop>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dropList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Drop>> call, Throwable t) {
                // Manejar errores
            }
        });

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        List<Drop> filteredList = new ArrayList<>();
        for (Drop drop : dropList) {
            if (drop.getItem().toLowerCase().contains(text.toLowerCase()) ||
                    drop.getPlace().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(drop);
            }
        }
        adapter.filterList(filteredList);
    }
}
