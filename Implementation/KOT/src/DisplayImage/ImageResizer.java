/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
/**
 *
 * @author huele
 */

public class ImageResizer {
 
    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static BufferedImage resize(String image, int scaledWidth, int scaledHeight) {
        String inputImagePath = "build/classes/Images/" + image;
        // reads input image
        File inputFile = new File(inputImagePath);
        
//        BufferedImage inputImage;
//        BufferedImage outputImage;
        try{
            BufferedImage inputImage = ImageIO.read(inputFile);
            BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
            
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();
            return outputImage;
        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
        // creates output image
        return null;
 
        // scales the input image to the output image
        
        
 
        
    }
    
    public static void setImage(javax.swing.JButton button, String img){
        int x = button.getWidth();
        int y = button.getHeight();
        
        button.setIcon(new javax.swing.ImageIcon( resize(img, x, y) ));
        
    }
    public static void setImage(javax.swing.JLabel label, String img){
        int x = label.getWidth();
        int y = label.getHeight();
        
        label.setIcon(new javax.swing.ImageIcon( resize(img, x, y)));
    }    
}
