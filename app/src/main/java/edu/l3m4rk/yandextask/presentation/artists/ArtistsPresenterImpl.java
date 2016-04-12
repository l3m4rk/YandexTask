package edu.l3m4rk.yandextask.presentation.artists;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;

import java.util.List;

import edu.l3m4rk.yandextask.controller.db.InMemoryArtistRepository;
import edu.l3m4rk.yandextask.controller.db.Repository;
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

    private final ArtistsView mView;
    private final ServerApi mServerApi;
    private final Repository<Artist> mRepository;

    public ArtistsPresenterImpl(@NonNull ArtistsView view) {
        mView = view;
        mServerApi = ApiFactory.getAPI();
        mRepository = InMemoryArtistRepository.getInstance();
    }

    @Override
    public void loadArtists() {
        mView.showProgress();

        if (!mRepository.isEmpty()) {
            mView.hideProgress();
            mView.showArtists(mRepository.getAll());
            return;
        }

        // TODO: 08.04.16 remove loading in network repository
        Call<JsonArray> artistsCall = mServerApi.getArtists();
        artistsCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                mView.hideProgress();
                if (response.isSuccessful()) {
                    List<NWArtist> loadArtists = DataMapper.convert(response.body());
                    List<Artist> artists = ArtistMapper.transform(loadArtists);
                    if (artists.isEmpty()) {
                        mView.showEmpty();
                    } else {
                        mView.showArtists(artists);
                        mRepository.add(artists);
                    }
                } else {
                    mView.showError(ErrorMessageFactory.createFromResponse(response));
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                mView.hideProgress();
                mView.showLoadError(ErrorMessageFactory.createNetworkFail());
            }
        });
    }
}
