package com.example.chapter2.quicksort;

public class QuickSort extends com.example.chapter2.Sorter {

    @Override
    public void sort(Comparable[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(Comparable[] input, int low, int high) {
        if (high <= low) return;
        int pivot = partition(input, low, high);
        quickSort(input, low, pivot - 1);
        quickSort(input, pivot + 1, high);
    }

    private int partition(Comparable[] input, int low, int high) {
        int leftIndex = low;
        int rightIndex = high + 1;
        Comparable pivotElement = input[low];
        while (true) {
            while (isLess(input[++leftIndex], pivotElement))
                if (leftIndex == high) break;
            while (isLess(pivotElement, input[--rightIndex]))
                if (rightIndex == low) break;
            if (leftIndex >= rightIndex) break;
            exchange(input, leftIndex, rightIndex);
        }
        exchange(input, low, rightIndex);
        return rightIndex;
    }

}
