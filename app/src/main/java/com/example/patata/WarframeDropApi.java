package com.example.patata;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WarframeDropApi {
    @GET("drops")
    Call<List<Drop>> getDrops();
}
