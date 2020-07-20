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
   
## Algorithms
| Name           | Time Complexity | Space Complexity |
| -------------  | :-------------: | -----:           |
| Insertion Sort | O(n^2)          | O(1)             |
|                |                 |                  |
|                |                 |                  |

### Sort Algorithms
* [Insertion Sort](docs/Sort.md)

## Search Algorithms