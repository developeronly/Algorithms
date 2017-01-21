package com.example.chapter2.elementarysorts;

public class SelectionSort extends Sorter {

    @Override
    public void sort(Comparable[] input) {
        int length = input.length;
        for (int elementIndexToBeSwap = 0; elementIndexToBeSwap < length; elementIndexToBeSwap++) {
            int min = elementIndexToBeSwap;
            for (int indexOfMin = elementIndexToBeSwap + 1; indexOfMin < length; indexOfMin++) {
                if (isLess(input[indexOfMin], input[elementIndexToBeSwap]))
                    min = indexOfMin;
            }
            exchange(input, elementIndexToBeSwap, min);
        }
    }

}
