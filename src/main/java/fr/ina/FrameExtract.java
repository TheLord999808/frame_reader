package fr.ina;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

	public class FrameExtract {
	
    public static void main(String []args) throws Exception
    {
    	System.out.println("Veuillez entre le nom du fichier et son chemin d'accés");
    	Scanner filepath = new Scanner(System.in);
    	String filename = filepath.nextLine();
    	System.out.println("Veuillez entre le temps de la frame que vous voulez extraire");
    	Scanner th = new Scanner(System.in);
    	int h = th.nextInt();
    	Scanner tmin = new Scanner(System.in);
    	int min = tmin.nextInt();
    	Scanner tsec = new Scanner(System.in);
    	int sec = tsec.nextInt();
    	String extime = h":"min":"sec;
    	File myObj = new File(filename);
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