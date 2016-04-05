package edu.l3m4rk.yandextask.ui.fragment.artists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.ui.fragment.BaseFragment;

public class ArtistsFragment extends BaseFragment {

    public static ArtistsFragment newInstance() {
        Bundle args = new Bundle();
        ArtistsFragment fragment = new ArtistsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ArtistsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artists, container, false);
    }
}
