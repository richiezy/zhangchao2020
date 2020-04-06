package cn.chao.dp.singleton;

public class Mgr02 {

    private static Mgr02 INSTANCE = null;

    private Mgr02() {
    }

    public static Mgr02 getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new Mgr02();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
           new Thread(()->{
               System.out.println(Mgr02.getInstance().hashCode());
           }).start();
        }
    }
}
