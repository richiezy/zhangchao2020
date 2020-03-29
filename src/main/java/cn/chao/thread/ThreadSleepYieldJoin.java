package cn.chao.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSleepYieldJoin {

    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }


    private static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);

                if (i % 10 == 0) Thread.yield();
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);

                if (i % 10 == 0) Thread.yield();
            }

        }).start();

    }


    static void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread t2 = new Thread(() -> {

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
            }

        });

        t2.start();
        t1.start();
    }
}
