package com.example;

import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();
    public int[] generateTenNumbers() {
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = random.nextInt(10) + 1;
        }
        return numbers;
    }
}