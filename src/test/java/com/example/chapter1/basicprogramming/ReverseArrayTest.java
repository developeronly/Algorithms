package com.example.chapter1.basicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayTest {

    @Test
    public void reverseIntArray() {
        int[] inputNumericArray = new int[]{2, 4, 23, 21};
        int[] expectedNumericArray = new int[]{21, 23, 4, 2};
        assertArrayEquals("Testing reversing numeric array...",
                ReverseArray.reverse(inputNumericArray), expectedNumericArray);


    }

}

/*
TODO:
reverse
numeric array
float array
string array
empty array
large array
odd length
even length
*/

