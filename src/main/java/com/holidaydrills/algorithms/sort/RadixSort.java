package com.holidaydrills.algorithms.sort;

public class RadixSort {

    public int[] sort(int[] input) {
        int max = getMax(input);
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; max/exp > 0; exp *= 10)
            countingSort(input, exp);
        return input;
    }

    private int[] countingSort(int[] input, int exp) {
        int[] sorted = new int[input.length];
        int[] countingArray = new int[10]; // numbers are always in the range 0-9

        for(int i = 0; i < input.length; i++) {
            int currentNumber = input[i];
            int currentDigit = currentNumber;
            countingArray[(currentNumber/exp) % 10]++;
        }

        for(int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i-1];
        }

        // Fill the sorted array from the back as the biggest number from the input array should be placed first.
        // Then at the position before the smaller number should be placed
        // E.g. [111, 121, 123, ...] then 123 should be placed first as it is bigger than 121
        for(int i = input.length-1; i >= 0; i--) {
            sorted[countingArray[(input[i]/exp)%10] -1] = input[i];
            countingArray[(input[i]/exp)%10]--;
        }

        for(int i = 0; i < input.length; i++) {
            input[i] = sorted[i];
        }

        return input;
    }

    private int getMax(int[] input) {
        int max = input[0];
        for(int i = 1; i < input.length; i++) {
            if(max < input[i]) {
                max = input[i];
            }
        }
        return max;
    }
}