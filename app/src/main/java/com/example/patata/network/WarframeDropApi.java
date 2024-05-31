package com.example.patata.network;

import com.example.patata.models.Drop;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WarframeDropApi {
    @GET("drops")
    Call<List<Drop>> getDrops();
}
