package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class L implements I {
    I i;

    public L(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
