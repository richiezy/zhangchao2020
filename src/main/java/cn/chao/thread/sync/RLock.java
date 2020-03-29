package cn.chao.thread.sync;

/**
 * synchronized & reentrantLock
 */

import java.util.concurrent.TimeUnit;

public class RLock {
    public synchronized  void m1(){
        System.out.println("m1 start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();
        System.out.println("m1 end");
    }

    private void m2() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m2 end");
    }

    public static void main(String[] args) {
        new RLock().m1();
    }

}
