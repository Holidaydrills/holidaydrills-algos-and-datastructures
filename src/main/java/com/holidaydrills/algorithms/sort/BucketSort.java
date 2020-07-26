package com.holidaydrills.algorithms.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BucketSort {


    public double[] sort(double[] input, int numberOfBuckets) {

        List<Double>[] buckets = new List[numberOfBuckets];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for(int i = 0; i < input.length; i++) {
            int index = (int) (input[i] * numberOfBuckets);
            buckets[index].add(input[i]);
        }

        for(List<Double> bucket : buckets) {
            // Should actually be insertion sort
            Collections.sort(bucket);
        }
        double[] sortedArray = new double[input.length];
        AtomicInteger counter = new AtomicInteger(0);
        for(List<Double> bucket : buckets) {
            bucket.forEach(item -> {
                sortedArray[counter.getAndIncrement()] = item;
            });
        }
        return sortedArray;
    }
}
