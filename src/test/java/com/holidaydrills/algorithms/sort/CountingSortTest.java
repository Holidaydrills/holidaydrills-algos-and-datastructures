package com.holidaydrills.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    CountingSort cut = new CountingSort();

    @Test
    public void sort() {
        int[] input = new int[] {3,7,4,2,22,789,45,23,12};
        int[] expected = new int[] {2,3,4,7,12,22,23,45,789};

        assertArrayEquals(expected, cut.sort(input, 789));
    }

}