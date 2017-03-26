package com.zihua.testThread.chapter21;

/**
 * Created by zihua on 17-3-26.
 */
public class EvenGenerator extends IntGenerator {
    private int cur = 1;

    @Override
    public synchronized int next() {
        ++cur;
        ++cur;
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(8888888);
        EvenChecker.test(new EvenGenerator());
    }
}
