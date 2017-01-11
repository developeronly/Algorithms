package com.example.chapter1.bagsqueuesstacks;

import java.util.Iterator;

//Implementing stack using linked list
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int numberOfItems;

    public int size() {
        return numberOfItems;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item element) {
        //Add element to the beginning of list
        Node oldFirst = first;
        first = new Node();
        first.item = element;
        first.next = oldFirst;
        numberOfItems++;
    }

    public Item pop() {
        //Remove element to the beginning of list
        if (isEmpty()) throw new IllegalStateException("Empty stack.");
        Item item = first.item;
        first = first.next;
        numberOfItems--;
        return item;
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
