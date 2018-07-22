package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class F implements I {
    I i;

    public F(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
