package com.example.chapter2.priorityqueues;

public class MinPriorityQueue<Item extends Comparable<Item>> extends PriorityQueue {

    private int maxSize;

    public MinPriorityQueue(int maxSize) {
        super(maxSize);
        this.maxSize = maxSize;
    }

    @Override
    public Item[] sort() {
        Item[] sortedArray = (Item[]) new Comparable[maxSize];
        int index = 0;
        while (!isEmpty()) {
            sortedArray[index] = (Item) delete();
            index++;
        }
        return sortedArray;
    }

    public Item deleteMin() {
        return (Item) delete();
    }

    public Item min() {
        return (Item) peek();
    }

    public boolean isLess(int firstElement, int secondElement) {
        return !super.isLess(firstElement, secondElement);
    }

}
