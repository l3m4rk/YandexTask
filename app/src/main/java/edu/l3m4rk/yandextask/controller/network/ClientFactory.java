package edu.l3m4rk.yandextask.controller.network;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class ClientFactory {

    private static final int CONNECT_TIMEOUT_MILLIS = 120_000;
    private static final int READ_TIMEOUT_MILLIS = 120_000;

    private ClientFactory() {
    }

    @NonNull
    public static OkHttpClient create() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        client.readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(NetworkConstants.LOG_LEVEL);
        client.addInterceptor(loggingInterceptor);
        return client.build();
    }
}
