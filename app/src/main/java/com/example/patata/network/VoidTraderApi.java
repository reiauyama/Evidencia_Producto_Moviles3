package com.example.patata.network;

import com.example.patata.models.VoidTrader;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VoidTraderApi {
    @GET("pc/voidTrader/")
    Call<VoidTrader> getVoidTrader();
}
