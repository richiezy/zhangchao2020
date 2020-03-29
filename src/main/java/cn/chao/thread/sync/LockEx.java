package cn.chao.thread.sync;

import java.util.concurrent.TimeUnit;

public class LockEx {
    int count = 0;
    synchronized void m(){

        System.out.println(Thread.currentThread().getName() + "start");


        while (true){
            count++;
            System.out.println(Thread.currentThread().getName() + "count =" + count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count ==5){
                int i = 1/0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        LockEx t = new LockEx();

        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m,"t2").start();
    }
}
