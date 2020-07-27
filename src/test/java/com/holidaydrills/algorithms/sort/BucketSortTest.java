package com.holidaydrills.algorithms.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {

    BucketSort cut = new BucketSort();

    @Test
    void naiveSort() {

        double[] input = new double[] {0.3,0.7,0.4,0.2,0.22,0.78,0.45,0.23,0.12};
        double[] expected = new double[] {0.12,0.2,0.22,0.23,0.3,0.4,0.45,0.7,0.78};

        assertArrayEquals(expected, cut.naiveSort(input, 10));

    }

    @Test
    public void sort() {
        List<Integer> input = List.of(3,7,4,2,22,789,45,23,12);
        List<Integer>  expected = List.of(2,3,4,7,12,22,23,45,789);

       assertEquals(expected, cut.sort(input));
    }
}