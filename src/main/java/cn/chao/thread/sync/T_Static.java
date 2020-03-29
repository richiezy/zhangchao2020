package cn.chao.thread.sync;

public class T_Static {
    private static int count = 10;

    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count =" + count);
    }

    public static void mm() {

        synchronized (T_Static.class) {
            count--;
        }
    }
}
