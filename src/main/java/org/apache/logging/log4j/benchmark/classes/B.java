package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class B implements I {
    I i;

    public B(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
