package edu.l3m4rk.yandextask.controller.network.api;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerApi {
    @GET("artists.json")
    Call<JsonArray> getArtists();
}
