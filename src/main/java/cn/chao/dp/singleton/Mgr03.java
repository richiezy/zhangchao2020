package cn.chao.dp.singleton;

public class Mgr03 {


    private static Mgr03 INSTANCE = null;

    static {
        INSTANCE = new Mgr03();
    }

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr03 instance = Mgr03.getInstance();
        Mgr03 instance1 = Mgr03.getInstance();
        System.out.println(instance == instance1);
    }
}
