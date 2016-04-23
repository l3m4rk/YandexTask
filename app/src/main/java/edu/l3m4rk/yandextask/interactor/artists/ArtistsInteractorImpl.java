package edu.l3m4rk.yandextask.interactor.artists;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;

import java.util.List;

import edu.l3m4rk.yandextask.controller.network.api.ServerApi;
import edu.l3m4rk.yandextask.model.converter.DataMapper;
import edu.l3m4rk.yandextask.model.network.NWArtist;
import edu.l3m4rk.yandextask.util.ErrorMessageFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ArtistsInteractorImpl implements ArtistsInteractor {

    private final Call<JsonArray> mArtistCall;

    public ArtistsInteractorImpl(@NonNull ServerApi serverApi) {
        mArtistCall = serverApi.getArtists();
    }

    @Override
    public void get(LoadedCallback callback) {
        mArtistCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful()) {
                    List<NWArtist> artists = DataMapper.convert(response.body());
                    callback.onLoaded(artists);
                } else {
                    callback.onError(ErrorMessageFactory.createFromResponse(response));
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                callback.onError(ErrorMessageFactory.createNetworkFail());
            }
        });
    }

    @Override
    public void stop() {
        if (mArtistCall.isExecuted() && !mArtistCall.isCanceled()) {
            mArtistCall.cancel();
        }
    }
}
