package cn.chao.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    private static ResourceMgr INSTANCE = new ResourceMgr();

    private ResourceMgr() {
    }


    public static ResourceMgr getINSTANCE() {
        return INSTANCE;
    }

    public static BufferedImage getGoodTankL() {
        return goodTankL;
    }

    public static BufferedImage getGoodTankU() {
        return goodTankU;
    }

    public static BufferedImage getGoodTankR() {
        return goodTankR;
    }

    public static BufferedImage getGoodTankD() {
        return goodTankD;
    }

    public static BufferedImage getBadTankL() {
        return badTankL;
    }

    public static BufferedImage getBadTankU() {
        return badTankU;
    }

    public static BufferedImage getBadTankR() {
        return badTankR;
    }

    public static BufferedImage getBadTankD() {
        return badTankD;
    }

    public static BufferedImage getBulletL() {
        return bulletL;
    }

    public static BufferedImage getBulletU() {
        return bulletU;
    }

    public static BufferedImage getBulletR() {
        return bulletR;
    }

    public static BufferedImage getBulletD() {
        return bulletD;
    }

    public static BufferedImage[] getExplodes() {
        return explodes;
    }

    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    public static BufferedImage[] explodes = new BufferedImage[16];


    static {

        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            ;
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            ;
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            ;
            ;


            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageUtil.rotateImage(bulletL, -90);
            bulletR = ImageUtil.rotateImage(bulletL, 180);
            bulletD = ImageUtil.rotateImage(bulletL, 90);
            ;


            for (int i = 0; i < 16; i++) {
                System.out.println("images/e" + (i + 1) + ".gif");
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
