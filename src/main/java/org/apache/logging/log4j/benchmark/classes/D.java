package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class D implements I {
    I i;

    public D(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
