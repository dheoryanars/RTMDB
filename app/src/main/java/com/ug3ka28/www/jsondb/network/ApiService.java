package com.ug3ka28.www.jsondb.network;

import com.ug3ka28.www.jsondb.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String API_KEY = "?api_key=ab48bf48c8d949fa5eb0ba4f60b41031";

    @GET("movie/popular" + API_KEY)
    Call<MovieResponse> getPopular();

}
