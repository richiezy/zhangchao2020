package cn.chao.dp.singleton;

public class Mgr06 {


    private static Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            /*不能保证*/
            synchronized (Mgr05.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Mgr06();
                }
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
