package cn.chao.thread;

import java.util.concurrent.TimeUnit;

public class ThreadState {

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(i);
            }

        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
