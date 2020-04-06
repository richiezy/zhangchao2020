package cn.chao.dp.singleton;

public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            /*不能保证*/
            synchronized (Mgr05.class) {

                INSTANCE = new Mgr05();
            }

        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
