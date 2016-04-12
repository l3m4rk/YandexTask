package edu.l3m4rk.yandextask.controller.db;

import android.support.annotation.NonNull;

import edu.l3m4rk.yandextask.model.db.Artist;

public final class ArtistHolder {

    private Artist mArtist;

    private ArtistHolder() {
    }

    public void save(Artist artist) {
        mArtist = artist;
    }

    public Artist load() {
        return mArtist;
    }

    private static class Holder {
        private static final ArtistHolder INSTANCE = new ArtistHolder();
    }

    @NonNull
    public static ArtistHolder getInstance() {
        return Holder.INSTANCE;
    }
}
