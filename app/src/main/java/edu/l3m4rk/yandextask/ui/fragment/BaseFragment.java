package edu.l3m4rk.yandextask.ui.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import edu.l3m4rk.yandextask.ui.activity.BaseActivity;

public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected final void initTitle(@NonNull String title) {
        ActionBar toolbar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (toolbar != null) {
            toolbar.setTitle(title);
        }
    }

}
