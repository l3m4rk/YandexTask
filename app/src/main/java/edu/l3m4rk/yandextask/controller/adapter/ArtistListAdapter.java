package edu.l3m4rk.yandextask.controller.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.l3m4rk.yandextask.App;
import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.util.StringUtils;

public final class ArtistListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Artist> mArtists;

    public ArtistListAdapter() {
        mArtists = new ArrayList<>();
    }

    public void addArtists(List<Artist> artists) {
        mArtists.addAll(artists);
        notifyDataSetChanged();
    }

    public void update(List<Artist> artists) {
        mArtists.clear();
        mArtists.addAll(artists);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_artist, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.bind(mArtists.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mArtists.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.artist_small)
        ImageView mSmallImage;
        @Bind(R.id.artist_name)
        TextView mArtistName;
        @Bind(R.id.artist_albums_songs)
        TextView mAlbumsSongs;
        @Bind(R.id.artist_genres)
        TextView mGenres;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Artist artist) {
            final String smallCoverUrl = artist.getSmallCoverUrl();
            Picasso.with(App.getContext()).load(smallCoverUrl).into(mSmallImage);
            mArtistName.setText(artist.getName());
            final int albums = artist.getAlbumsCount();
            final int tracks = artist.getTracksCount();
            mAlbumsSongs.setText(StringUtils.formatAlbumsAndTracks(albums, tracks));
            mGenres.setText(StringUtils.formatGenres(artist.getGenres()));
        }
    }
}
