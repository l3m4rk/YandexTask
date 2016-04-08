package edu.l3m4rk.yandextask.util;

import android.support.annotation.NonNull;

import edu.l3m4rk.yandextask.App;
import edu.l3m4rk.yandextask.R;
import retrofit2.Response;

public final class ErrorMessageFactory {

    private ErrorMessageFactory() {
    }

    @NonNull
    public static String createFromResponse(Response response) {
        // TODO: 08.04.16 parse response for error
        return "";
    }

    @NonNull
    public static String createNetworkFail() {
        return App.getContext().getString(R.string.error_network_connection);
    }
}
