package com.holidaydrills.algorithms.sort;

public class InsertionSort {

    public int[] sort(int[] input) {
        for(int i = 1; i < input.length; i++) {
            for(int j = i; j > 0; j--) {
                if(input[j-1] > input[j]) {
                    int swap = input[j];
                    input[j] = input[j-1];
                    input[j-1] = swap;
                }
            }
        }
        return input;
    }
}
