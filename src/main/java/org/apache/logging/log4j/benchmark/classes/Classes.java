package org.apache.logging.log4j.benchmark.classes;

public class Classes {
    public static I makeStack(I passed, int classCount) {
        if (classCount >= 1) {
            passed = new A(passed);
        }
        if (classCount >= 2) {
            passed = new B(passed);
        }
        if (classCount >= 3) {
            passed = new B(passed);
        }
        if (classCount >= 4) {
            passed = new C(passed);
        }
        if (classCount >= 5) {
            passed = new D(passed);
        }
        if (classCount >= 6) {
            passed = new E(passed);
        }
        if (classCount >= 7) {
            passed = new F(passed);
        }
        if (classCount >= 8) {
            passed = new G(passed);
        }
        if (classCount >= 9) {
            passed = new H(passed);
        }
        if (classCount >= 10) {
            passed = new J(passed);
        }
        if (classCount >= 11) {
            passed = new K(passed);
        }
        if (classCount >= 12) {
            passed = new L(passed);
        }
        if (classCount >= 13) {
            passed = new M(passed);
        }
        if (classCount >= 14) {
            passed = new N(passed);
        }

        return passed;
    }
}
