package com.example.chapter1.bagsqueuesstacks;

public class FixedCapacityStack<Item> {

    private Item[] stack;
    private int capacity;

    public FixedCapacityStack(int capacity) {
        this.stack = (Item[]) new Object[capacity];
    }

    public int size() {
        return capacity;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public void push(Item element) throws ArrayIndexOutOfBoundsException {
        stack[capacity++] = element;
    }

    public Item pop() throws ArrayIndexOutOfBoundsException {
        return stack[--capacity];
    }

}
