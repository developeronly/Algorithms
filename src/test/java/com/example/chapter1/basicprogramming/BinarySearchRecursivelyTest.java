package com.example.chapter1.basicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BinarySearchRecursivelyTest {

    @Test
    public void searchAvailability() {
        int[] input = new int[]{2, 4, 43, 44, 57};
        int[] availableElements = new int[]{2, 4, 43, 44, 57};
        Arrays.stream(availableElements)
                .forEach(element -> Assert.assertTrue("Search for valid availability...",
                        BinarySearchRecursively.isPresent(input, element)));
    }

    @Test
    public void searchInAvailability() {
        int[] input = new int[]{2, 4, 43, 44, 57};
        int[] inAvailableElements = new int[]{21, 41, 431, 441, 571};
        Arrays.stream(inAvailableElements)
                .forEach(element -> Assert.assertFalse("Search for invalid availability...",
                        BinarySearchRecursively.isPresent(input, element)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchInEmptyArray() {
        int[] emptyArray = new int[]{};
        BinarySearchRecursively.isPresent(emptyArray, 21);
    }

    @Test
    public void searchInUnSortedArray() {
        int[] input = new int[]{43, 44, 57, 2, 4};
        int availableElement = 44;
        int inAvailableElement = 99;
        Assert.assertTrue("Search for valid availability...",
                BinarySearchRecursively.isPresent(input, availableElement));
        Assert.assertFalse("Search for in valid availability...",
                BinarySearchRecursively.isPresent(input, inAvailableElement));
    }

}
