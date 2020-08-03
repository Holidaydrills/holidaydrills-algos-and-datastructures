# Algorithms and Data Structures
## Terminology
* Loop Invariant
   * A loop invariant is a property of a program loop that is true before (and after) each iteration. Knowing its 
   invariant(s) is essential in understanding the effect of a loop.
   * Because of the similarity of loops and recursive programs, proving partial correctness of loops with invariants is 
   very similar to proving correctness of recursive programs via induction. In fact, the loop invariant is often the 
   same as the inductive hypothesis to be proved for a recursive program equivalent to a given loop.
* (Structural) Induction
   * Structural induction is a proof method that is used in mathematical logic
   * Structural induction is used to prove that some proposition P(x) holds for all x of some sort of recursively 
   defined structure, such as formulas, lists, or trees
   * A well-founded partial order is defined on the structures ("subformula" for formulas, "sublist" for lists, and 
   "subtree" for trees)
   * The structural induction proof is a proof that the proposition holds for all the minimal structures and that if it 
   holds for the immediate substructures of a certain structure S, then it must hold for S also.
   
**Sort Algorithms**
* The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(nLogn), i.e., 
they cannot do better than nLogn.

**Graph traversals**
* Depth first search (DFS)
   * *Advantage*: Depth-first search on a binary tree generally requires less memory than breadth-first.
   * *Advantage*: Depth-first search can be easily implemented with recursion.
   * *Disadvantage*: A DFS doesn't necessarily find the shortest path to a node, while breadth-first search does.
* Breadth first search (BFS)
   * *Advantage*: A BFS will find the shortest path between the starting point and any other reachable node.
   * *Disadvantage*: A BFS on a binary tree generally requires more memory than a DFS.
   
## Algorithms
| Name           | Time Complexity | Space Complexity |
| -------------  | :-------------: | -----:           |
| Insertion Sort | O(n^2)          | O(1)             |
| Counting Sort  | O(n)            | O(k)             |
| Radix Sort     | O(n*k)          | O(1)             |
| Bucket Sort    | O(n^2)          | O(n+k)           |
 
### Sort Algorithms
* [Insertion Sort](docs/algorithms/sort/InsertionSort.md)
* [Counting Sort](docs/algorithms/sort/CountingSort.md)
* [Radix Sort](docs/algorithms/sort/RadixSort.md)
* [Bucket Sort](docs/algorithms/sort/BucketSort.md)

## Search Algorithms