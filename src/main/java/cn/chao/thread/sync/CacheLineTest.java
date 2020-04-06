package cn.chao.thread.sync;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

public class CacheLineTest {

    protected static class TF {
        public volatile long x1, x2, x3, x4, x5, x6, x7;
    }

    private static class T extends TF {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10_000_000L; i++) {
                arr[0].x = i;
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10_000_000L; i++) {
                arr[1].x = i;
            }
        }
        );

        long start = System.currentTimeMillis();

        try {

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (Exception e) {

        }

        System.out.println(System.currentTimeMillis() - start);
    }

}
