package com.example.chapter1.basicprogramming;

public class BinarySearchRecursively {


    public static int rank(int[] input, int searchElement) {
        return rank(input, searchElement, 0, input.length - 1);
    }

    private static int rank(int[] input, int searchElement, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (searchElement < input[mid]) return rank(input, searchElement, low, mid - 1);
        if (searchElement > input[mid]) return rank(input, searchElement, mid + 1, high);
        return input[mid];
    }
}
