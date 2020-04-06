package cn.chao.tank;

import cn.chao.tank.abstractfactory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    private static GameFactory factory = new RectGameFactory();

    BaseTank myTank = factory.createTank(200, 400, Dir.DOWN, Group.GOOD, this);

    public static GameFactory getFactory() {
        return factory;
    }

    public static void setFactory(GameFactory factory) {
        TankFrame.factory = factory;
    }

    List<BaseBullet> lists = new ArrayList<>();
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    public List<BaseTank> tanks = new ArrayList<>();
    public List<BaseExplode> explodes = new ArrayList<>();

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setVisible(true);
        setTitle("tank war");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainDir();
        }


        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                case KeyEvent.VK_CONTROL:
                    myTank.fire(new FiveBulletStategy());
                    break;
                default:

                    break;
            }

            setMainDir();
        }

        private void setMainDir() {
            if (!(bD || bL || bU || bR)) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bD) myTank.setDir(Dir.DOWN);
                if (bU) myTank.setDir(Dir.UP);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bL) myTank.setDir(Dir.LEFT);
            }
        }
    }


    Image offScreemImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreemImage == null) {
            offScreemImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics graphics = offScreemImage.getGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphics.setColor(c);
        paint(graphics);
        g.drawImage(offScreemImage, 0, 0, null);


    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawString("子弹的数量为:" + lists.size(), 10, 60);
        g.drawString("敌人的数量为:" + tanks.size(), 10, 90);

        g.drawString("爆炸的数量为:" + explodes.size(), 10, 120);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }


        for (int i = 0; i < lists.size(); i++) {
            for (int l = 0; l < tanks.size(); l++) {

                lists.get(i).collideWith(tanks.get(l));
            }
        }


    }
}
