package edu.l3m4rk.yandextask.presentation.view.artist_details;

import android.support.annotation.NonNull;

import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.view.BaseView;

public interface ArtistDetailsView extends BaseView {

    void showArtistDetails(@NonNull Artist artist);

}
