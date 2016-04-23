package edu.l3m4rk.yandextask.model.network;

import com.google.gson.annotations.SerializedName;

public final class NWCover {

    @SerializedName("small")
    private String mSmallCoverUrl;
    @SerializedName("big")
    private String mBigCoverUrl;

    public String getSmallCoverUrl() {
        return mSmallCoverUrl;
    }

    public String getBigCoverUrl() {
        return mBigCoverUrl;
    }
}
