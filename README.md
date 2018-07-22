# Benchmarking for log4j2 ThrowableProxy creation

The following benchmark compares the performance of `ThrowableProxy` optimizations for different exception

We made different level of optimizations for `ThrowableProxy`

* baseline: test `ThrowableProxy` in log4j2, not optimized, with bug, for comparison consideration.
* bugfixed: fixed bug in `ThrowableProxy` accessing the cache.
* optimized: make the cache global, instead of a new one for each exception instance.

And then we try to construct an `NullPointerException`, for whose stack elements

* total distinct class number in the stack elements is `classCount`
* duplication of each class in the stack is `duplication`

Then we see

* more than `10` times improvement when the bug is fixed for exceptions with stack element class duplicated many times.
* and about `2` times further improvement when make the cache global (compared with log4j2, more than `20` times improvement).

```text
Benchmark                          (classCount)  (duplication)   Mode  Cnt       Score       Error  Units
ThrowableProxyBenchmark.baseline              1              1  thrpt   10   46759.416 ±  2168.541  ops/s
ThrowableProxyBenchmark.bugfixed              1              1  thrpt   10   66627.198 ±  2232.323  ops/s
ThrowableProxyBenchmark.optimized             1              1  thrpt   10  114836.862 ±  8944.663  ops/s

Benchmark                          (classCount)  (duplication)   Mode  Cnt       Score       Error  Units
ThrowableProxyBenchmark.baseline              1             50  thrpt   10    5304.829 ±   101.103  ops/s
ThrowableProxyBenchmark.bugfixed              1             50  thrpt   10   63930.633 ±  4454.662  ops/s
ThrowableProxyBenchmark.optimized             1             50  thrpt   10  123683.446 ±  8658.373  ops/s

Benchmark                          (classCount)  (duplication)   Mode  Cnt       Score       Error  Units
ThrowableProxyBenchmark.baseline             14              1  thrpt   10    5836.655 ±   155.754  ops/s
ThrowableProxyBenchmark.bugfixed             14              1  thrpt   10   49198.737 ±  1949.829  ops/s
ThrowableProxyBenchmark.optimized            14              1  thrpt   10  123084.435 ± 10797.259  ops/s

Benchmark                          (classCount)  (duplication)   Mode  Cnt       Score       Error  Units
ThrowableProxyBenchmark.baseline             14             50  thrpt   10    2080.817 ±    67.113  ops/s
ThrowableProxyBenchmark.bugfixed             14             50  thrpt   10   39546.755 ±  2559.787  ops/s
ThrowableProxyBenchmark.optimized            14             50  thrpt   10   75237.677 ±  5685.516  ops/s
```