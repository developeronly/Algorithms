package com.example.chapter1.bagsqueuesstacks;

public class FixedCapacityStackOfStrings {

    private String[] stack;
    private int capacity;

    public FixedCapacityStackOfStrings(int capacity) {
        this.stack = new String[capacity];
    }

    public int size() {
        return capacity;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public void push(String element) throws ArrayIndexOutOfBoundsException {
        stack[capacity++] = element;
    }

    public String pop() throws ArrayIndexOutOfBoundsException {
        return stack[--capacity];
    }

}
