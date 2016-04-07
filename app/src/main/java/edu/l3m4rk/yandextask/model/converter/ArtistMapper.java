package edu.l3m4rk.yandextask.model.converter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.l3m4rk.yandextask.model.db.Artist;
import edu.l3m4rk.yandextask.model.network.NWArtist;
import edu.l3m4rk.yandextask.model.network.NWCover;

public final class ArtistMapper {
    private ArtistMapper() {

    }

    @Nullable
    public static Artist transform(NWArtist nwArtist) {
        Artist artist = null;
        if (nwArtist != null) {
            long id = nwArtist.getId();
            String name = nwArtist.getName();
            int tracks = nwArtist.getTracksCount();
            int albums = nwArtist.getAlbumsCount();
            String link = nwArtist.getLink();
            String description = nwArtist.getDescription();
            List<String> genres = nwArtist.getGenres();
            final NWCover cover = nwArtist.getCover();
            String smallUrl = cover.getSmallCoverUrl();
            String bigUrl = cover.getSmallCoverUrl();
            artist = new Artist(id, name, tracks, albums, link, description, genres, smallUrl, bigUrl);
        }
        return artist;
    }

    @NonNull
    public static List<Artist> transform(Collection<NWArtist> artistCollection) {
        List<Artist> artistList = new ArrayList<>();
        if (artistCollection != null) {
            Stream.of(artistCollection)
                    .filter(it -> it != null)
                    .map(ArtistMapper::transform)
                    .collect(Collectors.toList());
        }
        return artistList;
    }
}
