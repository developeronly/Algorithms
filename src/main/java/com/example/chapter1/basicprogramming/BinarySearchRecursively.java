package com.example.chapter1.basicprogramming;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public final class BinarySearchRecursively {

    public static boolean isPresent(int[] input, int searchElement) {
        if (ArrayUtils.isEmpty(input)) throw new IllegalArgumentException("Empty array.");
        Arrays.sort(input);
        return isPresent(input, searchElement, 0, input.length - 1);
    }

    private static boolean isPresent(int[] input, int searchElement, int low, int high) {
        if (ArrayUtils.isEmpty(input)) throw new IllegalArgumentException("Empty array.");
        Arrays.sort(input);
        if (low > high) return false;
        int mid = low + (high - low) / 2;
        if (searchElement < input[mid]) return isPresent(input, searchElement, low, mid - 1);
        if (searchElement > input[mid]) return isPresent(input, searchElement, mid + 1, high);
        return true;
    }
}
