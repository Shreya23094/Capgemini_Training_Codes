package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgoTest {

    StringAlgo stringAlgo;

    // Runs BEFORE every test method
    @BeforeEach
    void setUp() {
        System.out.println("Setting up test object...");
        stringAlgo = new StringAlgo();
    }

    // Runs AFTER every test method
    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after test...");
        stringAlgo = null;
    }

    @Test
    void testNormalString() {
        String result = stringAlgo.shift2Chars("hello");
        assertEquals("llohe", result);
        System.out.println("Actual : " + result+ "\t Expected : "+"llohe");
    }

    @Test
    void testShortStringLengthTwo() {
        String result = stringAlgo.shift2Chars("hi");
        assertEquals("hi", result);
        System.out.println("Actual : " + result+ "\t Expected : "+"hi");
    }

    @Test
    void testSingleCharacter() {
        String result = stringAlgo.shift2Chars("a");
        assertEquals("a", result);
        System.out.println("Actual : " + result+ "\t Expected : "+"a");
    }
}