package com.example.patata.network;

import com.example.patata.models.Fissure;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WarframeApi {
    @GET("pc/fissures/")
    Call<List<Fissure>> getVoidFissures();
}
