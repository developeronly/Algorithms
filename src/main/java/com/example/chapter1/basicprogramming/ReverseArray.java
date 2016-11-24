package com.example.chapter1.basicprogramming;

//TODO: I'm not in favor of static methods. If someone want's make it better please contribute.
//TODO: I'm not able to make methods generic which accepts primitives. If someone make it better please contribute.
//TODO: Logic seems to duplicated. Refactor it!!
public class ReverseArray {


    public static int[] reverse(int[] numericArray) {
        int arrayLength = numericArray.length;
        if (arrayLength == 0) throw new IllegalArgumentException("Empty array.");
        for (int index = 0; index < arrayLength / 2; index++) {
            int temp = numericArray[index];
            numericArray[index] = numericArray[arrayLength - 1 - index];
            numericArray[arrayLength - index - 1] = temp;
        }
        return numericArray;
    }

    public static double[] reverse(double[] numericArray) {
        int arrayLength = numericArray.length;
        if (arrayLength == 0) throw new IllegalArgumentException("Empty array.");
        for (int index = 0; index < arrayLength / 2; index++) {
            double temp = numericArray[index];
            numericArray[index] = numericArray[arrayLength - 1 - index];
            numericArray[arrayLength - index - 1] = temp;
        }
        return numericArray;
    }

    public static <T> T[] reverse(T[] array) {
        int arrayLength = array.length;
        if (arrayLength == 0) throw new IllegalArgumentException("Empty array.");
        for (int index = 0; index < arrayLength / 2; index++) {
            T temp = array[index];
            array[index] = array[arrayLength - 1 - index];
            array[arrayLength - index - 1] = temp;
        }
        return array;
    }

}
