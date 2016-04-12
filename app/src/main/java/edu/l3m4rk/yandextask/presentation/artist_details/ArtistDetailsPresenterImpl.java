package edu.l3m4rk.yandextask.presentation.artist_details;

import edu.l3m4rk.yandextask.controller.db.InMemoryArtistRepository;
import edu.l3m4rk.yandextask.controller.db.Repository;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.view.ArtistDetailsView;

public final class ArtistDetailsPresenterImpl implements ArtistDetailsPresenter {

    private final ArtistDetailsView mView;
    private final Repository<Artist> mRepository;

    public ArtistDetailsPresenterImpl(ArtistDetailsView view) {
        mView = view;
        mRepository = InMemoryArtistRepository.getInstance();
    }

    @Override
    public void loadArtistDetails(long id) {
        final Artist artist = mRepository.get(id);
        mView.showArtistDetails(artist);
    }
}
