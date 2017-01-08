package com.example.chapter1.bagsqueuesstacks;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int numberOfItems;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return numberOfItems;
    }

    public void add(Item element) {
        //Same as push inside stack class. Add element to the beginning of list.
        Node oldFirst = first;
        first = new Node();
        first.item = element;
        first.next = oldFirst;
        numberOfItems++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
