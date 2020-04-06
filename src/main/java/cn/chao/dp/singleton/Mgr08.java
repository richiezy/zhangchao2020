package cn.chao.dp.singleton;
/**
 * perfect    Mgr08在加载时不会加载内部类
* */
public class Mgr08 {

    private Mgr08() {
    }


    private static class Mgr08Holder {
        private static final Mgr08 INSTANCE = new Mgr08();
    }

    public static Mgr08 getInstance() {
        return Mgr08Holder.INSTANCE;
    }



}
