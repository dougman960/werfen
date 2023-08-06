package com.systelab.kata;


public class LettersCalculator {

    public static String addLetters(String... letters) {

        int sum = 0;

        if (letters.length == 0) {
            return "z";
        }

        for (int i = 0; i < letters.length; i++) {
            sum = sum + letters[i].charAt(0) % 96;
        }

        if (sum > 26) {
            sum = sum % 26;
        }

        if (sum < 1) {
            sum = 26;
        }

        return String.valueOf((char) (sum + 96));
    }
}
