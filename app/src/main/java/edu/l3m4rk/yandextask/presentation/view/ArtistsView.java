package edu.l3m4rk.yandextask.presentation.view;

import android.support.annotation.NonNull;

import java.util.List;

import edu.l3m4rk.yandextask.model.db.Artist;

public interface ArtistsView extends BaseView {

    void showArtists(@NonNull List<Artist> artists);

    void showLoadError(@NonNull String message);

    void showEmpty();

}
