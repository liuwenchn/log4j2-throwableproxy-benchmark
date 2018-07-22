package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class M implements I {
    I i;

    public M(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
