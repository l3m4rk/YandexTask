package edu.l3m4rk.yandextask.controller.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.l3m4rk.yandextask.R;
import edu.l3m4rk.yandextask.model.db.Artist;

public final class ArtistListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Artist> mArtists;

    // TODO: 06.04.16 realize adapter

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

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Artist artist) {
            // TODO: 06.04.16 bind artist
        }
    }
}
