package com.holidaydrills.algorithms.sort;

public class CountingSort {
    public int[] sort(int[] input, int maxValue) {
        int[] sorted = new int[input.length];
        int[] countingArray = new int[maxValue+1];

        for(int number : input) {
            countingArray[number] = ++countingArray[number];
        }
        for(int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i-1] + countingArray[i];
        }

        for(int i = 0; i < input.length; i++) {
            int currentValue = input[i];
            int itemsBefore = countingArray[currentValue];
            sorted[itemsBefore-1] = currentValue;
            // or shorter ...
            // sorted[countingArray[input[i]]-1] = currentValue;
            countingArray[currentValue] = --countingArray[currentValue];
        }

        return sorted;
    }
}
