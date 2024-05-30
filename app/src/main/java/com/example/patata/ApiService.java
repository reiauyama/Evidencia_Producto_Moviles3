package com.example.patata;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("pc/news")
    Call<List<NewsItem>> getNews();
}
