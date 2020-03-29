package cn.chao.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
   private  static Properties properties = new Properties();

    private PropertyMgr() {
    }

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {


        if (properties == null) return null;
        return (String) properties.get(key);
    }

    //getInt

    //getString

    //UTIL
    public static void main(String[] args) {
        System.out.println(get("initTankCount"));
    }
}
