package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class K implements I {
    I i;

    public K(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
