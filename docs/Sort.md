# Sorting Algorithms

## Insertion Sort

### Time and space complexity
**Time Complexity:**  

| Case          | Time            | Explanation                                                                                                                                   ||
| ------------- | --------------- | ----------                                                                                                                                       |----  |
| Worst Case    | O(n^2)          | In the worst case each new item has to be compared to all other items. That happens when the new item is smaller/bigger than all other items. |  |
| Average Case  | O(n^2)          |                                                                                                                                  |  |
| Best Case     | O(n)            | A new item is the smallest/biggest already and has to be compared only to one other item.                                                     |  |

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
   * At the beginning of each iteration the sub-array A[1...j-1] consists of all previously contained items in the 
   sub-array A[1...j-1], but in an ordered manner.
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
