package cn.chao.dp.singleton;

public class Mgr07 {
    /*防止指令重排序*/
    private static volatile Mgr07 INSTANCE;

    private Mgr07() {
    }

    public static Mgr07 getInstance() {
        if (INSTANCE == null) {
            /*不能保证*/
            synchronized (Mgr05.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Mgr07();
                }
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
