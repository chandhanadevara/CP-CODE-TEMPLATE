# CP-CODE-TEMPLATE
My Competetive programming code template
# Java Competitive Programming Template

#  Classes Available

| Class | Category             | Purpose                                                                       |
| ----- | -------------------- | ----------------------------------------------------------------------------- |
| `Mod` | Modular Arithmetic   | Performs modular addition, subtraction, multiplication, inverse, and division |
| `Gen` | Test Case Generation | Generates random values, arrays, edge-case arrays, and strings                |
| `IO`  | Input / Output       | Provides fast and convenient methods for reading input                        |
| `Stk` | Monotonic Stack      | Solves Next Greater Element problems                                          |
| `Grd` | Grid Traversal       | Provides DFS and BFS utilities for 2D grids                                   |
| `DSU` | Disjoint Set Union   | Handles connected components and dynamic connectivity                         |
| `ST`  | Segment Tree         | Supports range sum queries and point updates                                  |
| `Mth` | Mathematics          | Provides GCD, LCM, modular power, primality testing, and sieve                |
| `Bit` | Bit Manipulation     | Provides basic operations on individual bits                                  |
| `Arr` | Array Utilities      | Provides binary search, prefix/suffix computations, and range preprocessing   |

---

# 1. `Mod` — Modular Arithmetic Utilities

The `Mod` class contains commonly used modular arithmetic operations using:

```text
MOD = 1,000,000,007
```

This is one of the most commonly used mod values in competitive programming.

## Available Functions

| Function        | Purpose                        | Input            | Output          |
| --------------- | ------------------------------ | ---------------- | --------------- |
| `Mod.add(a, b)` | Modular addition               | `long a, long b` | `(a + b) % MOD` |
| `Mod.sub(a, b)` | Modular subtraction            | `long a, long b` | `(a - b) % MOD` |
| `Mod.mul(a, b)` | Modular multiplication         | `long a, long b` | `(a × b) % MOD` |
| `Mod.inv(a)`    | Modular multiplicative inverse | `long a`         | `a⁻¹ % MOD`     |
| `Mod.div(a, b)` | Modular division               | `long a, long b` | `a / b % MOD`   |

### Implementation Details

`Mod.inv(a)` uses **Fermat's Little Theorem**:

```text
a^(MOD - 2) % MOD
```

This requires the modulus to be prime and the number being inverted to be relatively prime to the modulus.


---

# 2. `Gen` — Random and Test Case Generator

The `Gen` class is useful for generating random test cases and edge cases.

It can be particularly useful when testing a solution against a brute-force implementation.

## Available Functions

| Function                 | Purpose                                    | Input                | Output   |
| ------------------------ | ------------------------------------------ | -------------------- | -------- |
| `Gen.i(min, max)`        | Generate random integer                    | `int min, int max`   | `int`    |
| `Gen.l(min, max)`        | Generate random long                       | `long min, long max` | `long`   |
| `Gen.iArr(sz, min, max)` | Generate random integer array              | Size and range       | `int[]`  |
| `Gen.edgeArr(sz)`        | Generate array containing edge-case values | `int sz`             | `int[]`  |
| `Gen.str(len)`           | Generate random lowercase string           | `int len`            | `String` |

### Edge Case Values Used

The `edgeArr()` function can generate values from:

```text
0
1
-1
Integer.MAX_VALUE
Integer.MIN_VALUE
```

### Example Usage

```java
int x = Gen.i(1, 100);

long y = Gen.l(1, 1_000_000_000L);

int[] arr = Gen.iArr(10, 1, 100);

int[] edgeCases = Gen.edgeArr(10);

String s = Gen.str(20);
```

---

# 3. `IO` — Fast Input Reader

The `IO` class provides convenient methods for reading different types of input.

It uses:

```java
BufferedReader
StringTokenizer
```

This avoids repeatedly writing input-reading code during contests.

## Available Functions

| Function      | Purpose                         | Input    | Output     |
| ------------- | ------------------------------- | -------- | ---------- |
| `IO.next()`   | Read next space-separated token | None     | `String`   |
| `IO.i()`      | Read next integer               | None     | `int`      |
| `IO.l()`      | Read next long                  | None     | `long`     |
| `IO.line()`   | Read a complete line            | None     | `String`   |
| `IO.iArr(sz)` | Read integer array              | `int sz` | `int[]`    |
| `IO.lArr(sz)` | Read long array                 | `int sz` | `long[]`   |
| `IO.sArr(sz)` | Read string array               | `int sz` | `String[]` |

### Example Usage

