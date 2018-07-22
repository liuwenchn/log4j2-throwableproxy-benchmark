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

```
Benchmark                          (classCount)  (duplication)   Mode  Cnt       Score       Error  Units
ThrowableProxyBenchmark.baseline              1              1  thrpt   20   84036.653 ±  4249.340  ops/s
ThrowableProxyBenchmark.bugfixed              1              1  thrpt   20  144192.620 ± 13649.678  ops/s
ThrowableProxyBenchmark.optimized             1              1  thrpt   20  241404.304 ± 18919.231  ops/s

ThrowableProxyBenchmark.baseline              1             50  thrpt   20    6762.923 ±   382.841  ops/s
ThrowableProxyBenchmark.bugfixed              1             50  thrpt   20  147087.295 ±  7229.302  ops/s
ThrowableProxyBenchmark.optimized             1             50  thrpt   20  261501.243 ± 14579.472  ops/s

ThrowableProxyBenchmark.baseline             14              1  thrpt   20   71615.630 ±  6268.346  ops/s
ThrowableProxyBenchmark.bugfixed             14              1  thrpt   20   85264.569 ±  7454.139  ops/s
ThrowableProxyBenchmark.optimized            14              1  thrpt   20  251676.235 ±  8546.298  ops/s


ThrowableProxyBenchmark.baseline             14             50  thrpt   20    2033.184 ±   491.038  ops/s
ThrowableProxyBenchmark.bugfixed             14             50  thrpt   20   78739.155 ±  3163.605  ops/s
ThrowableProxyBenchmark.optimized            14             50  thrpt   20  217294.787 ±  4333.178  ops/s
```

# environments
```
Architecture:          x86_64
CPU op-mode(s):        32-bit, 64-bit
Byte Order:            Little Endian
CPU(s):                32
On-line CPU(s) list:   0-31
Thread(s) per core:    2
Core(s) per socket:    8
Socket(s):             2
NUMA node(s):          2
Vendor ID:             GenuineIntel
CPU family:            6
Model:                 63
Model name:            Intel(R) Xeon(R) CPU E5-2630 v3 @ 2.40GHz
Stepping:              2
CPU MHz:               1200.000
CPU max MHz:           2400.0000
CPU min MHz:           1200.0000
BogoMIPS:              4794.19
Virtualization:        VT-x
L1d cache:             32K
L1i cache:             32K
L2 cache:              256K
L3 cache:              20480K
NUMA node0 CPU(s):     0-7,16-23
NUMA node1 CPU(s):     8-15,24-31

              total        used        free      shared  buff/cache   available
Mem:            31G        3.1G         22G        209M        5.3G         27G
Swap:          8.0G          0B        8.0G
```
