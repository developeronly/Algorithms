package com.example.chapter3;

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
    }

    public boolean isEmpty() {
        return first == null;
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

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            size++; //As we are not considering deletion operation we can update size here.
        }
    }


}
