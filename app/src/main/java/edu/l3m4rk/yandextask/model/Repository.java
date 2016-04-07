package edu.l3m4rk.yandextask.model;

public interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

//    List<T> query(Specification specification);

}
