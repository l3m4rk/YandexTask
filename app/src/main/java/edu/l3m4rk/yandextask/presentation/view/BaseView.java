package edu.l3m4rk.yandextask.presentation.view;

import android.support.annotation.NonNull;

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showError(@NonNull String message);
}
