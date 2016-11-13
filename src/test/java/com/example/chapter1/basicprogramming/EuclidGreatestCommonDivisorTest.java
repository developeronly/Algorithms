package com.example.chapter1.basicprogramming;


import org.junit.Test;

import static com.example.chapter1.basicprogramming.EuclidGreatestCommonDivisor.calculate;
import static org.junit.Assert.assertEquals;

public class EuclidGreatestCommonDivisorTest {

    @Test
    public void testCalculate() {
        assertEquals(6, calculate(54, 24));
        assertEquals(6, calculate(24, 54));
        assertEquals(6, calculate(-24, 54));
        assertEquals(0, calculate(0, 0));
        assertEquals(-6, calculate(24, -54));
        assertEquals(-6, calculate(-24, -54));
    }

}
