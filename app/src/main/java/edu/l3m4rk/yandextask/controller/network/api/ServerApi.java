package edu.l3m4rk.yandextask.controller.network.api;

import edu.l3m4rk.yandextask.controller.network.api.response.ArtistsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerApi {
    @GET("/artists.json")
    Call<ArtistsResponse> getArtists();
}
