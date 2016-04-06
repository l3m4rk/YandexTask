package edu.l3m4rk.yandextask;

import android.app.Application;

public final class App extends Application {

    private static App sInstance;

    public App() {
        sInstance = this;
    }

    public static App getContext() {
        return sInstance;
    }
}
