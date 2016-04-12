package edu.l3m4rk.yandextask.controller.db;

import android.support.annotation.NonNull;

import java.util.List;

import edu.l3m4rk.yandextask.model.db.Artist;

public final class ArtistRealmRepository implements Repository<Artist> {

    private static ArtistRealmRepository sInstance;

    private ArtistRealmRepository() {

    }

    public static synchronized ArtistRealmRepository getInstance() {
        if (sInstance == null) {
            sInstance = new ArtistRealmRepository();
        }
        return sInstance;
    }

    @Override
    public void add(Artist item) {

    }

    @Override
    public void add(Iterable<Artist> items) {

    }

    @NonNull
    @Override
    public List<Artist> getAll() {
        return null;
    }

    @NonNull
    @Override
    public Artist get(long id) {
        return null;
    }
}
