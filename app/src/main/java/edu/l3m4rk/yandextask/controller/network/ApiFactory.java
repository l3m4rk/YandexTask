package edu.l3m4rk.yandextask.controller.network;

import android.support.annotation.NonNull;

import edu.l3m4rk.yandextask.controller.network.api.ServerApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiFactory {

    private static final ServerApi API_INSTANCE = getAPI(NetworkConstants.BASE_ADDRESS);

    @NonNull
    public static ServerApi getAPI() {
        return API_INSTANCE;
    }

    @NonNull
    private static ServerApi getAPI(@NonNull String apiUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(apiUrl);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.client(ClientFactory.create());
        return builder.build().create(ServerApi.class);
    }


    private ApiFactory() {
    }
}
