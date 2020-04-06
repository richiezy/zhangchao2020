package cn.chao.tank.abstractfactory;

import cn.chao.tank.TankFrame;

import java.awt.*;

public class RectExplode extends  BaseExplode {

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;
        if (step >= 15)
            tankFrame.explodes.remove(this);


       g.setColor(c);
    }
}
