package com.example.patata.network;

import com.example.patata.models.Alert;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlertsApi {
    @GET("alerts/")
    Call<List<Alert>> getAlerts();
}
