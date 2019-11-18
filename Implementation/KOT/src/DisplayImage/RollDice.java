/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hueletl
 */
public class RollDice extends javax.swing.JFrame {
    
    private LinkedList <Monster> monsters;
    private LinkedList <Die> dice;
    private LinkedList <Die> diceToRoll;
    private javax.swing.JLabel backGround;
    private Die die;
    private javax.swing.JButton roll;
    private javax.swing.JButton resolve;
    private javax.swing.JButton confirm;
    private int heading;
    private int rollCounter;
    private int initCounter;
    private Die curDie;
    private boolean turnSelected;
    private Monster curMonster;
    private LinkedList<Integer> smashCounter;
    
    public RollDice(LinkedList <Monster> monsters, Monster curMonster, boolean turnSelected){
        
        this.monsters = monsters;
        this.curMonster = curMonster;
        this.turnSelected = turnSelected;
  
        dice = new LinkedList<>();
        diceToRoll = new LinkedList<>();
        backGround = new javax.swing.JLabel();
        roll = new javax.swing.JButton();
        resolve = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        rollCounter = 3;
        initCounter = monsters.size();
        smashCounter = new LinkedList<>();
        for(int i = 0; i < monsters.size(); ++i){
            smashCounter.add(0);
        }
        
        Setting.button(this, confirm, 0, 0, 75, 20, false);
        Setting.buttonText(confirm, "confirm", 16, Color.BLACK);
        confirm.addActionListener(this::confirmActionPerformed);
        confirm.setVisible(false);
        
        
        
        //Creates the dice
        int x;
        int y = 115;
        int w = 90;
        int h = w;
        
        for(int i = 0; i < 8; ++i){
            x = 60;
            die = new Die();
            x += i*(115);
            Setting.button(this, die, x, y, w, h, true);
            Setting.image(die, "faceSMASH.png");
            die.setEnabled(false);
            
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
        y = 240;
        w = 150;
        h = 50;
        Setting.button(this, roll, x, y, w, h, false);
        Setting.buttonText(roll, "roll", 32, Color.BLACK);
        roll.addActionListener(this::rollActionPerformed);
        
        x += w + 100;
        Setting.button(this, resolve, x, y, w, h, false);
        Setting.buttonText(resolve, "resolve", 32, Color.BLACK);
        resolve.addActionListener(this::resolveActionPerformed);
        resolve.setEnabled(false);

        heading = Setting.windowText(this, curMonster.getpLabel().getText() + "\nClick roll button", 35, Color.BLACK, 0, 20, 1000, 40, false);
        Setting.window(this, backGround, "Roll Dice", 1000, 400, false);
        
    }
    
    public void die0ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(0);
        moveConfirm(curDie);
    }
    public void die1ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(1);
        moveConfirm(curDie);
    }
    public void die2ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(2);
        moveConfirm(curDie);
    }
    public void die3ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(3);
        moveConfirm(curDie);
    }
    public void die4ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(4);
        moveConfirm(curDie);
    }
    public void die5ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(5);
        moveConfirm(curDie);
    }
    public void die6ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(6);
        moveConfirm(curDie);
    }
    public void die7ActionPerformed(java.awt.event.ActionEvent evt){
        curDie = dice.get(7);
        moveConfirm(curDie);
    }
    public void rollActionPerformed(java.awt.event.ActionEvent evt){
        
        confirm.setVisible(false);
        resolve.setEnabled(true);
        BufferedImage  image;
        for(int i = 0; i < diceToRoll.size(); ++i){
            die = diceToRoll.get(i);
            image = die.roll();
            // add rotate image here
            die.setIcon(new javax.swing.ImageIcon(image));  
//            die.setEnabled(true);
        }
        for(int i = 0; i < dice.size(); ++i){
            dice.get(i).setEnabled(true);
        }
        javax.swing.JLabel line = (javax.swing.JLabel) getContentPane().getComponent(heading + 1);
        line.setText( "Click which dice you want to keep");
        
        diceToRoll = new LinkedList<>(dice);
        
        rollCounter -= 1;
        if(rollCounter == 0){
            roll.setEnabled(false);
        }
        
       
    }
    public void resolveActionPerformed(java.awt.event.ActionEvent evt){
        if(turnSelected){
            
        }else{
            int smash = 0;
            for(int i = 0; i < dice.size(); ++i){
                int face = dice.get(i).getFaceUp();
                if(face == 5){
                   smash += 1;   
                }   
            }
            int index = curMonster.getPlayer()-1;
            smashCounter.set(index, smash); 
            System.out.println(index + ": " + smashCounter.get(index));
            
            
            int winner = -1;
            if(index > monsters.size()-2){
                
                int larger = 0;
      
                for(int i = 0; i < smashCounter.size(); ++i){
                    smash = smashCounter.get(i);
                    if(smash > larger){
                        larger = smash;
                        winner = i;
                    }
                }  
                curMonster = monsters.get(winner);
                monsters.remove(winner);
                monsters.addFirst(curMonster);
                for(int i = 0; i < monsters.size(); ++i){
                    monsters.get(i).setTurn(i + 1);
                }
                turnSelected = true;
                JOptionPane.showMessageDialog( null, curMonster.getpLabel().getText() + " won first turn and moves into Tokyo" );
                moveInToTokyo(curMonster);
            }

            initCounter -= 1;
            if(initCounter < 1){
                this.setVisible(false);
            }
        }
        rollCounter = 3;
        roll.setEnabled(true);
        resolve.setEnabled(false);
        for(int i = 0; i < dice.size(); ++i){
            dice.get(i).setEnabled(false);
        }
        int index = monsters.indexOf(curMonster) + 1;
        curMonster = monsters.get(index);
        
        javax.swing.JLabel line = (javax.swing.JLabel) getContentPane().getComponent(heading);
        line.setText(curMonster.getpLabel().getText());
        line = (javax.swing.JLabel) getContentPane().getComponent(heading+1);
        line.setText("Click roll button");
        
    }
    public void confirmActionPerformed(java.awt.event.ActionEvent evt){
        confirm.setVisible(false);
        diceToRoll.remove(curDie);
    }
    
    private void moveConfirm(javax.swing.JButton button){
        int x = button.getX() + 7;
        int y = button.getY() + 35;
        confirm.setLocation(x, y);
        confirm.setVisible(true);
    }
    
    public void moveInToTokyo(Monster monster){
        int x = 870;
        int y = 60;
        monster.getpLabel().setLocation(x, y);
        monster.getpIcon().setLocation(x-20, y+40); 
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
