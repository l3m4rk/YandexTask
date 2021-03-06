package edu.l3m4rk.yandextask.util;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

import edu.l3m4rk.yandextask.App;
import edu.l3m4rk.yandextask.R;

public final class StringUtils {

    private static final String DELIMITER = ", ";

    private StringUtils() {

    }

    @NonNull
    public static String formatAlbumsAndTracks(int albumsCount, int songsCount) {
        final Resources resources = App.getContext().getResources();
        String albums = resources.getQuantityString(R.plurals.albums, albumsCount, albumsCount);
        String songs = resources.getQuantityString(R.plurals.songs, songsCount, songsCount);
        return App.getContext().getString(R.string.artist_item_albums_songs, albums, songs);
    }

    @NonNull
    public static String formatGenres(List<String> genres) {
        return TextUtils.join(DELIMITER, genres);
    }

    @NonNull
    public static String formatAlbumsAndTracksDetails(int albumsCount, int songsCount) {
        final Resources resources = App.getContext().getResources();
        String albums = resources.getQuantityString(R.plurals.albums, albumsCount, albumsCount);
        String songs = resources.getQuantityString(R.plurals.songs, songsCount, songsCount);
        return App.getContext().getString(R.string.artist_details_albums_songs, albums, songs);
    }
}
