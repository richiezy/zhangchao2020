package cn.chao.thread.sync;

public class T {

    private int count = 10;

//    private Object o = new Object();

    private void m(){

        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+ " count =" + count);
        }
    }

    public static void main(String[] args) {

        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t::m).start();
        }

    }
}
