package com.example.chapter3.symboltables;

import com.example.chapter1.bagsqueuesstacks.Queue;

public class BinarySearch<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearch(int size) {
        this.keys = (Key[]) new Comparable[size];
        this.values = (Value[]) new Object[size];
    }

    public void put(Key key, Value value) {
        int indexOfKey = rank(key);
        if (indexOfKey < size && keys[indexOfKey].compareTo(key) == 0) {
            values[indexOfKey] = value;
            return;
        }
        for (int index = size; index > indexOfKey; index--) {
            keys[index] = keys[index - 1];
            values[index] = values[index - 1];
        }
        keys[indexOfKey] = key;
        values[indexOfKey] = value;
        size++;
    }

    public Value get(Key key) {
        if (isEmpty()) throw new IllegalStateException("Empty symbol table.");
        int indexOfKey = rank(key);
        if (indexOfKey < size && keys[indexOfKey].compareTo(key) == 0) {
            return values[indexOfKey];
        } else {
            return null;
        }
    }

    private int rank(Key key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = key.compareTo(keys[mid]);
            if (compare < 0) high = mid - 1;
            else if (compare > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalStateException("Invalid key.");
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Key key : keys) {
            queue.enqueue(key);
        }
        return queue;
    }

    public void delete(Key key) {
        int indexOfKey = rank(key);
        if (indexOfKey == size || keys[indexOfKey].compareTo(key) != 0) {
            return;
        }

        for (int j = indexOfKey; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        size--;
        keys[size] = null;  // to avoid loitering
        values[size] = null;
    }

}
