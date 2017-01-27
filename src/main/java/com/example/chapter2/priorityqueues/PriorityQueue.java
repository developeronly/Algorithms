package com.example.chapter2.priorityqueues;

import java.util.Arrays;

public abstract class PriorityQueue<Item extends Comparable<Item>> {

    private Item[] priorityQueue;
    private int size = 0; //we don't use first index to hold any item.

    public PriorityQueue(int maxSize) {
        priorityQueue = (Item[]) new Comparable[maxSize + 1]; //First index will be always 1 not 0.
    }

    protected abstract Item[] sort();

    protected boolean isEmpty() {
        return size == 0;
    }

    protected int size() {
        return size;
    }

    protected void insert(Item newElement) {
        priorityQueue[++size] = newElement;
        swim(size);
    }

    protected Item delete() {
        Item max = priorityQueue[1];
        exchange(1, size--);
        priorityQueue[size + 1] = null;
        sink(1);
        return max;
    }

    protected Item peek() {
        return priorityQueue[1];
    }

    protected void print() {
        Arrays.asList(priorityQueue).stream().forEach(element -> System.out.println(element));
    }

    private void swim(int index) {
        while (index > 1 && isLess(index / 2, index)) {
            exchange(index / 2, index);
            index = index / 2;
        }
    }

    private void sink(int index) {
        while (2 * index <= size) {
            int elementToBeSwap = 2 * index;
            if (elementToBeSwap < size && isLess(elementToBeSwap, elementToBeSwap + 1))
                elementToBeSwap++;
            if (!isLess(index, elementToBeSwap))
                break;
            exchange(index, elementToBeSwap);
            index = elementToBeSwap;
        }
    }

    private void exchange(int firstElement, int secondElement) {
        Item temp = priorityQueue[firstElement];
        priorityQueue[firstElement] = priorityQueue[secondElement];
        priorityQueue[secondElement] = temp;
    }

    protected boolean isLess(int firstElement, int secondElement) {
        return priorityQueue[firstElement].compareTo(priorityQueue[secondElement]) < 0;
    }

}
