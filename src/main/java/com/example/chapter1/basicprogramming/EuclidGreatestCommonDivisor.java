package com.example.chapter1.basicprogramming;

public class EuclidGreatestCommonDivisor {

    public static int calculate(int number1, int number2) {
        System.out.println("number1: " + number1 + " number2 " + number2);
        if (number2 == 0) return number1;
        int rem = number1 % number2;
        return calculate(number2, rem);
    }

    public static void main(String[] args) {
        int gcd = EuclidGreatestCommonDivisor.calculate(13, 23);
        System.out.println(gcd);
/*
        number1: 13 number2 23 //NOTE: Here we can see how modulus works.
        number1: 23 number2 13 //NOTE:When number1 is less than number2 it automatically get reversed
        number1: 13 number2 10
        number1: 10 number2 3
        number1: 3 number2 1
        number1: 1 number2 0
        1
*/
    }
}

