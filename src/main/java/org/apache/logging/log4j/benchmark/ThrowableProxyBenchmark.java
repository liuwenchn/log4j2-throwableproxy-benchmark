package org.apache.logging.log4j.benchmark;

import org.apache.logging.log4j.benchmark.classes.Classes;
import org.apache.logging.log4j.benchmark.classes.I;
import org.apache.logging.log4j.core.impl.BugFixedThrowableProxy;
import org.apache.logging.log4j.core.impl.OptimizedThrowableProxy;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import org.openjdk.jmh.annotations.*;

/**
 * @author zilong6
 */
public class ThrowableProxyBenchmark {

    @State(Scope.Benchmark)
    public static class ExceptionProvider {
        Exception ex;

        @Param({"1", "14"})
        int classCount;

        @Param({"1", "50"})
        int duplication;

        @Setup
        public void init() {
            // construct a stack whose sibling element are from different class
            I i = null;

            for (int j = 0; j < duplication; j++) {
                i = Classes.makeStack(i, classCount);
            }

            try {
                i.trigger();
            } catch (Exception e) {
                ex = e;
            }
        }

    }

    @Benchmark
    public void baseline(ExceptionProvider provider) {
        new ThrowableProxy(provider.ex);
    }

    @Benchmark
    public void bugfixed(ExceptionProvider provider) {
        new BugFixedThrowableProxy(provider.ex);
    }

    @Benchmark
    public void optimized(ExceptionProvider provider) {
        new OptimizedThrowableProxy(provider.ex);
    }

}

