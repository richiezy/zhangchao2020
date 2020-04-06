package cn.chao.dp.singleton;

public class Mgr01 {

    private static final Mgr01 mgr01 = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return mgr01;
    }

    public static void main(String[] args) {
        Mgr01 instance = Mgr01.getInstance();
        Mgr01 instance1 = Mgr01.getInstance();
        System.out.println(instance == instance1);
    }
}
