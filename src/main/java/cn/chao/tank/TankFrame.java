package cn.chao.tank;

import cn.chao.tank.abstractfactory.*;
import cn.chao.tank.facade.GameModel;
import cn.chao.tank.strage.FiveBulletStategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

   public static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;

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
                    GameModel.getInstance().getMainTank().fire(new FiveBulletStategy());
                    break;
                default:

                    break;
            }

            setMainDir();
        }

        private void setMainDir() {
            BaseTank myTank = GameModel.getInstance().getMainTank();
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
    public void paint(Graphics g){
        GameModel.getInstance().paint(g);
    }

}
