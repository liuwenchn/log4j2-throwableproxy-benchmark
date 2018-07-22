package org.apache.logging.log4j.benchmark.classes;

/**
 * @author zilong6
 */
class G implements I {
    I i;

    public G(I i) {
        this.i = i;
    }

    public void trigger() {
        i.trigger();
    }
}
