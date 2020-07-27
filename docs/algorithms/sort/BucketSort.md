# Bucket Sort

## Time and space complexity

**Time Complexity:**  

| Case          | Time            | Explanation                                                                      |
| ------------- | --------------- | -------                                                                          |
| Worst Case    | O(n^2)          |                                                                                  |
| Average Case  | O(n)            | O(n+(n^2/k)+k), where k is the number of buckets. O(n) k approximately equals n. |
| Best Case     |                 |                                                                                  |

**Space Complexity:**  
O(n*k) where k is the number of buckets

**Stability**  

**recursive / non recursive**   

## Short description 
* The n input values are distributed across these buckets
* A function is applied to the values so they can be assigned to the buckets 
* The ideal way of assigning the values to the bucket is an equal distribution by the hash function

**Algorithm:**  

* Create a helper array B[0..n-1] which holds the buckets (Lists)
* Loop over the input array
   * apply a hash function to the current value which tells in which bucket to place the value
   * add the value to the bucket in a sorted order (apply insertion sort so that it takes the proper place within the bucket)
* At the end connect all buckets which are already sorted
-> Output is a sorted array (List can be converted into an array)

## When to use it

## Implementation
You can find the sample implementation [here](../../../src/main/java/com/holidaydrills/algorithms/sort/BucketSort.java)