package com.example.chapter1.bagsqueuesstacks;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private static final int RESIZING_FACTOR = 2;

    private Item[] stack = (Item[]) new Object[1];
    private int capacity = 0;

    public int size() {
        return capacity;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public void push(Item element) {
        if (capacity == currentCapacity()) resize(currentCapacity() * RESIZING_FACTOR);
        stack[capacity++] = element;
    }

    public Item pop() {
        if (capacity == 0) throw new IllegalStateException("Empty stack.");
        Item elementToBePopped = stack[--capacity];
        stack[capacity] = null; //For avoid loitering
        if (capacity > 0 && capacity == (currentCapacity() / 4)) resize(currentCapacity() / RESIZING_FACTOR);
        return elementToBePopped;
    }

    public void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int index = 0; index < capacity; index++)
            temp[index] = stack[index];
        stack = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public int currentCapacity() {
        return stack.length;
    }

    public int getResizingFactor() {
        return RESIZING_FACTOR;
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int index = capacity;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Item next() {
            return stack[--index];
        }

    }

}