```java
int n = IO.i();

long x = IO.l();

String s = IO.next();

String line = IO.line();

int[] arr = IO.iArr(n);

long[] longArr = IO.lArr(n);

String[] strArr = IO.sArr(n);
```

---

# 4. `Stk` — Monotonic Stack Utilities

The `Stk` class contains utilities based on the **Monotonic Stack** technique.

It currently focuses on solving **Next Greater Element** problems.

## Available Functions

| Function      | Purpose                                | Input   | Output  |
| ------------- | -------------------------------------- | ------- | ------- |
| `Stk.nge(a)`  | Finds next greater element values      | `int[]` | `int[]` |
| `Stk.ngei(a)` | Finds indices of next greater elements | `int[]` | `int[]` |

If no greater element exists, the result is:

```text
-1
```

### Example

For:

```text
[2, 1, 5, 3]
```

The next greater values are:

```text
[5, 5, -1, -1]
```

### Example Usage

```java
int[] nextGreater = Stk.nge(arr);

int[] nextGreaterIndex = Stk.ngei(arr);
```

### Complexity

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| `nge()`   | `O(n)`          | `O(n)`           |
| `ngei()`  | `O(n)`          | `O(n)`           |

---

# 5. `Grd` — Grid Traversal Utilities

The `Grd` class provides traversal utilities for 2D grids.

It supports:

* 4-directional movement
* DFS
* BFS
* Boundary checking

The four directions are:

```text
Up
Down
Left
Right
```

## Available Functions

| Function    | Purpose                                         | Input                      | Output    |
| ----------- | ----------------------------------------------- | -------------------------- | --------- |
| `Grd.ok()`  | Checks whether a cell is inside grid boundaries | Row, column, rows, columns | `boolean` |
| `Grd.dfs()` | Performs 4-directional DFS                      | Grid and visited array     | `void`    |
| `Grd.bfs()` | Performs 4-directional BFS                      | Grid and visited array     | `void`    |

Cells containing:

```text
'#'
```

are treated as blocked.

### Example Usage

```java
boolean valid = Grd.ok(r, c, rows, cols);

Grd.dfs(r, c, grid, visited);

Grd.bfs(r, c, grid, visited);
```

### Common Applications

This class can be used for:

* Number of Islands
* Connected Components
* Flood Fill
* Grid Path Problems
* Maze Problems
* Region Traversal

### Complexity

For a grid containing `R × C` cells:

| Algorithm | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| DFS       | `O(R × C)`      | `O(R × C)`       |
| BFS       | `O(R × C)`      | `O(R × C)`       |

---

# 6. `DSU` — Disjoint Set Union

The `DSU` class implements the **Disjoint Set Union** data structure.

It uses:

* Path Compression
* Union by Size

This allows efficient management of connected components.

## Available Functions

| Function      | Purpose                                     | Input     | Output     |
| ------------- | ------------------------------------------- | --------- | ---------- |
| `DSU(n)`      | Creates DSU for `n` nodes                   | `int n`   | DSU object |
| `find(x)`     | Finds representative of a set               | Node      | `int`      |
| `union(a, b)` | Merges two sets                             | Two nodes | `boolean`  |
| `same(a, b)`  | Checks whether two nodes belong to same set | Two nodes | `boolean`  |

### Example Usage

```java
DSU dsu = new DSU(n);

dsu.union(a, b);

int root = dsu.find(x);

boolean connected = dsu.same(a, b);
```

### Complexity

With path compression and union by size, operations have approximately:

```text
O(α(n))
```

where `α(n)` is the inverse Ackermann function and grows extremely slowly.

### Common Applications

* Connected Components
* Cycle Detection
* Kruskal's Minimum Spanning Tree
* Dynamic Connectivity
* Grouping Components

---

# 7. `ST` — Segment Tree

The `ST` class implements a **Segment Tree for Range Sum Queries**.

It supports:

* Building the tree
* Point updates
* Range sum queries

## Available Functions

| Function        | Purpose                    | Input                  | Output    |
| --------------- | -------------------------- | ---------------------- | --------- |
| `ST(a)`         | Builds segment tree        | `long[]`               | ST object |
| `upd(idx, val)` | Updates one array position | Index, new value       | `void`    |
| `q(l, r)`       | Returns range sum          | Left and right indices | `long`    |

### Example Usage

```java
long[] arr = {1, 2, 3, 4, 5};

ST st = new ST(arr);

long sum = st.q(1, 3);

st.upd(2, 10);
```

### Complexity

