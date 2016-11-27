package com.example.chapter1.basicprogramming;

public class PrimeNumberChecker {

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int iterator = 2; iterator <= Math.sqrt(number); iterator++) {
            if (number % iterator == 0) return false;
        }
        return true;
    }

}

/*
PrimeNumberChecker.isPrime(17);
iterator: 2
iterator: 3
iterator: 4  */
