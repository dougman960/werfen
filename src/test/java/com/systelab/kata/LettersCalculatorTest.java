package com.systelab.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LettersCalculatorTest {

    @Test
    public void test1() {
        assertEquals("f", LettersCalculator.addLetters("a", "b", "c"));
    }

    @Test
    public void test2() {
        assertEquals("z", LettersCalculator.addLetters("z"));
    }

    @Test
    public void test3() {
        assertEquals("c", LettersCalculator.addLetters("a", "b"));
    }

    @Test
    public void test4() {
        assertEquals("c", LettersCalculator.addLetters("c"));
    }

    @Test
    public void test5() {
        assertEquals("a", LettersCalculator.addLetters("z", "a"));
    }

    @Test
    public void test6() {
        assertEquals("d", LettersCalculator.addLetters("y", "c", "b"));
    }

    @Test
    public void test7() {
        assertEquals("z", LettersCalculator.addLetters());
    }
}
