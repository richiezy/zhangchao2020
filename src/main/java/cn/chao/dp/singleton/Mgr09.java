package cn.chao.dp.singleton;

/**
 * 你问问牛逼不
 */
public enum Mgr09 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(()->{
                System.out.println(Mgr09.INSTANCE.hashCode());
            }).start();
        }
    }
}
