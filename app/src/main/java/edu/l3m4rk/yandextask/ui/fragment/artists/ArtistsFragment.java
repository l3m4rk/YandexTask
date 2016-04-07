package edu.l3m4rk.yandextask.ui.fragment.artists;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.controller.adapter.ArtistListAdapter;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.artists.ArtistsPresenter;
import edu.l3m4rk.yandextask.presentation.artists.ArtistsPresenterImpl;
import edu.l3m4rk.yandextask.presentation.view.ArtistsView;
import edu.l3m4rk.yandextask.ui.fragment.BaseFragment;

public final class ArtistsFragment extends BaseFragment implements ArtistsView {

    @Bind(R.id.artist_list)
    RecyclerView mArtistsView;
    @Bind(R.id.artist_list_empty)
    View mLoadErrorView;
    private ArtistListAdapter mAdapter;
    private ArtistsPresenter mArtistsPresenter;
    private ProgressDialog mProgressDialog;

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
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Loading...");
        mArtistsPresenter = new ArtistsPresenterImpl(this);
    }

    private void initArtistsView() {
        mArtistsView.setLayoutManager(new LinearLayoutManager(getContext()));
        mArtistsView.setHasFixedSize(true);
        mArtistsView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ArtistListAdapter();
        mArtistsView.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshArtists();
    }

    @OnClick(R.id.retry)
    public void refreshArtists() {
        mArtistsView.setVisibility(View.VISIBLE);
        mLoadErrorView.setVisibility(View.GONE);
        mArtistsPresenter.loadArtists();
    }

    @Override
    public void showArtists(@NonNull List<Artist> artists) {
        mArtistsView.setVisibility(View.VISIBLE);
        mLoadErrorView.setVisibility(View.GONE);
        mAdapter.update(artists);
    }

    @Override
    public void showLoadError(@NonNull String message) {
        mLoadErrorView.setVisibility(View.VISIBLE);
        mArtistsView.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showProgress() {
        // TODO: 08.04.16 show progress dialog
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showError(@NonNull String message) {
        // TODO: 08.04.16 show error dialog
        showToastMessage(message);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
