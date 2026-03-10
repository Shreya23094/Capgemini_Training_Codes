package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SumSqaureDigitRepeatTest {

    @ParameterizedTest
    @CsvSource({
            "16, 8",
            "14, -1"
    })
    void teststepsToGetBackWithSumDigitSquare(int input, int expected) {

        SumSqaureDigitRepeat ssdr = new SumSqaureDigitRepeat();
        int result = ssdr.stepsToGetBackWithSumDigitSquare(input);

        assertEquals(expected, result);
    }
}