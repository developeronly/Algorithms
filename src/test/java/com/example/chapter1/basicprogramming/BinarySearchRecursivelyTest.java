package com.example.chapter1.basicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchRecursivelyTest {

    //NOTE: Binary search requires a sorted array. So we haven't included tests for unsorted array.

    @Test
    public void searchAvailability() {
        int[] input = new int[]{2, 4, 43, 44, 57};
        int[] availableElement = new int[]{2, 4, 43, 44, 57};
        Assert.assertEquals("Search for valid availability...",
                availableElement[0], BinarySearchRecursively.rank(input, availableElement[0]));
        Assert.assertEquals("Search for valid availability...",
                availableElement[1], BinarySearchRecursively.rank(input, availableElement[1]));
        Assert.assertEquals("Search for valid availability...",
                availableElement[2], BinarySearchRecursively.rank(input, availableElement[2]));
        Assert.assertEquals("Search for valid availability...",
                availableElement[3], BinarySearchRecursively.rank(input, availableElement[3]));
        Assert.assertEquals("Search for valid availability...",
                availableElement[4], BinarySearchRecursively.rank(input, availableElement[4]));
    }

    @Test
    public void searchInAvailability() {
        int[] input = new int[]{2, 4, 43, 44, 57};
        int[] inAvailableElement = new int[]{21, 41, 431, 441, 571};
        int expected = -1;
        Assert.assertEquals("Search for valid availability...",
                expected, BinarySearchRecursively.rank(input, inAvailableElement[0]));
        Assert.assertEquals("Search for valid availability...",
                expected, BinarySearchRecursively.rank(input, inAvailableElement[1]));
        Assert.assertEquals("Search for valid availability...",
                expected, BinarySearchRecursively.rank(input, inAvailableElement[2]));
        Assert.assertEquals("Search for valid availability...",
                expected, BinarySearchRecursively.rank(input, inAvailableElement[3]));
        Assert.assertEquals("Search for valid availability...",
                expected, BinarySearchRecursively.rank(input, inAvailableElement[4]));
    }

}
