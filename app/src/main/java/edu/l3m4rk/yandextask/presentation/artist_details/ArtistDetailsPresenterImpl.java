package edu.l3m4rk.yandextask.presentation.artist_details;

import edu.l3m4rk.yandextask.controller.db.ArtistHolder;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.view.ArtistDetailsView;

public final class ArtistDetailsPresenterImpl implements ArtistDetailsPresenter {

    private final ArtistDetailsView mView;

    public ArtistDetailsPresenterImpl(ArtistDetailsView view) {
        mView = view;
    }

    @Override
    public void loadArtistDetails() {
        final Artist artist = ArtistHolder.getInstance().load();
        mView.showArtistDetails(artist);
    }
}
