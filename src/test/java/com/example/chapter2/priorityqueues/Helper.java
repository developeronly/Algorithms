package com.example.chapter2.priorityqueues;

public class Helper<Item extends Comparable<Item>> {

    public boolean isSortedInMax(Item[] input) {
        for (int index = 1; index < input.length; index++) {
            if (!isLess(input[index], input[index - 1])) return false;
        }
        return true;
    }

    public boolean isSortedInMin(Item[] input) {
        for (int index = 1; index < input.length; index++) {
            if (isLess(input[index], input[index - 1])) return false;
        }
        return true;
    }

    private boolean isLess(Item firstElement, Item secondElement) {
        return firstElement.compareTo(secondElement) < 0;
    }

}
