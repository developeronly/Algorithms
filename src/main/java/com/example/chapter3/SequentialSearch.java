package com.example.chapter3;

import com.example.chapter1.bagsqueuesstacks.Queue;

//Implemented using unordered linked list.
public class SequentialSearch<Key, Value> {

    private Node first;
    private int size;

    public void put(Key key, Value value) {
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                //If we already having it then update its value.
                current.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        size++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        if (isEmpty()) throw new IllegalStateException("Empty symbol table.");
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node current = first; current != null; current = current.next) {
            queue.enqueue(current.key);
        }
        return queue;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalStateException("Invalid key.");
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Invalid key.");
        first = delete(first, key);
    }

    private Node delete(Node first, Key key) {
        if (first == null) return null;
        if (key.equals(first.key)) {
            size--;
            return first.next;
        }
        first.next = delete(first.next, key);
        return first;
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
