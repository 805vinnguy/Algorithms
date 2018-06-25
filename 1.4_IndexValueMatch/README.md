# Index Value Match

## Problem Statement

> Suppose that you are given a sorted list of distinct integers {a*1*, a*2*, ..., a*N*}.
> Design and analyze a divide-and-conquer algorithm that determines whether there 
> exists an index *i* such that a*i* = *i*.

> For example, in {-10, -4, 3, 41}, a*3* = 3, and in {4, 7, 19, 20}, there is no such *i*.

> Note: Negative integers will never satisfy the condition that a*i* = *i* since Java does
> not support negative indexing.

## IndexValueMatch()

### Input:

A sorted list of distinct integers, *A* = {a*1*, a*2*, ..., a*N*}.
An integer *min* = 0.
An integer *max* = length(A).

### Output:

Index *i* such that a*i* = *i*.
A statement that there is no such *i*.  (In this case, -1).

### Pseudocode:
```
1.  let i = (min + max) / 2
2.  if A[i] = i then:
3.      return i
4.  else if A[i] < i then:
5.      return IndexValueMatch(A, min, (min + max) / 2)
6.  else if A[i] > i then:
7.      return IndexValueMatch(A, (min + max) / 2, max)
8.  else:
9.      return -1
```

### Proof:
```
1.  Suppose there is a sorted list of distinct integers, A, and an integer, i = length(A)/2.
2.  Looping through A at most length(A)/2 times,
3.  Line 3 of IndexValueMatch() will return i such that a[i] = i.
4.  Otherwise,
5.  Line 9 of IndexValueMatch() will return -1, a statement that there is no such i 
    for which a[i] = i.
```

### Recurrence Relation:
```
T(n) = T(n/2) + O(1)
```

### Running Time
```
O(log2(n))
```
