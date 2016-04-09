package edu.l3m4rk.yandextask.ui.fragment.artist_details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.view.ArtistDetailsView;
import edu.l3m4rk.yandextask.ui.fragment.BaseFragment;

public final class ArtistDetailsFragment extends BaseFragment implements ArtistDetailsView {

    private static final String TAG = "ArtistDetailsFragment";
    private static final String PARAM_ARTIST_ID = "ARTIST_ID";
    private long mArtistId;

    public ArtistDetailsFragment() {
    }

    public static ArtistDetailsFragment newInstance(long artistId) {
        Bundle args = new Bundle();
        args.putLong(PARAM_ARTIST_ID, artistId);
        ArtistDetailsFragment fragment = new ArtistDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mArtistId = getArguments().getLong(PARAM_ARTIST_ID);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_artist_details, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initTitle("Артист " + mArtistId);
    }

    @Override
    public void showArtistDetails(@NonNull Artist artist) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(@NonNull String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
