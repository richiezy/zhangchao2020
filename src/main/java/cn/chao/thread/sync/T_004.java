package cn.chao.thread.sync;

import java.util.concurrent.TimeUnit;

public class T_004 {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1 start ...");

        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end ...");

    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + "m2 start ...");
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2 end ...");
    }


    public static void main(String[] args) {
        T_004 t = new T_004();

        new Thread(t::m1).start();
        new Thread(t::m2).start();


    }
}
