package com.zihua.testThread.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zihua on 17-3-26.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    public static void test(IntGenerator g, int count) {
        System.out.println(7777777);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; ++i) {
            System.out.println("task "+i);
            exec.execute(new EvenChecker(g, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator g) {
        test(g, 3);
    }

    public void run() {
        while (!generator.isCanceled()) {

            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(55555555);
                System.out.println(val + " is not even from id= " +id);

                generator.cancel();
            }
        }

    }
}
