package edu.l3m4rk.yandextask.model.converter;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import edu.l3m4rk.yandextask.model.network.NWArtist;

public final class DataMapper {
    private static final String TAG = "DataMapper";
    private DataMapper() {
    }

    private static final Gson sGson = new Gson();

    @NonNull
    public static List<NWArtist> convert(JsonArray jsonArray) {
        return sGson.fromJson(jsonArray, new TypeToken<List<NWArtist>>(){}.getType());
    }
}
