package com.example.android.nytfeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TopApiInterface {
    @GET("home.json")
    Call<TopResponse> getTopStories(@Query("api_key") String apiKey);

//    @GET("movie/{id}")
//    Call<TopResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}

