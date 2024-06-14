package com.example.patata.network;

import com.example.patata.models.ArchonHunt;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArchontHuntApi {
    @GET("pc/archonHunt/")
    Call<ArchonHunt> getArchonHunt();
}
