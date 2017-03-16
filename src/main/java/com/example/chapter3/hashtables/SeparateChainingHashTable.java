package com.example.chapter3.hashtables;

import com.example.chapter1.bagsqueuesstacks.Queue;
import com.example.chapter3.symboltables.SequentialSearch;

public class SeparateChainingHashTable<Key, Value> implements HashSymbolTable<Key, Value> {

    private static final int DEFAULT_SIZE = 4;

    private int numberOfKeyValPairs;
    private int tableSize;
    private SequentialSearch<Key, Value>[] sequentialSearches;

    public SeparateChainingHashTable() {
        this(DEFAULT_SIZE);
    }

    public SeparateChainingHashTable(int tableSize) {
        this.tableSize = tableSize;
        sequentialSearches = (SequentialSearch<Key, Value>[]) new SequentialSearch[tableSize];
        for (int index = 0; index < tableSize; index++) {
            sequentialSearches[index] = new SequentialSearch();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }

    private void resize(int size) {
        SeparateChainingHashTable<Key, Value> tempHashTable = new SeparateChainingHashTable<Key, Value>(size);
        for (int index = 0; index < tableSize; index++) {
            for (Key key : sequentialSearches[index].keys()) {
                tempHashTable.put(key, sequentialSearches[index].get(key));
            }
        }

        this.tableSize = tempHashTable.tableSize;
        this.numberOfKeyValPairs = tempHashTable.numberOfKeyValPairs;
        this.sequentialSearches = tempHashTable.sequentialSearches;
    }

    @Override
    public int size() {
        return numberOfKeyValPairs;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        if (value == null) {
            delete(key);
            return;
        }
        if (numberOfKeyValPairs >= 10 * tableSize) resize(2 * tableSize);
        int keyHash = hash(key);
        if (!sequentialSearches[keyHash].contains(key)) numberOfKeyValPairs++;
        sequentialSearches[keyHash].put(key, value);
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        int keyHash = hash(key);
        if (sequentialSearches[keyHash].contains(key)) numberOfKeyValPairs--;
        sequentialSearches[keyHash].delete(key);
        if (tableSize > DEFAULT_SIZE && numberOfKeyValPairs <= 2 * tableSize) resize(tableSize / 2);
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        return sequentialSearches[hash(key)].get(key);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int index = 0; index < tableSize; index++) {
            for (Key key : sequentialSearches[index].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }

}
