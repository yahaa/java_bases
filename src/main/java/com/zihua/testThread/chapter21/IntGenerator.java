package com.zihua.testThread.chapter21;

/**
 * Created by zihua on 17-3-26.
 * 产生的抽象类，
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
