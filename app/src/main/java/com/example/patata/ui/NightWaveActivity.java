package com.example.patata.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.R;
import com.example.patata.adapters.ChallengeAdapter;
import com.example.patata.models.Challenge;
import com.example.patata.models.NightwaveResponse;
import com.example.patata.network.NightWave;
import com.example.patata.network.NightWaveApi;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NightWaveActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChallengeAdapter challengeAdapter;
    private TextView tagTextView;
    private TextView seasonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightwave);

        tagTextView = findViewById(R.id.tag);
        seasonTextView = findViewById(R.id.season);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getNightwaveData();
    }

    private void getNightwaveData() {
        NightWaveApi apiService = NightWave.getClient().create(NightWaveApi.class);
        Call<NightwaveResponse> call = apiService.getNightwaveData();
        call.enqueue(new Callback<NightwaveResponse>() {
            @Override
            public void onResponse(Call<NightwaveResponse> call, Response<NightwaveResponse> response) {
                if (response.isSuccessful()) {
                    NightwaveResponse nightwaveResponse = response.body();
                    if (nightwaveResponse != null) {
                        tagTextView.setText("Tag: " + nightwaveResponse.getTag());
                        seasonTextView.setText("Season: " + nightwaveResponse.getSeason());
                        List<Challenge> activeChallenges = nightwaveResponse.getActiveChallenges();
                        challengeAdapter = new ChallengeAdapter(activeChallenges);
                        recyclerView.setAdapter(challengeAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<NightwaveResponse> call, Throwable t) {
                // Manejar errores aquí
            }
        });
    }
}
