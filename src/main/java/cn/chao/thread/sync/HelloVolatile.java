package cn.chao.thread.sync;

import java.util.concurrent.TimeUnit;

public class HelloVolatile {

    /* volatile*/ boolean flag = true;

    void m(){
        System.out.println("m start");
        while(flag) {


        }
        System.out.println("m.end");
    }

    public static void main(String[] args) {
        HelloVolatile helloVolatile = new HelloVolatile();
        new Thread(helloVolatile::m,"wang").start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        helloVolatile.flag =false;
    }

}
