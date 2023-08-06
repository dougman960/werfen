package com.systelab.kata;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class EvenNumbersTest {

    @Test
    public void test1() {
        assertTrue(Arrays.equals(new int[]{2, 4, 6}, EvenNumbers.divisibleBy(new int[]{1, 2, 3, 4, 5, 6}, 2)));
    }

    @Test
    public void test2() {
        assertTrue(Arrays.equals(new int[]{3, 6}, EvenNumbers.divisibleBy(new int[]{1, 2, 3, 4, 5, 6}, 3)));
    }

    @Test
    public void test3() {
        assertTrue(Arrays.equals(new int[]{0, 4}, EvenNumbers.divisibleBy(new int[]{0, 1, 2, 3, 4, 5, 6}, 4)));
    }
}
