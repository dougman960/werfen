package com.systelab.kata;

import java.util.Arrays;

public class EvenNumbers {
    public static int[] divisibleBy(int[] numbers, int divider) {
        // Your code here.
        int [] divisible = Arrays.stream(numbers)
                                 .filter( c -> (c % divider ) == 0)
                                 .toArray();
        return divisible;
    }
}
