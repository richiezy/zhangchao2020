package cn.chao.tank.abstractfactory;

import cn.chao.tank.TankFrame;
import cn.chao.tank.facade.GameModel;

import java.awt.*;

public class RectExplode extends  BaseExplode {

    public RectExplode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;
        if (step >= 15)
            GameModel.getInstance().explodes.remove(this);
       g.setColor(c);
    }
}
