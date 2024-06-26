package com.example.patata.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlertsClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.warframestat.us/pc/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
