package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class J implements I {
    I i;

    public J(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
