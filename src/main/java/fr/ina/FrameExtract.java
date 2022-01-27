package fr.ina;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.sql.Time;

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
    	File myObj = new File(filename);
    	System.out.println("Veuillez entre le temps exacte de la frame que vous voulez extraire");
    	Scanner timeex = new Scanner(System.in);
    	Long timetoex = timeex.nextLong();
    	Time timestamp = new Time(timetoex);
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