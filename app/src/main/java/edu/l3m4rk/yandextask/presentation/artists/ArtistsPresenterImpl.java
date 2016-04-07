package edu.l3m4rk.yandextask.presentation.artists;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;

import java.util.List;

import edu.l3m4rk.yandextask.controller.network.ApiFactory;
import edu.l3m4rk.yandextask.controller.network.api.ServerApi;
import edu.l3m4rk.yandextask.model.converter.ArtistMapper;
import edu.l3m4rk.yandextask.model.converter.DataMapper;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.model.network.NWArtist;
import edu.l3m4rk.yandextask.presentation.view.ArtistsView;
import edu.l3m4rk.yandextask.util.ErrorMessageFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ArtistsPresenterImpl implements ArtistsPresenter {

    private static final String TAG = "ArtistsPresenterImpl";

    private final ArtistsView mArtistsView;
    private final ServerApi mServerApi;

    public ArtistsPresenterImpl(@NonNull ArtistsView artistsView) {
        mArtistsView = artistsView;
        mServerApi = ApiFactory.getAPI();
    }

    @Override
    public void loadArtists() {
        mArtistsView.showProgress();
        Call<JsonArray> artistsCall = mServerApi.getArtists();
        artistsCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                mArtistsView.hideProgress();
                if (response.isSuccessful()) {
                    // TODO: 08.04.16 refactoring with Stream
                    List<NWArtist> loadArtists = DataMapper.convert(response.body());
                    List<Artist> artists = ArtistMapper.transform(loadArtists);
                    if (artists.isEmpty()) {
                        mArtistsView.showError("Пусто");
                    } else {
                        mArtistsView.showArtists(artists);
                    }
                } else {
                    mArtistsView.showError(ErrorMessageFactory.createFromResponse(response));
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                mArtistsView.hideProgress();
                mArtistsView.showLoadError(ErrorMessageFactory.createNetworkFail());
            }
        });
    }
}
