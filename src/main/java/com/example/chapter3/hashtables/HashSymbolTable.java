package com.example.chapter3.hashtables;

public interface HashSymbolTable<Key, Value> {

    boolean isEmpty();

    int size();

    void put(Key key, Value value);

    void delete(Key key);

    Value get(Key key);

    boolean contains(Key key);

    Iterable<Key> keys();
    
}
