package com.example.chapter2.priorityqueues;

public class PriorityQueueFactory {

    public static PriorityQueue create(PriorityQueueType priority, int initialSize) {
        PriorityQueue priorityQueue;
        switch (priority) {
            case MAX:
                priorityQueue = new MaxPriorityQueue(initialSize);
                break;
            case MIN:
                priorityQueue = new MinPriorityQueue(initialSize);
                break;
            default:
                throw new IllegalStateException("Invalid priority type.");
        }
        return priorityQueue;
    }

}
