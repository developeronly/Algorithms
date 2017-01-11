package com.example.chapter1.bagsqueuesstacks;

public class FixedCapacityStack<Item> {

    private static final int RESIZING_FACTOR = 2;
    private Item[] stack;
    private int capacity;

    public FixedCapacityStack(int capacity) {
        if (capacity == 0) throw new IllegalStateException();
        this.stack = (Item[]) new Object[capacity];
    }

    public int size() {
        return capacity;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    //Note: This method is added to make this code more testable.
    public int currentCapacity() {
        return stack.length;
    }

    //Note: this method can have more restricted access specifier like private but just for writing test cases we
    // make this as public.
    public void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int index = 0; index < capacity; index++)
            temp[index] = stack[index];
        stack = temp;
    }

    public void push(Item element) {
        if (capacity == currentCapacity()) resize(currentCapacity() * RESIZING_FACTOR);
        stack[capacity++] = element;
    }

    public Item pop() {
        if (capacity == 0) throw new IllegalStateException("Empty stack.");
        Item elementToBePopped = stack[--capacity];
        stack[capacity] = null; //For avoiding loitering.
        if (capacity > 0 && capacity == (currentCapacity() / 4)) resize(currentCapacity() / RESIZING_FACTOR);
        return elementToBePopped;
    }

    public int getResizingFactor() {
        return RESIZING_FACTOR;
    }
}
