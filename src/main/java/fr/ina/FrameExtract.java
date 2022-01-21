package fr.ina;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

public class FrameExtract {
    public static void main(String []args) throws Exception
    {
        File myObj = new File("D:\\file_example_MP4_1920_18MG.mp4");
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(myObj.getAbsoluteFile());
        frameGrabber.start();
        Frame f;
        try {
            Java2DFrameConverter c = new Java2DFrameConverter();
            f = frameGrabber.grab();
            BufferedImage bi = c.convert(f);
            ImageIO.write(bi,"png", new File("D:\\img.png"));
            frameGrabber.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}