package cn.chao.tank;

import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) {
        TankFrame frame = new TankFrame();
        new Thread(()->new Audio("audio/war1.wav").loop()).start();
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
