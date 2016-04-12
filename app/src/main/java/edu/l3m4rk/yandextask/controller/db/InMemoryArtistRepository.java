package edu.l3m4rk.yandextask.controller.db;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.l3m4rk.yandextask.model.db.Artist;

public final class InMemoryArtistRepository implements Repository<Artist> {

    private static final String TAG = "InMemoryRepository";

    private Map<Long, Artist> mArtistsMap;

    private static class Holder {
        private static final InMemoryArtistRepository INSTANCE = new InMemoryArtistRepository();
    }

    private InMemoryArtistRepository() {
        mArtistsMap = new LinkedHashMap<>();
    }

    public static InMemoryArtistRepository getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void add(List<Artist> items) {
        mArtistsMap.clear();
        Stream.of(items).forEach(item -> mArtistsMap.put(item.getId(), item));
    }

    @Override
    public List<Artist> getAll() {
        return Stream.of(mArtistsMap.entrySet())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Artist get(long id) {
        return mArtistsMap.get(id);
    }

    @Override
    public boolean isEmpty() {
        return mArtistsMap.isEmpty();
    }
}
