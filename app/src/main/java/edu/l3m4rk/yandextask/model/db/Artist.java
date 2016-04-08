package edu.l3m4rk.yandextask.model.db;

import java.util.List;

public final class Artist {

    private long mId;
    private String mName;
    private int mTracksCount;
    private int mAlbumsCount;
    private String mLink;
    private String mDescription;
    private List<String> mGenres;
    private String mSmallCoverUrl;
    private String mBigCoverUrl;

    public Artist(long id, String name, int tracksCount, int albumsCount, String link,
                  String description, List<String> genres,
                  String smallCoverUrl, String bigCoverUrl) {
        mId = id;
        mName = name;
        mTracksCount = tracksCount;
        mAlbumsCount = albumsCount;
        mLink = link;
        mDescription = description;
        mGenres = genres;
        mSmallCoverUrl = smallCoverUrl;
        mBigCoverUrl = bigCoverUrl;
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getTracksCount() {
        return mTracksCount;
    }

    public int getAlbumsCount() {
        return mAlbumsCount;
    }

    public String getLink() {
        return mLink;
    }

    public String getDescription() {
        return mDescription;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public String getSmallCoverUrl() {
        return mSmallCoverUrl;
    }

    public String getBigCoverUrl() {
        return mBigCoverUrl;
    }
}
