package edu.l3m4rk.yandextask.presentation.view.artists;

import android.support.annotation.NonNull;

import java.util.List;

import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.view.BaseView;

public interface ArtistsView extends BaseView {

    void showArtists(@NonNull List<Artist> artists);

    void showEmpty();

}
