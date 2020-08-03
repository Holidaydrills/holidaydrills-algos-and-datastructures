# Counting Sort

## Time and space complexity

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
       

## Short description
Counting sort is a specialization of Bucket Sort where each bucket is of size one
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

## When to use it
* Counting Sort works well with a defined relatively small range of integers as input
* When you need a stable sorting algorithm (that is that elements with the same value are at the same position relative to 
each other in the sorted output). This is important if e.g. some "satellite data" is included in the sorted objects and 
it is important that two object with the same value have the same position relatively to each other at the end
* Counting Sort is a non-comparing algorithm (maybe useful?)
* Only if **k < n** . Otherwise space complexity is not advantageous. We can’t use counting sort because counting sort 
will take O(n2) which is worse than comparison based sorting algorithms. Can we sort such an array in linear time? -> 
Radix Sort which does digit by digit sorting.

## Implementation
You can find the sample implementation [here](../../../src/main/java/com/holidaydrills/algorithms/sort/CountingSort.java)
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