| Operation    | Time Complexity |
| ------------ | --------------- |
| Build        | `O(n)`          |
| Point Update | `O(log n)`      |
| Range Query  | `O(log n)`      |

### Current Operation

The current Segment Tree supports:

```text
Range Sum Query
```

with:

```text
Point Update
```

---

# 8. `Mth` — Mathematical Utilities

The `Mth` class contains frequently used mathematical operations.

## Available Functions

| Function           | Purpose                 | Input                   | Output      |
| ------------------ | ----------------------- | ----------------------- | ----------- |
| `Mth.gcd(a, b)`    | Greatest Common Divisor | Two `long` values       | `long`      |
| `Mth.lcm(a, b)`    | Least Common Multiple   | Two `long` values       | `long`      |
| `Mth.pow(b, e, m)` | Modular exponentiation  | Base, exponent, modulus | `long`      |
| `Mth.prime(n)`     | Checks primality        | `long`                  | `boolean`   |
| `Mth.sieve(n)`     | Generates prime table   | `int`                   | `boolean[]` |

### `gcd()`

Uses the **Euclidean Algorithm**.

```java
long g = Mth.gcd(a, b);
```

### `lcm()`

Computes:

```text
LCM(a, b) = (a / GCD(a, b)) × b
```

### `pow()`

Computes:

```text
base^exponent % modulus
```

using **Binary Exponentiation**.

```java
long result = Mth.pow(base, exponent, mod);
```

### `prime()`

Checks whether a number is prime using trial division up to its square root.

```java
boolean check = Mth.prime(n);
```

### `sieve()`

Uses the **Sieve of Eratosthenes** to generate a prime lookup table.

```java
boolean[] primes = Mth.sieve(n);
```

---

# 9. `Bit` — Bit Manipulation Utilities

The `Bit` class provides the four fundamental bit manipulation operations used frequently in competitive programming.

The bit positions are **0-indexed**.

That means:

```text
Rightmost bit → k = 0
Next bit      → k = 1
Next bit      → k = 2
```

## Available Functions

| Function             | Purpose               | Input             | Output             |
| -------------------- | --------------------- | ----------------- | ------------------ |
| `Bit.get(num, k)`    | Gets the kth bit      | `long num, int k` | `int` (`0` or `1`) |
| `Bit.set(num, k)`    | Sets kth bit to `1`   | `long num, int k` | `long`             |
| `Bit.clear(num, k)`  | Clears kth bit to `0` | `long num, int k` | `long`             |
| `Bit.toggle(num, k)` | Toggles kth bit       | `long num, int k` | `long`             |

### Example Usage

```java
int bit = Bit.get(n, k);

long setValue = Bit.set(n, k);

long clearValue = Bit.clear(n, k);

long toggleValue = Bit.toggle(n, k);
```

---

# 10. `Arr` — Array and Range Utilities

The `Arr` class contains commonly used array preprocessing and binary search utilities.

## Binary Search Utilities

| Function       | Purpose                           | Output |
| -------------- | --------------------------------- | ------ |
| `Arr.lb(a, x)` | First index where `a[index] >= x` | `int`  |
| `Arr.ub(a, x)` | First index where `a[index] > x`  | `int`  |

These functions assume the input array is **sorted**.

---

## Prefix and Suffix Utilities

| Function      | Purpose              | Output   |
| ------------- | -------------------- | -------- |
| `Arr.pSum(a)` | Prefix sum array     | `long[]` |
| `Arr.sSum(a)` | Suffix sum array     | `long[]` |
| `Arr.pMin(a)` | Prefix minimum array | `int[]`  |
| `Arr.sMin(a)` | Suffix minimum array | `int[]`  |
| `Arr.pMax(a)` | Prefix maximum array | `int[]`  |
| `Arr.sMax(a)` | Suffix maximum array | `int[]`  |
| `Arr.pGcd(a)` | Prefix GCD array     | `long[]` |
| `Arr.sGcd(a)` | Suffix GCD array     | `long[]` |

### Example Usage

```java
long[] prefix = Arr.pSum(arr);

long[] suffix = Arr.sSum(arr);

int[] prefixMin = Arr.pMin(arr);

int[] suffixMin = Arr.sMin(arr);

int[] prefixMax = Arr.pMax(arr);

int[] suffixMax = Arr.sMax(arr);

long[] prefixGcd = Arr.pGcd(arr);

long[] suffixGcd = Arr.sGcd(arr);
```

### Common Applications

These utilities are useful for:

* Range sum queries
* Range minimum / maximum problems
* Prefix and suffix optimization
* GCD-based array problems
* Precomputation problems
* Subarray problems

---

