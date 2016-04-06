package edu.l3m4rk.yandextask.ui.fragment.artists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.ui.fragment.BaseFragment;

public class ArtistsFragment extends BaseFragment {

    @Bind(R.id.artist_list)
    RecyclerView mArtistsView;
    @Bind(R.id.artist_list_empty)
    View mLoadErrorView;

    public ArtistsFragment() {
    }

    public static ArtistsFragment newInstance() {
        Bundle args = new Bundle();
        ArtistsFragment fragment = new ArtistsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_artists, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initArtistsView();
    }

    private void initArtistsView() {
        mArtistsView.setLayoutManager(new LinearLayoutManager(getContext()));
        mArtistsView.setHasFixedSize(true);
        mArtistsView.setItemAnimator(new DefaultItemAnimator());
//        mArtistsView.setAdapter();
    }

    @Override
    public void onStart() {
        super.onStart();
        mArtistsView.setVisibility(View.VISIBLE);
        mLoadErrorView.setVisibility(View.GONE);
    }
}
