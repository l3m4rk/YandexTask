package edu.l3m4rk.yandextask.presentation.view;

import android.support.annotation.NonNull;

import edu.l3m4rk.yandextask.model.db.Artist;

public interface ArtistDetailsView extends BaseView {

    void showArtistDetails(@NonNull Artist artist);

}
