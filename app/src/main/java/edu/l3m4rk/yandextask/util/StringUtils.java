package edu.l3m4rk.yandextask.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;
import java.util.Locale;

import edu.l3m4rk.yandextask.App;
import edu.l3m4rk.yandextask.R;

public final class StringUtils {

    private static final String DELIMITER = ", ";

    private StringUtils() {

    }

    @NonNull
    public static String formatAlbumsAndTracks(int albumsCount, int tracksCount) {
        return String.format(Locale.getDefault(), App.getContext().getString(R.string.artist_item_albums_songs), albumsCount, tracksCount);
    }

    @NonNull
    public static String formatGenres(List<String> genres) {
        return TextUtils.join(DELIMITER, genres);
    }

    @NonNull
    public static String formatAlbumsAndTracksDetails(int albums, int tracks) {
        return String.format(App.getContext().getString(R.string.artist_details_albums_songs), albums, tracks);
    }
}
