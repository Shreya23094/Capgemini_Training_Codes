package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BubbleSortTesting {

    @Test
    void testNormalArray() {
        int[] input = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};

        assertArrayEquals(expected, Sorting.bubbleSort(input));
    }

    @Test
    void testAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, Sorting.bubbleSort(input));
    }

    @Test
    void testReverseSorted() {
        int[] input = {9, 7, 5, 3, 1};
        int[] expected = {1, 3, 5, 7, 9};

        assertArrayEquals(expected, Sorting.bubbleSort(input));
    }
}