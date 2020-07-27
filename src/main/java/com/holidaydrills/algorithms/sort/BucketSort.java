package com.holidaydrills.algorithms.sort;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BucketSort {

    public List<Integer> sort(List<Integer> input) {

        int numberOfBuckets = (int) Math.sqrt(input.size());
        int max = getMax(input);
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);

        // Create empty buckets
        for(int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Add elements to buckets based on the hash function
        for(Integer number : input) {
            int hash = hash(number, max, numberOfBuckets);
            buckets.get(hash).add(number);
        }

        // Sort buckets
        for(List bucket : buckets) {
            bucket.sort(Comparator.naturalOrder());
        }

        List<Integer> sortedList = new LinkedList<>();
        for(List bucket : buckets) {
            sortedList.addAll(bucket);
        }

        return sortedList;
    }

    private int hash(int number, int maxValue, int numberOfBuckets) {
        return (int)((double) number / maxValue * (numberOfBuckets - 1));
    }

    private int getMax(List<Integer> input) {
        int max = Integer.MIN_VALUE;
        for(Integer number : input) {
            max = Math.max(max, number);
        }
        return max;
    }


    /////////////////////////////////////////////
    /////////////////////////////////////////////


    /*
    Solution with arrays expecting values between [0..1)
     */
    public double[] naiveSort(double[] input, int numberOfBuckets) {

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
