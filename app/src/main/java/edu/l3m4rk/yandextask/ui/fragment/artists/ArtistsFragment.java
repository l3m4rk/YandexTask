package edu.l3m4rk.yandextask.ui.fragment.artists;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.controller.adapter.ArtistListAdapter;
import edu.l3m4rk.yandextask.controller.listener.RecyclerViewItemClickListener;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.presentation.artists.ArtistsPresenter;
import edu.l3m4rk.yandextask.presentation.artists.ArtistsPresenterImpl;
import edu.l3m4rk.yandextask.presentation.view.ArtistsView;
import edu.l3m4rk.yandextask.ui.fragment.BaseFragment;
import edu.l3m4rk.yandextask.ui.view.DividerItemDecoration;

public final class ArtistsFragment extends BaseFragment implements ArtistsView {

    private static final String TAG = "ArtistsFragment";

    @Bind(R.id.artist_list)
    RecyclerView mArtistsView;
    @Bind(R.id.artist_list_empty)
    View mLoadErrorView;
    private ArtistListAdapter mAdapter;
    private ArtistsPresenter mArtistsPresenter;
    private ProgressDialog mProgressDialog;
    private OnItemSelectedListener mListener;

    public interface OnItemSelectedListener {
        void onItemSelected(long selectedId);
    }

    public ArtistsFragment() {
    }

    public static ArtistsFragment newInstance() {
        Bundle args = new Bundle();
        ArtistsFragment fragment = new ArtistsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            mListener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.getPackageName() +
                    " must implements OnItemSelectedListener");
        }
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
        initProgressDialog();
        initTitle(getString(R.string.artists_title));
//        ((BaseActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mArtistsPresenter = new ArtistsPresenterImpl(this);
    }

    private void initProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage(getContext().getString(R.string.dialog_loading));
    }

    private void initArtistsView() {
        mArtistsView.setLayoutManager(new LinearLayoutManager(getContext()));
        mArtistsView.setHasFixedSize(true);
        mArtistsView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ArtistListAdapter();
        mArtistsView.setAdapter(mAdapter);
        mArtistsView.addItemDecoration(new DividerItemDecoration(getContext()));
        mArtistsView.addOnItemTouchListener(getListener());
    }

    @NonNull
    private RecyclerViewItemClickListener getListener() {
        return new RecyclerViewItemClickListener(getContext(), (View view, int position) -> {
            final long selectedId = mAdapter.getItemAt(position).getId();
            Log.i(TAG, "getListener: id " + selectedId);
            mListener.onItemSelected(selectedId);
        });
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
        // TODO: 08.04.16 show empty view
    }

    @Override
    public void showProgress() {
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
