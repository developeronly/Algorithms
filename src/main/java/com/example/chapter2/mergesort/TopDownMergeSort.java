package com.example.chapter2.mergesort;

public class TopDownMergeSort extends com.example.chapter2.Sorter {

    private Comparable[] auxiliary;

    @Override
    public void sort(Comparable[] input) {
        auxiliary = new Comparable[input.length];
        mergeSort(input, 0, input.length - 1);
    }

    private void mergeSort(Comparable[] input, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        //auxiliary = Arrays.copyOf(input, input.length);

        mergeSort(input, low, mid);
        mergeSort(input, mid + 1, high);
        mergeSortedArrays(input, low, mid, high);
    }

    private void mergeSortedArrays(Comparable[] input, int low, int mid, int high) {
        int lowIndex = low;
        int midIndex = mid + 1;

        for (int index = low; index <= high; index++) {
            auxiliary[index] = input[index];
        }

        for (int index = low; index <= high; index++) {
            if (lowIndex > mid) input[index] = auxiliary[midIndex++];
            else if (midIndex > high) input[index] = auxiliary[lowIndex++];
            else if (isLess(auxiliary[midIndex], auxiliary[lowIndex])) input[index] = auxiliary[midIndex++];
            else input[index] = auxiliary[lowIndex++];
        }

    }

}
