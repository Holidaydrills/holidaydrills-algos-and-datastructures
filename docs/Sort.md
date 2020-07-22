# Sorting Algorithms
* The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(nLogn), i.e., 
they cannot do better than nLogn.

## Insertion Sort

### Time and space complexity
**Time Complexity:**  

| Case          | Time            | Explanation                                                                    |
| ------------- | --------------- | ----------                                                                                                                                       
| Worst Case    | O(n^2)          | In the worst case each new item has to be compared to all other items. That happens when the new item is smaller/bigger than all other items. | 
| Average Case  | O(n^2)          |                                                                                                                           | 
| Best Case     | O(n)            | A new item is the smallest/biggest already and has to be compared only to one other item.                 | 

**Space Complexity:**  
O(1)

### Short description
* Insertion sort works like sorting cards in a hand
   * Take the first card
   * Then take the second card and compare it to the first in order to put it in the right position
   * Take one by one further cards and put them into the right position by comparing them to the cards in the hand from 
   right to left
* The items on the hand are sorted at all times

### When to use it
* Insertion sort is effective for sorting small amounts of data when the data is already mostly sorted

### Implementation
You can find the sample implementation [here](../src/main/java/com/holidaydrills/algorithms/sort/InsertionSort.java)
```Java
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
```

### Prove
* Invariant
   * At the beginning of each iteration the sub-array A[1...i-1] consists of all previously contained items in the 
   sub-array A[1...i-1], but in an ordered manner.
* Initializing:
   * The invariant is true before the first iteration -> It contains only one element, so it's sorted
* Continuation:
   * If the invariant is true before the iteration, then it is also true after the iteration -> Each iteration we put the 
   new item at the right position by comparing it with the other (already sorted) items in the inner loop
* Termination:
   * The for loop ends when i = n (n = last index of the array)
   * We proved that the invariant is true after each iteration
   * So in this case A[1...n] would contain all the items of the sub-array A[1...n], but in a ordered manner
   * As A[1...n] is the whole array we proved that the whole array is sorted

## Counting Sort

### Time and space complexity

**Time Complexity:**  

| Case          | Time            | Explanation                                                                                                               |
| ------------- | --------------- | -------                                                                                                                   |
| Worst Case    | O(n)            | The array has to be iterated once for counting the elements and a second time to put the items into the new sorted array. |
| Average Case  | O(n)            |                                                                                                                           |
| Best Case     | O(n)            |                                                                                                                           |

**Space Complexity:**  
O(n+k)  
n for the new array which is sorted and k for the temporary array which holds the counts (it is as big as the range of 
all items)

**Stability**  
Stable  

**recursive / non recursive**  
Non-recursive
       

### Short description
* Create temporary array `tmpArray` with the same size of the range of all items (e.g. when items are between 0-100 then create 
array of size 101)
* Loop over the array `inputArray` that should be sorted
   * Increase the counter in the tmpArray at the index that is equal to the current value (e.g. if it is 3 then increase 
   the value of tmpArray[3] by one)
* Create an empty array `sortedArray` which will hold the sorted values (same size as input array)
* Loop over the tmpArray and sum up all values so that each index contains a number which indicates the number of items 
before this item (e.g. if `tmpArray[3] has the value 5 that means that there are five items before 3, e.g. [1,2,2,2,2,3])
   * Sum up (iterate) beginning to the end if the final array should be ascending
   * Sum up (iterate) from end to beginning if the final array should be descending
* Loop again over the `inputArray` and
   * Get the `currentValue` of the index (e.g. inputArray[0] is 5)
   * Get the value from `tmpArray[currentValue]` (e.g. tmpArray[5] is 3) -> This is the number of items that appear before 
   the number 5 (e.g. [1,3,4,5]). This will be called valuesBefore, so `valuesBefore = tmpArray[currentValue]`
   * Set the value of `sortedArray[valuesBefore] = currentValue` 
   * Decrease the value `tmpArray[currentValue]` by one -> as the item was added to the `sortedArray`, the next time the 
   same value will be added one index before

### When to use it
* When you need a stable sorting algorithm (that is that elements with the same value are at the same position relative to 
each other in the sorted output). This is important if e.g. some "satellite data" is included in the sorted objects and 
it is important that two object with the same value have the same position relatively to each other at the end
* Counting Sort is a non-comparing algorithm (maybe useful?)
* Only if **k < n** . Otherwise space complexity is not advantageous. We can’t use counting sort because counting sort 
will take O(n2) which is worse than comparison based sorting algorithms. Can we sort such an array in linear time? -> 
Radix Sort which does digit by digit sorting.

### Implementation
You can find the sample implementation [here](../src/main/java/com/holidaydrills/algorithms/sort/CountingSort.java)
```Java
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
```

## Radix Sort

### Time and space complexity

**Time Complexity:**   

**TBD**

| Case          | Time            | Explanation |
| ------------- | --------------- | -------     |
| Worst Case    |                 |             |
| Average Case  |                 |             |
| Best Case     |                 |             |

**Space Complexity:**  
**TBD**

**Stability**  
* Stable if the underlying sorting algorithm is stable

**recursive / non recursive**  
* ? 

### Short description
* Radix Sort sorts the input digit by digit
* First the digits with the least value
* It calls a subroutine which is a stable sort algorithm on each digit

### When to use it
* When a stable sorting algorithm is needed
* When a sorting algorithm is needed that is non-comparing
* When the range of numbers is too big for Counting Sort, then Radix Sort can help

### Implementation
You can find the sample implementation [here](../src/main/java/com/holidaydrills/algorithms/sort/RadixSort.java)
```Java
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
```
