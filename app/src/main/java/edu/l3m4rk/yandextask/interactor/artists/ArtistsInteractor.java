package edu.l3m4rk.yandextask.interactor.artists;

import android.support.annotation.NonNull;

import java.util.List;

import edu.l3m4rk.yandextask.model.network.NWArtist;

public interface ArtistsInteractor {

    interface LoadedCallback {
        void onLoaded(List<NWArtist> items);

        void onError(@NonNull String message);
    }

    void get(LoadedCallback callback);

    void stop();

}
