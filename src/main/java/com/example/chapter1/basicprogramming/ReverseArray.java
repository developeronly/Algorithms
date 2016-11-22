package com.example.chapter1.basicprogramming;

public class ReverseArray {


    public static int[] reverse(int[] numericArray) {
        int arrayLength = numericArray.length;
        for (int index = 0; index < arrayLength / 2; index++) {
            int temp = numericArray[index];
            numericArray[index] = numericArray[arrayLength - 1 - index];
            numericArray[arrayLength - index - 1] = temp;
        }
        return numericArray;
    }
}

/*
    TODO:
    can we make it generic?
    public static <T> T[] reverse(T[] array) {
        return array;
    }
*/
