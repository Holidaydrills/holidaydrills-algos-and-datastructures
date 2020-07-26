package com.holidaydrills.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {

    BucketSort cut = new BucketSort();

    @Test
    void sort() {

        double[] input = new double[] {0.3,0.7,0.4,0.2,0.22,0.78,0.45,0.23,0.12};
        double[] expected = new double[] {0.12,0.2,0.22,0.23,0.3,0.4,0.45,0.7,0.78};

        assertArrayEquals(expected, cut.sort(input, 10));

    }
}