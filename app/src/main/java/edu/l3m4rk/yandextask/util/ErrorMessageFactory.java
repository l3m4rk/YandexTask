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
         /*
            здесь можно вытащить из ответа сервера объект ошибки
            так как в задании не указан формат ошибки,
            то выводим сообщение, игнорируя объект Response
         */
        return App.getContext().getString(R.string.error_content_loading);
    }

    @NonNull
    public static String createNetworkFail() {
        return App.getContext().getString(R.string.error_network_connection);
    }
}
