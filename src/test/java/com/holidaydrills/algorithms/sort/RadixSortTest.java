package com.holidaydrills.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    RadixSort cut = new RadixSort();

    @Test
    void sort() {
        int[] input = new int[] {123, 111, 234, 135, 121};
        int[] expected = new int[] {111, 121, 123, 135, 234};

        assertArrayEquals(expected, cut.sort(input));
    }
}