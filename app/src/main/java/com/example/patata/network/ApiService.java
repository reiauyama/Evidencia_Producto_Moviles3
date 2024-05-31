package com.example.patata.network;

import com.example.patata.models.NewsItem;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("pc/news/")
    Call<List<NewsItem>> getNews();
}
