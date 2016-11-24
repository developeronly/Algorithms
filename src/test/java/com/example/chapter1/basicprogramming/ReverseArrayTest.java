package com.example.chapter1.basicprogramming;

import com.example.chapter1.basicprogramming.models.Student;
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

    @Test
    public void reverseFloatArray() {
        double[] inputNumericArray = new double[]{2.3, 4.23, 23.33, 21.55};
        double[] expectedNumericArray = new double[]{21.55, 23.33, 4.23, 2.3};
        assertArrayEquals("Testing reversing float array...",
                ReverseArray.reverse(inputNumericArray), expectedNumericArray, 0.001);

    }

    @Test
    public void reverseStringArray() {
        String[] inputStringArray = new String[]{"A", "v", "b", "F", "k"};
        String[] expectedStringArray = new String[]{"k", "F", "b", "v", "A"};
        assertArrayEquals("Testing reversing string array...",
                ReverseArray.reverse(inputStringArray), expectedStringArray);
    }

    @Test
    public void reverseObjectArray() {
        Student[] inputStudentArray = new Student[3];
        inputStudentArray[0] = new Student(1, "A", "asd");
        inputStudentArray[1] = new Student(2, "B", "zxc");
        inputStudentArray[2] = new Student(3, "C", "qwe");
        Student[] expectedStudentArray = new Student[3];
        expectedStudentArray[2] = new Student(1, "A", "asd");
        expectedStudentArray[1] = new Student(2, "B", "zxc");
        expectedStudentArray[0] = new Student(3, "C", "qwe");
        assertArrayEquals("Testing object array...",
                ReverseArray.reverse(inputStudentArray), expectedStudentArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reverseEmptyArrayOfObjects() {
        String[] emptyArray = new String[]{};
        ReverseArray.reverse(emptyArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reverseEmptyNumericArray() {
        int[] emptyArray = new int[]{};
        ReverseArray.reverse(emptyArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reverseEmptyFloatArray() {
        double[] emptyArray = new double[]{};
        ReverseArray.reverse(emptyArray);
    }

    @Test
    public void reverseLargeArray() {
        int maxSize = 1000;
        String[] inputLargeArray = new String[maxSize];
        String[] expectedLargeArray = new String[maxSize];

        for (int i = 0; i < maxSize; i++) {
            inputLargeArray[i] = new String("" + i);
        }
        for (int i = inputLargeArray.length - 1, j = 0; i >= 0 && j < maxSize; i--, j++) {
            expectedLargeArray[j] = new String("" + i);
        }
        assertArrayEquals("Testing object array...",
                ReverseArray.reverse(inputLargeArray), expectedLargeArray);
    }

}
