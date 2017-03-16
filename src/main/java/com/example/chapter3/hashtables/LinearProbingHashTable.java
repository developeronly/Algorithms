package com.example.chapter3.hashtables;

import com.example.chapter1.bagsqueuesstacks.Queue;

public class LinearProbingHashTable<Key, Value> implements HashSymbolTable<Key, Value> {

    private static final int DEFAULT_SIZE = 4;

    private int numberOfKeyValPairs;
    private int tableSize;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashTable() {
        this(DEFAULT_SIZE);
    }

    public LinearProbingHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.numberOfKeyValPairs = 0;
        this.keys = (Key[]) new Object[tableSize];
        this.values = (Value[]) new Object[tableSize];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }

    private void resize(int size) {
        LinearProbingHashTable<Key, Value> temp = new LinearProbingHashTable<Key, Value>(size);
        for (int index = 0; index < tableSize; index++) {
            if (keys[index] != null) {
                temp.put(keys[index], values[index]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        tableSize = temp.tableSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return numberOfKeyValPairs;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        if (value == null) {
            delete(key);
            return;
        }

        if (numberOfKeyValPairs >= tableSize / 2) resize(tableSize * 2);
        int keyHash;
        for (keyHash = hash(key); keys[keyHash] != null; keyHash = (keyHash + 1) % tableSize) {
            if (keys[keyHash].equals(key)) {
                values[keyHash] = value;
                return;
            }
        }

        keys[keyHash] = key;
        values[keyHash] = value;
        numberOfKeyValPairs++;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        if (!contains(key)) return;

        int keyHash = hash(key);
        while (!key.equals(keys[keyHash])) {
            keyHash = (keyHash + 1) % tableSize;
        }

        keys[keyHash] = null;
        values[keyHash] = null;

        keyHash = (keyHash + 1) % tableSize;
        while (keys[keyHash] != null) {
            Key keyToRehash = keys[keyHash];
            Value valToRehash = values[keyHash];
            keys[keyHash] = null;
            values[keyHash] = null;
            numberOfKeyValPairs--;
            put(keyToRehash, valToRehash);
            keyHash = (keyHash + 1) % tableSize;
        }

        numberOfKeyValPairs--;
        if (numberOfKeyValPairs > 0 && numberOfKeyValPairs <= tableSize / 8) resize(tableSize / 2);
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        for (int keyHash = hash(key); keys[keyHash] != null; keyHash = (keyHash + 1) % tableSize)
            if (keys[keyHash].equals(key))
                return values[keyHash];
        return null;
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("Key can't be null.");
        return get(key) != null;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int index = 0; index < tableSize; index++)
            if (keys[index] != null) queue.enqueue(keys[index]);
        return queue;
    }
}
