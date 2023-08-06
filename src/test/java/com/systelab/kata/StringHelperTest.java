package com.systelab.kata;

import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;

public class StringHelperTest {


    @Test
    public void testStringToStringArray(){
        assertTrue(Arrays.equals( new String[]{"hola","que","tal"}, StringHelper.stringToStringArray("hola_que_tal")));
    }

    @Test
    public void testStringArrayToString(){
        assertEquals("hola_que_tal", StringHelper.stringArrayToString(new String[]{"hola","que","tal"}));
    }

    @Test
    public void replaceSubString(){
        assertEquals("aaaakjahshsa" , StringHelper.replaceSubString("smnprqqqq","smnprqqqq","aaaakjahshsa"));
    }

    @Test
    public void replaceSubStringNull(){
        assertEquals("smnprqqqq" , StringHelper.replaceSubString("smnprqqqq","smnprqqqqx",null));
    }

    @Test
    public void replaceSubStringIndexOf(){
        assertEquals("smnprqqqq" , StringHelper.replaceSubString("smnprqqqq","smnprqqqqx","aaakjahshsa"));
    }

    @Test
    public void TestConcatenate(){
        assertEquals("s1" + "s2", StringHelper.concatenate("s1","s2"));
    }

    @Test
    public void TestConcatenateS1Null(){
        assertEquals("s2", StringHelper.concatenate(null,"s2"));
    }

    @Test
    public void TestConcatenateS2Null(){
        assertEquals("s1", StringHelper.concatenate("s1",null));
    }

    @Test
    public void TestConcatenateParamsNull(){
        assertNull(StringHelper.concatenate(null,null));
    }

    @Test
    public void TestHasValue(){
        assertTrue(StringHelper.hasValue("12345D"));
    }

    @Test
    public void TestHasValueParamNull(){
        assertFalse(StringHelper.hasValue(null));
    }

    @Test
    public void TestGetSafeValue(){
        assertEquals("hola_mundo",StringHelper.getSafeValue("hola_mundo"));
    }

    @Test
    public void TestGetSafeValueParamBlanc(){
        assertNotNull(StringHelper.getSafeValue(""));
    }

    @Test
    public void TestGetSafeValueParamNull(){
        assertNotNull(StringHelper.getSafeValue(null));
    }

    @Test
    public void testGetStringWithZeros() {

	String test = StringHelper.getStringWithoutFrontZeros("%000123");
        assertEquals("%123",test);
    }

    @Test
    public void testGetStringWithZeros2() {
        String test = StringHelper.getStringWithoutFrontZeros("000123");
        assertEquals("123",test);
    }


}