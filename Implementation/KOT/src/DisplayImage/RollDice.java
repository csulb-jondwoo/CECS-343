/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Hueletl
 */
public class RollDice extends javax.swing.JFrame {
    
    private LinkedList <Die> dice;
    private LinkedList <Die> diceToRoll;
    private javax.swing.JLabel backGround;
    private Die die;
    private javax.swing.JButton roll;
    private javax.swing.JButton resolve;
    private javax.swing.JButton confirm;
    private int heading;
    
    public RollDice(){
        dice = new LinkedList<>();
        diceToRoll = new LinkedList<>();
        backGround = new javax.swing.JLabel();
        roll = new javax.swing.JButton();
        resolve = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        
        
        Setting.button(this, confirm, 0, 0, 75, 20, false);
        Setting.buttonText(confirm, "confirm", 16, Color.BLACK);
        confirm.addActionListener(this::confirmActionPerformed);
        confirm.setVisible(false);
        
        
        
        //Creates the dice
        int x;
        int y = 75;
        int w = 90;
        int h = w;
        
        for(int i = 0; i < 8; ++i){
            x = 60;
            die = new Die();
            x += i*(115);
            Setting.button(this, die, x, y, w, h, true);
            Setting.image(die, "faceSMASH.png");
            
            switch (i) {
                case 0: 
                    die.addActionListener(this::die0ActionPerformed);
                    break;
                case 1:  
                    die.addActionListener(this::die1ActionPerformed);
                    break;
                case 2:  
                    die.addActionListener(this::die2ActionPerformed);
                    break;
                case 3:  
                    die.addActionListener(this::die3ActionPerformed);
                    break;
                case 4: 
                    die.addActionListener(this::die4ActionPerformed);
                    break;
                case 5: 
                    die.addActionListener(this::die5ActionPerformed);
                    break;
                case 6: 
                    die.addActionListener(this::die6ActionPerformed);
                    break;
                case 7: 
                    die.addActionListener(this::die7ActionPerformed);
                    break;
                default:
                    break;
            }  
            dice.add(die);
            diceToRoll.add(die);
        }
//        dice.get(0).setVisible(false);
//        dice.get(7).setVisible(false);
        
        x = 300;
        y = 200;
        w = 150;
        h = 50;
        Setting.button(this, roll, x, y, w, h, false);
        Setting.buttonText(roll, "roll", 32, Color.BLACK);
        roll.addActionListener(this::rollActionPerformed);
        
        x += w + 100;
        Setting.button(this, resolve, x, y, w, h, false);
        Setting.buttonText(resolve, "resolve", 32, Color.BLACK);
        resolve.addActionListener(this::resolveActionPerformed);
        

        Setting.window(this, backGround, "Logo.png", "Roll Dice", 1000, 400, false);
        heading = Setting.windowText(this, "Click roll button", 32, Color.BLACK, 0, 20, 1000, 40, false);

        
    }
    
    public void die0ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(0));
    }
    public void die1ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(1));
    }
    public void die2ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(2));
    }
    public void die3ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(3));
    }
    public void die4ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(4));
    }
    public void die5ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(5));
    }
    public void die6ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(6));
    }
    public void die7ActionPerformed(java.awt.event.ActionEvent evt){
        moveConfirm(dice.get(7));
    }
    public void rollActionPerformed(java.awt.event.ActionEvent evt){
        BufferedImage  image;
        for(int i = 0; i < diceToRoll.size(); ++i){
            die = diceToRoll.get(i);
            image = die.roll();
            // add rotate image here
            die.setIcon(new javax.swing.ImageIcon(image));     
        }
        javax.swing.JLabel line = (javax.swing.JLabel) getContentPane().getComponent(heading);
        line.setText( "Click which dice to roll again");
       
    }
    public void resolveActionPerformed(java.awt.event.ActionEvent evt){
        
    }
    public void confirmActionPerformed(java.awt.event.ActionEvent evt){
        confirm.setVisible(false);
    }
    
    private void moveConfirm(javax.swing.JButton button){
        int x = button.getX() + 7;
        int y = button.getY() + 35;
        confirm.setLocation(x, y);
        confirm.setVisible(true);
    }
    
    //NOT FUNCTIONING YET
    private void rotateImage(BufferedImage image) {
        Graphics g = null;
//        super.paintComponent(g);
        AffineTransform at = AffineTransform.getTranslateInstance(100, 100);
        at.rotate(Math.toRadians(45));
      
        Graphics2D g2 = (Graphics2D) g;
//        g2.rotate(Math.PI / 4, image.getWidth() / 2, image.getHeight() / 2);
        g2.drawImage(image, at, null);
    }
    

    
}
