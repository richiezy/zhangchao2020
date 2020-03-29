package cn.chao.thread.sync;

import java.util.concurrent.TimeUnit;

public class VolatileReferenceOne {
    boolean flag =  true;

    volatile  static VolatileReferenceOne T = new VolatileReferenceOne();

    void m(){

        System.out.println("m start");
        while (flag){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Thread(T::m).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.flag = false;
    }
}
