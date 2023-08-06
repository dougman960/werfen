package com.systelab.kata;


import java.util.ArrayList;

public class MexicanWave {
    public static String[] wave(String str) {

        ArrayList stringArray = new ArrayList();

        for(Integer i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if(letter != ' '){
                stringArray.add(str.substring(0, i) + Character.toUpperCase(letter) + str.substring(i + 1));
            }
        }

        return (String[]) stringArray.toArray(new String[stringArray.size()]);
    }
}