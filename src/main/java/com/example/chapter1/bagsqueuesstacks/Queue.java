package com.example.chapter1.bagsqueuesstacks;

import java.util.Iterator;

//Implemented FIFO Queue based on LinkedList
public class Queue<Item> implements Iterable<Item> {

    private int numberOfItems;
    private Node first;
    private Node last;

    public int size() {
        return numberOfItems;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item element) {
        //Add element to the end of the list.
        Node oldLast = last;
        last = new Node();
        last.item = element;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        numberOfItems++;
    }

    public Item dequeue() {
        //Remove element from the beginning of the list.
        if (isEmpty()) throw new IllegalStateException("Empty queue.");
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        numberOfItems--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class QueueIterator implements Iterator<Item> {

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
