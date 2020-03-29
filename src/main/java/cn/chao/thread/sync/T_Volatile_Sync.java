package cn.chao.thread.sync;

public class T_Volatile_Sync  implements  Runnable{

    private /*volatile*/  int count = 100;

    public synchronized void run(){
        count --;
        System.out.println(Thread.currentThread().getName()+ " count =" + count);
    }

    public static void main(String[] args) {
        T_Volatile_Sync t = new T_Volatile_Sync();
        for (int i = 0; i <100 ; i++) {
            new Thread(t,"Thread" + i).start();
        }
    }
}
