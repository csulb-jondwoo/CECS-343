/*
 * Setting classs contains functions that help 
 * Create and modify, JFrames, JLabels, JButtons
 */
package DisplayImage;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Hueletl
 */
public class Setting{
    
    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param image file's name + extension
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @return 
     */
    public static BufferedImage resize(String image, int scaledWidth, int scaledHeight) {
        String inputImagePath = "build/classes/Images/" + image;
        // reads input image
        File inputFile = new File(inputImagePath);
       
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
        }
        
        return null;        
    }
    
    /**
     * Sets JButton's icon with the passed imaged
     * The image is resized to JButton's dimensions 
     * @param button JButton to set icon to
     * @param img  file's name + extension
     */
    public static void image(javax.swing.JButton button, String img){
        int x = button.getWidth();
        int y = button.getHeight();
        
        button.setIcon(new javax.swing.ImageIcon( resize(img, x, y) ));
    }
    
    /**
     * Sets JLabel's icon with the passed imaged
     * The image is resized to JLabel's dimensions 
     * @param label JLabel to set icon to
     * @param img file's name + extension
     */
    public static void image(javax.swing.JLabel label, String img){
        int x = label.getWidth();
        int y = label.getHeight();
        
        label.setIcon(new javax.swing.ImageIcon( resize(img, x, y)));
        
    }  
    
    /**
     * Sets JFrame/Window
     * JFrame is set to be centered on the screen
     * JFrame is locked to the passed dimensions:
     *      JFrame can not be resize using mouse
     * @param window JFrame to be modified
     * @param windowW Width to set JFrame
     * @param windowH Heigh to set JFrame
     * @param Exit_ON_close 
     */
    public static void window(JFrame window, int windowW, int windowH, boolean Exit_ON_close ){
        if(Exit_ON_close){
            window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }else{
            window.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }
        window.setBounds(new java.awt.Rectangle(0, 23, windowW, windowH));
        window.setMaximumSize(new java.awt.Dimension(windowW, windowH));
        window.setMinimumSize(new java.awt.Dimension(windowW, windowH));
        window.setPreferredSize(new java.awt.Dimension(windowW, windowH));
        window.setSize(new java.awt.Dimension(windowW, windowH));
        window.getContentPane().setLayout(null);
        window.setLocationRelativeTo(null);
    }
    
    /**
     * Sets JFrame/Window
     * JFrame is set to be centered on the screen
     * JFrame is locked to the passed dimensions:
     *      JFrame can not be resize using mouse
     * Sets passed JLabel to JFrame's dimensions
     * Sets the heading of the JFrame/window
     * @param window JFrame to be modified
     * @param backGround JLabel to bet set with JFrame's dimensions
     * @param heading JFrame/window heading
     * @param windowW Width to set JFrame
     * @param windowH Heigh to set JFrame
     * @param Exit_ON_close
     * @return index of JLabel inside ContentPane
     */
    public static int window(JFrame window,javax.swing.JLabel backGround, String heading,int windowW, int windowH, boolean Exit_ON_close ){
        
        window(window, windowW, windowH, Exit_ON_close);
        
        window.setTitle(heading);
    
        window.getContentPane().add(backGround);
        backGround.setBounds(0, 0, window.getWidth(), window.getHeight());
        return window.getContentPane().getComponentCount();
        
    }
    
    /**
     * Sets JFrame/Window
     * JFrame is set to be centered on the screen
     * JFrame is locked to the passed dimensions:
     *      JFrame can not be resize using mouse
     * Sets passed JLabel to JFrame's dimensions
     * Sets passed image to JLabel's icon
     *      The passed image is resized to JFrame's dimensions
     * Sets the heading of the JFrame/window
     * @param window JFrame to be modified
     * @param backGround JLabel to bet set with JFrame's dimensions
     * @param img file's name + file's extension
     * @param heading JFrame/window heading
     * @param windowW Width to set JFrame
     * @param windowH Heigh to set JFrame
     * @param Exit_ON_close 
     * @return index of JLabel inside ContentPane
     */
    public static int window(JFrame window,javax.swing.JLabel backGround, String img, String heading,int windowW, int windowH, boolean Exit_ON_close ){  
        int i = window(window, backGround, heading, windowW, windowH, Exit_ON_close );
        Setting.image(backGround, img); 
        return i;
    }
    
    /**
     * Sets JButton's location and dimensions
     * @param frame JFrame
     * @param button JButton to be modified
     * @param x horizontal component relative to the JFrame/window
     * @param y vertical component relative to the JFrame/window
     * @param w JButton's width
     * @param h JButton's heigh
     * @param transparent
     * @return index of JButton inside ContentPane
     */
    public static int button(JFrame frame, javax.swing.JButton button, int x, int y, int w, int h, boolean transparent){
        frame.getContentPane().add(button);
        button.setBounds(x, y, w, h);
        if(transparent){
            button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            button.setContentAreaFilled(transparent);
        }   
        return frame.getContentPane().getComponentCount();
    }
    
    /**
     * Sets JFrame's location and dimensions
     * @param frame JFrame
     * @param label JLabel to be modified
     * @param x horizontal component relative to the JFrame/window
     * @param y vertical component relative to the JFrame/window
     * @param w JLabel's width
     * @param h JLabel's heigh
     * @param raised
     * @return  index of JLabel inside ContentPane
     */
    public static int frame(JFrame frame, javax.swing.JLabel label, int x, int y, int w, int h, boolean raised){
        frame.getContentPane().add(label);
        label.setBounds(x, y, w, h);
        if(raised){
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        } 
        return frame.getContentPane().getComponentCount();
    }
    
    /**
     * Sets JTextField's location and dimensions
     * Sets JTextField's text to "URW Chancery L" font
     * Text is Centered in JTextField
     * @param frame JFrame
     * @param input JTextField to be modified
     * @param fontSize 
     * @param x horizontal component relative to the JFrame/window
     * @param y vertical component relative to the JFrame/window
     * @param w JTextField's width
     * @param h JTextField's heigh
     * @return index of JTextField inside ContentPane
     */
    public static int inputField(JFrame frame, javax.swing.JTextField input, int fontSize, int x, int y, int w, int h){
        frame.getContentPane().add(input);
        input.setBounds(x, y, w, h);
        input.setFont(new java.awt.Font("URW Chancery L", 1, fontSize)); 
        input.setHorizontalAlignment(JTextField.CENTER);
        return frame.getContentPane().getComponentCount();
    }
    
    /**
     * Sets text of the passed JButton
     * Sets text to "URW Chancery L" font
     * @param button JButton
     * @param text text to be set to
     * @param fontSize
     * @param color text color
     */
    public static void buttonText(javax.swing.JButton button, String text, int fontSize, java.awt.Color color){
        button.setFont(new java.awt.Font("URW Chancery L", 1, fontSize)); 
        button.setForeground(color);
       
        button.setText(text);
    }
    
    /**
     * Sets text of the passed JLabel
     * Sets text to "URW Chancery L" font
     * Text is Centered
     * @param label JLabel to be modified
     * @param text text to be set to
     * @param fontSize
     * @param color text color
     */
    public static void frameText(javax.swing.JLabel label, String text, int fontSize, java.awt.Color color){
        label.setFont(new java.awt.Font("URW Chancery L", 1, fontSize)); 
        label.setForeground(color);
        label.setText(text);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }
    
    /**
     * Sets JFrame/window text
     * Text is added as a JFrame
     * Text is tokenized when there is a "\n" in it
     * Text is Centered
     * @param frm JFrame to be modified
     * @param text text to be set to
     * @param fontSize
     * @param color text color
     * @param x horizontal component relative to JFrame/window
     * @param y vertical component relative to JFrame/window
     * @param w JFrame's width
     * @param h JFrame's heigh
     * @param raised
     * @return index of the first JTextField inside ContentPane
     */
    public static int windowText(JFrame frm, String text, int fontSize, java.awt.Color color, int x, int y, int w, int h, boolean raised){
        String lines[] = text.split("\\r?\\n");
        javax.swing.JLabel line;
       
        for(int i = 0; i < lines.length; ++i){
            int newY = y + (i*h);
            
            line = new javax.swing.JLabel();
            frm.getContentPane().add(line);
            frame(frm, line, x, newY, w, h,raised);
            frameText(line, lines[i], fontSize, color);
        }
        
        return frm.getContentPane().getComponentCount() - lines.length;
    }  
}
