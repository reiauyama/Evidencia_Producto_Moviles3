package com.example.patata.ui;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.patata.R;
import com.example.patata.models.ArchonHunt;
import com.example.patata.network.ArchontHuntApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ArchonHuntActivity extends AppCompatActivity {

    private TextView bossTextView;
    private TextView factionTextView;
    private TextView etaTextView;
    private TextView node1TextView;
    private TextView type1TextView;
    private TextView node2TextView;
    private TextView type2TextView;
    private TextView node3TextView;
    private TextView type3TextView;
    private TextView rewardsTextView;
    private CardView bossCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.archonhunt_activity);

        bossTextView = findViewById(R.id.boss);
        factionTextView = findViewById(R.id.faction);
        etaTextView = findViewById(R.id.eta);
        node1TextView = findViewById(R.id.node1);
        type1TextView = findViewById(R.id.type1);
        node2TextView = findViewById(R.id.node2);
        type2TextView = findViewById(R.id.type2);
        node3TextView = findViewById(R.id.node3);
        type3TextView = findViewById(R.id.type3);
        rewardsTextView = findViewById(R.id.rewards);
        bossCardView = findViewById(R.id.boss_card);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArchontHuntApi apiService = retrofit.create(ArchontHuntApi.class);
        Call<ArchonHunt> call = apiService.getArchonHunt();
        call.enqueue(new Callback<ArchonHunt>() {
            @Override
            public void onResponse(Call<ArchonHunt> call, Response<ArchonHunt> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArchonHunt archonHunt = response.body();
                    bossTextView.setText("Boss: " + archonHunt.getBoss());
                    factionTextView.setText("Faction: " + archonHunt.getFaction());
                    etaTextView.setText("ETA: " + archonHunt.getEta());
                    node1TextView.setText("Node: " + archonHunt.getMissions().get(0).getNode());
                    type1TextView.setText("Type: " + archonHunt.getMissions().get(0).getType());
                    node2TextView.setText("Node: " + archonHunt.getMissions().get(1).getNode());
                    type2TextView.setText("Type: " + archonHunt.getMissions().get(1).getType());
                    node3TextView.setText("Node: " + archonHunt.getMissions().get(2).getNode());
                    type3TextView.setText("Type: " + archonHunt.getMissions().get(2).getType());
                    String boss = archonHunt.getBoss();
                    if (boss.equals("Archon Amar")) {
                        bossCardView.setCardBackgroundColor(getResources().getColor(R.color.red_color));
                    } else if (boss.equals("Archon Nira")) {
                        bossCardView.setCardBackgroundColor(getResources().getColor(R.color.yellow_color));
                    } else if (boss.equals("Archon Boreal")) {
                        bossCardView.setCardBackgroundColor(getResources().getColor(R.color.blue_color));
                    }

                    String rewardText = "Ayatan Anasa Sculpture: 28%\n"
                            + "Endo x8000: 12.1%\n"
                            + "Kuva x12000: 12%\n"
                            + "Melee Riven Mod: 8.14%\n"
                            + "Pistol Riven Mod: 7.61%\n"
                            + "Rifle Riven Mod: 6.79%\n"
                            + "Affinity Booster: 3.27%\n"
                            + "Mod Drop Chance Booster: 3.27%\n"
                            + "Resource Drop Chance Booster: 3.27%\n"
                            + "Orokin Catalyst Blueprint: 2.5%\n"
                            + "Orokin Reactor Blueprint: 2.5%\n"
                            + "Exilus Warframe Adapter: 2.5%\n"
                            + "Forma x3: 2.5%\n"
                            + "Kitgun Riven Mod: 2%\n"
                            + "Zaw Riven Mod: 2%\n"
                            + "Shotgun Riven Mod: 1.36%\n"
                            + "Legendary Core: 0.18%";
                    rewardsTextView.setText(rewardText);
                } else {
                    Toast.makeText(ArchonHuntActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArchonHunt> call, Throwable t) {
                Toast.makeText(ArchonHuntActivity.this, "Failure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}