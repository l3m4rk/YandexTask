package edu.l3m4rk.yandextask.model.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class NWArtist {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("genres")
    private List<String> mGenres;
    @SerializedName("tracks")
    private Integer mTracksCount;
    @SerializedName("albums")
    private Integer mAlbumsCount;
    @SerializedName("link")
    private String mLink;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("cover")
    private NWCover mCover;

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public List<String> getGenres() {
        return mGenres;
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

    public NWCover getCover() {
        return mCover;
    }
}
