package com.example.moive;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("/")
    Call<MovieResponse> getMovieList(@Query("s") String searchTerm, @Query("apikey") String apiKey);

}