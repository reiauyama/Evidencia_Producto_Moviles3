package com.example.patata.client;

import com.example.patata.ServiceList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

// Define la interfaz para la API
interface WarframeAPI {
    @GET("pc/fissures/")
    Call<List<ServiceList>> getFissures();
}

public class ApiClient {
    private static final String BASE_URL = "https://api.warframestat.us/";

    // Método para obtener una instancia de la interfaz de la API
    public static WarframeAPI getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WarframeAPI.class);
    }
}
