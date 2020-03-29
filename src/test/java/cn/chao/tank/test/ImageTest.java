package cn.chao.tank.test;


import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.fail;

public class ImageTest {


    @Test
    public void test(){
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("images/tankL.gif");
            BufferedImage read1 = ImageIO.read(resourceAsStream);
            System.out.println(read1);
            File f = (new File("images/tankL.gif"));
            System.out.println(f.exists());

            BufferedImage read = ImageIO.read(new File("images/tankL.gif"));
            Assert.assertNotNull(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}