package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class E implements I {
    I i;

    public E(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
