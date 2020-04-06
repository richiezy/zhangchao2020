package cn.chao.thread.sync;

public class WithoutCacheLineTest {

    private static volatile long LL;
    private static volatile long MM;

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10_000_000L; i++) {
                LL = i;
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10_000_000L; i++) {
                MM = i;
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
