package com.example.chapter1.basicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeNumberCheckerTest {

    @Test
    public void checkIsPrime() {
        assertTrue("Test for simple true prime...", PrimeNumberChecker.isPrime(5));
        assertTrue("Test for simple true prime...", PrimeNumberChecker.isPrime(17));
        assertFalse("Test for simple false prime...", PrimeNumberChecker.isPrime(6));
        assertFalse("Test for simple false prime...", PrimeNumberChecker.isPrime(0));
        assertFalse("Test for simple false prime...", PrimeNumberChecker.isPrime(1));
    }

}
