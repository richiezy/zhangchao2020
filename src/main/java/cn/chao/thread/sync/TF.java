package cn.chao.thread.sync;

import java.util.concurrent.TimeUnit;

public class TF {
    synchronized void m() {

        System.out.println("m start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m end");
    }


    public static void main(String[] args) {
        new TT().m();
    }
}


class TT extends TF {


    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end ");
    }
}
