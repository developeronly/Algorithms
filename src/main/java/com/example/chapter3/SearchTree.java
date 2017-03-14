package com.example.chapter3;

public interface SearchTree<Key extends Comparable<Key>, Value> {
    int size();

    boolean isEmpty();

    void put(Key key, Value value);

    Value get(Key key);

    boolean contains(Key key);

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    Key select(int index);

    int rank(Key key);

    void deleteMin();

    void deleteMax();

    void delete(Key key);

    void print();

    Iterable<Key> keys();

    Iterable<Key> keys(Key low, Key high);
}
