package com.example.chapter1.basicprogramming;

import com.example.chapter1.basicprogramming.models.Student;

//TODO: I'm not in favor of static methods. If someone want's make it better please contribute.
//TODO: I'm not able to make methods generic which accepts primitives. If someone make it better please contribute.
//TODO: Logic seems to duplicated. Refactor it!!
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

    public static double[] reverse(double[] numericArray) {
        int arrayLength = numericArray.length;
        for (int index = 0; index < arrayLength / 2; index++) {
            double temp = numericArray[index];
            numericArray[index] = numericArray[arrayLength - 1 - index];
            numericArray[arrayLength - index - 1] = temp;
        }
        return numericArray;
    }


    public static String[] reverse(String[] stringArray) {
        int arrayLength = stringArray.length;
        for (int index = 0; index < arrayLength / 2; index++) {
            String temp = stringArray[index];
            stringArray[index] = stringArray[arrayLength - 1 - index];
            stringArray[arrayLength - index - 1] = temp;
        }
        return stringArray;
    }

    public static Student[] reverse(Student[] studentArray) {
        int arrayLength = studentArray.length;
        for (int index = 0; index < arrayLength / 2; index++) {
            Student temp = studentArray[index];
            studentArray[index] = studentArray[arrayLength - 1 - index];
            studentArray[arrayLength - index - 1] = temp;
        }
        return studentArray;
    }
}
