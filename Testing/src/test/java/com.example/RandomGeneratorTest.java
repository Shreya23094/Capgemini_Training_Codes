package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {
    @Test
    void testGenerateExactlyTenNumbers() {
        RandomGenerator generator = new RandomGenerator();
        int[] result = generator.generateTenNumbers();
        assertEquals(10, result.length);
        for (int num : result) {
            assertTrue(num >= 1 && num <= 10);
        }
        //Stream API
        Arrays.stream(result);
    }
}
