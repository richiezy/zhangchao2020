package cn.chao.thread;

/**
 * how to create thread
 * <p>
 * 1. extends Thread
 * 2. implements Runnable
 * 3. Use ThreadPool
 */

public class CreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("create thread");
        }
    }

    static class MyRun implements Runnable {
        public void run() {
            System.out.println("creat runnable");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();

        new Thread(() -> {
            System.out.println("lambda");
        }).start();
    }

}
