package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class C implements I {
    I i;

    public C(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
