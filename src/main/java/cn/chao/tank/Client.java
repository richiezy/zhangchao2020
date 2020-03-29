package cn.chao.tank;

import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) {
        TankFrame frame = new TankFrame();
        int initCount = Integer.parseInt(PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initCount; i++) {
            frame.tanks.add(new Tank(100 + i * 50, 100 + i * 50, Dir.DOWN, Group.BAD, frame));
        }

        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.repaint();
        }
    }
}
