package com.example.patata.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.adapters.NewsAdapter;
import com.example.patata.R;
import com.example.patata.models.NewsItem;
import com.example.patata.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;
    private Spinner languageSpinner;
    private String selectedLanguage = "en"; // Default language

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        languageSpinner = findViewById(R.id.language_spinner);
        recyclerView = findViewById(R.id.recycler_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLanguage = parent.getItemAtPosition(position).toString();
                if (newsAdapter != null) {
                    newsAdapter.setLanguage(selectedLanguage);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        fetchNews();
    }

    private void fetchNews() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<NewsItem>> call = apiService.getNews();

        call.enqueue(new Callback<List<NewsItem>>() {
            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<NewsItem> newsItems = response.body();
                    newsAdapter = new NewsAdapter(newsItems);
                    recyclerView.setAdapter(newsAdapter);
                    newsAdapter.setLanguage(selectedLanguage);
                }
            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
