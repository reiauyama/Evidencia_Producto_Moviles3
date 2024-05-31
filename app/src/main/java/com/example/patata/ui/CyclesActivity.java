package com.example.patata.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.patata.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CyclesActivity extends AppCompatActivity {

    private TextView cetusTimeLeft, cetusState, vallisTimeLeft, vallisState, cambionTimeLeft, cambionState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycles);

        cetusTimeLeft = findViewById(R.id.cetusTimeLeft);
        cetusState = findViewById(R.id.cetusState);
        vallisTimeLeft = findViewById(R.id.vallisTimeLeft);
        vallisState = findViewById(R.id.vallisState);
        cambionTimeLeft = findViewById(R.id.cambionTimeLeft);
        cambionState = findViewById(R.id.cambionState);

        new FetchCycleDataTask().execute();
    }

    private class FetchCycleDataTask extends AsyncTask<Void, Void, Void> {
        private CetusCycle cetusCycle;
        private VallisCycle vallisCycle;
        private CambionCycle cambionCycle;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                // Cetus Cycle
                URL cetusUrl = new URL("https://api.warframestat.us/pc/cetusCycle/");
                HttpURLConnection cetusConnection = (HttpURLConnection) cetusUrl.openConnection();
                cetusConnection.setRequestMethod("GET");
                BufferedReader cetusReader = new BufferedReader(new InputStreamReader(cetusConnection.getInputStream()));
                cetusCycle = new Gson().fromJson(cetusReader, CetusCycle.class); // Actualiza la variable de instancia
                cetusReader.close();

                // Vallis Cycle
                URL vallisUrl = new URL("https://api.warframestat.us/pc/vallisCycle/");
                HttpURLConnection vallisConnection = (HttpURLConnection) vallisUrl.openConnection();
                vallisConnection.setRequestMethod("GET");
                BufferedReader vallisReader = new BufferedReader(new InputStreamReader(vallisConnection.getInputStream()));
                vallisCycle = new Gson().fromJson(vallisReader, VallisCycle.class); // Actualiza la variable de instancia
                vallisReader.close();

                // Cambion Cycle
                URL cambionUrl = new URL("https://api.warframestat.us/pc/cambionCycle/");
                HttpURLConnection cambionConnection = (HttpURLConnection) cambionUrl.openConnection();
                cambionConnection.setRequestMethod("GET");
                BufferedReader cambionReader = new BufferedReader(new InputStreamReader(cambionConnection.getInputStream()));
                cambionCycle = new Gson().fromJson(cambionReader, CambionCycle.class); // Actualiza la variable de instancia
                cambionReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (cetusCycle != null) {
                cetusTimeLeft.setText(cetusCycle.timeLeft);
                cetusState.setText(cetusCycle.state);
            }

            if (vallisCycle != null) {
                vallisTimeLeft.setText(vallisCycle.timeLeft);
                vallisState.setText(vallisCycle.state);
            }

            if (cambionCycle != null) {
                cambionTimeLeft.setText(cambionCycle.timeLeft);
                cambionState.setText(cambionCycle.state);
            }
        }
    }

    class CetusCycle {
        String timeLeft;
        String state;
    }

    class VallisCycle {
        String timeLeft;
        String state;
    }

    class CambionCycle {
        String timeLeft;
        String state;
    }
}
