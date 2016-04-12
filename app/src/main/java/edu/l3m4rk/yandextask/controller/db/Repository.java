package edu.l3m4rk.yandextask.controller.db;

import java.util.List;

public interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

    List<T> getAll();

    T get(long id);

}
