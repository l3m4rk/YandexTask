package edu.l3m4rk.yandextask.ui.fragment.artist_details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.presenter.artist_details.ArtistDetailsPresenter;
import edu.l3m4rk.yandextask.presentation.implementation.artist_details.ArtistDetailsPresenterImpl;
import edu.l3m4rk.yandextask.presentation.view.artist_details.ArtistDetailsView;
import edu.l3m4rk.yandextask.ui.fragment.BaseFragment;
import edu.l3m4rk.yandextask.util.StringUtils;

public final class ArtistDetailsFragment extends BaseFragment implements ArtistDetailsView {

    private static final String TAG = "ArtistDetailsFragment";
    private static final String PARAM_ARTIST_ID = "ARTIST_ID";
    @Bind(R.id.artist_detail_big_photo)
    ImageView mArtistBigImage;
    @Bind(R.id.artist_description)
    TextView mArtistBio;
    @Bind(R.id.artist_genres)
    TextView mGenres;
    @Bind(R.id.artist_albums_songs)
    TextView mAlbumsSongs;

    private long mArtistId;
    private ArtistDetailsPresenter mPresenter;

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
        mPresenter = new ArtistDetailsPresenterImpl(ArtistDetailsFragment.this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.loadArtistDetails(mArtistId);
    }

    @Override
    public void showArtistDetails(@NonNull Artist artist) {
        initTitle(artist.getName());
        Picasso.with(getContext()).load(artist.getBigCoverUrl()).into(mArtistBigImage);
        mGenres.setText(StringUtils.formatGenres(artist.getGenres()));
        final int albums = artist.getAlbumsCount();
        final int tracks = artist.getTracksCount();
        mAlbumsSongs.setText(StringUtils.formatAlbumsAndTracksDetails(albums, tracks));
        mArtistBio.setText(artist.getDescription());
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
