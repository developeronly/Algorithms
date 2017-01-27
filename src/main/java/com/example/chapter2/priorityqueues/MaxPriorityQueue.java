package com.example.chapter2.priorityqueues;

public class MaxPriorityQueue<Item extends Comparable<Item>> extends PriorityQueue {

    private int maxSize;

    public MaxPriorityQueue(int maxSize) {
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

    public Item deleteMax() {
        return (Item) delete();
    }

    public Item max() {
        return (Item) peek();
    }

}
