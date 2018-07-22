package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class N implements I {
    I i;

    public N(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
