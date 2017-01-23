package com.example.chapter2;

public abstract class Sorter {

    public abstract void sort(Comparable[] input);

    public boolean isSorted(Comparable[] input) {
        for (int index = 1; index < input.length; index++) {
            if (isLess(input[index], input[index - 1])) return false;
        }
        return true;
    }

    protected boolean isLess(Comparable firstElement, Comparable secondElement) {
        return firstElement.compareTo(secondElement) < 0;
    }

    protected void exchange(Comparable[] input, int elementIndexToBeSwap, int elementIndexToBeSwapWith) {
        Comparable temp = input[elementIndexToBeSwap];
        input[elementIndexToBeSwap] = input[elementIndexToBeSwapWith];
        input[elementIndexToBeSwapWith] = temp;
    }

}
