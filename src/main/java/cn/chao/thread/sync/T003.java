package cn.chao.thread.sync;

public class T003 {

    private int count = 10;

//    private Object o = new Object();

    private synchronized void m(){

            count--;
            System.out.println(Thread.currentThread().getName()+ " count =" + count);
    }

    public static void main(String[] args) {

        T003 t = new T003();
        for (int i = 0; i < 100; i++) {
            new Thread(t::m).start();
        }

    }
}
