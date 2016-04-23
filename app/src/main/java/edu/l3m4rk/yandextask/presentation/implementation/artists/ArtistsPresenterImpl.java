package edu.l3m4rk.yandextask.presentation.implementation.artists;

import android.support.annotation.NonNull;

import java.util.List;

import edu.l3m4rk.yandextask.controller.db.InMemoryArtistRepository;
import edu.l3m4rk.yandextask.controller.db.Repository;
import edu.l3m4rk.yandextask.controller.network.ApiFactory;
import edu.l3m4rk.yandextask.interactor.artists.ArtistsInteractorImpl;
import edu.l3m4rk.yandextask.interactor.artists.ArtistsInteractor;
import edu.l3m4rk.yandextask.model.converter.ArtistMapper;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.model.network.NWArtist;
import edu.l3m4rk.yandextask.presentation.presenter.artists.ArtistsPresenter;
import edu.l3m4rk.yandextask.presentation.view.artists.ArtistsView;

public final class ArtistsPresenterImpl implements ArtistsPresenter {

    private static final String TAG = "ArtistsPresenterImpl";

    private final ArtistsView mView;
    private final Repository<Artist> mRepository;
    private final ArtistsInteractor mArtistsInteractor;

    public ArtistsPresenterImpl(@NonNull ArtistsView view) {
        mView = view;
        mArtistsInteractor = new ArtistsInteractorImpl(ApiFactory.getAPI());
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
        mArtistsInteractor.get(new ArtistsInteractor.LoadedCallback() {
            @Override
            public void onLoaded(List<NWArtist> items) {
                mView.hideProgress();
                List<Artist> artists = ArtistMapper.transform(items);
                if (artists.isEmpty()) {
                    mView.showEmpty();
                } else {
                    mView.showArtists(artists);
                    mRepository.add(artists);
                }
            }

            @Override
            public void onError(@NonNull String message) {
                mView.hideProgress();
                mView.showError(message);
            }
        });
    }

    @Override
    public void stopLoad() {
        mArtistsInteractor.stop();
    }
}
