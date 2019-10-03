package org.innovation.dynamint;

public interface MWEntityLoader extends Comparable<MWEntityLoader> {

    double priority();

    @Override
    default int compareTo(MWEntityLoader arg) {
        return Double.compare(priority(), arg.priority());
    }

    void notifyStart();

    void notifyFinish();

    boolean load();

}
