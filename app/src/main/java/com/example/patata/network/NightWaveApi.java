package com.example.patata.network;

import com.example.patata.models.NightwaveResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NightWaveApi {
    @GET("pc/nightwave/")
    Call<NightwaveResponse> getNightwaveData();
}
