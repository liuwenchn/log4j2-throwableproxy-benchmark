package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class H implements I {
    I i;

    public H(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
