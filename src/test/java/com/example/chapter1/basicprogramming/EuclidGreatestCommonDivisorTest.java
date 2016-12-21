package com.example.chapter1.basicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EuclidGreatestCommonDivisorTest {

    @Test
    public void calculate() {
        assertEquals(6, EuclidGreatestCommonDivisor.calculate(54, 24));
        assertEquals(6, EuclidGreatestCommonDivisor.calculate(24, 54));
        assertEquals(6, EuclidGreatestCommonDivisor.calculate(-24, 54));
        assertEquals(0, EuclidGreatestCommonDivisor.calculate(0, 0));
        assertEquals(-6, EuclidGreatestCommonDivisor.calculate(24, -54));
        assertEquals(-6, EuclidGreatestCommonDivisor.calculate(-24, -54));
    }

}
