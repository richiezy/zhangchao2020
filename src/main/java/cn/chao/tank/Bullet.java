package cn.chao.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private int x, y;
    private TankFrame  tankFrame;

    private Group group;

    private boolean living = true;
    Rectangle rectangle = new Rectangle();
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if(!living){
            tankFrame.lists.remove(this);
        }

        switch (dir) {
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;

            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;

            default:
                break;

        }

        move();

    }


    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }


        if(x<0 || y< 0 ||x> TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            living = false;
        }
        rectangle.x = x;
        rectangle.y = y;
    }

    public void colligeWith(Tank tank) {
        if(this.group == tank.getGroup()) return;

        if(this.rectangle.intersects(tank.rectangle)){
            tank.die();
            this.die();

            int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

            tankFrame.explodes.add(new Explode(ex,ey,tankFrame));
        }

    }

    private void die() {
        this.living = false;
    }
}