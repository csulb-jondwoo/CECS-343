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
import javax.swing.JFrame;
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
    private final int heading;
    private int rollCounter;
    private int initCounter;
    private Die curDie;
    private Monster curMonster;
    private LinkedList<Integer> smashCounter;
    private JFrame newGame;
    private javax.swing.JButton yes;
    
    public RollDice(LinkedList <Monster> monsters, Monster curMonster, javax.swing.JButton yes){
        
        this.monsters = monsters;
        this.curMonster = curMonster;
        this.yes = yes;
        
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
        
        for(int i = 0; i < curMonster.getHowManyDice(); ++i){
            if(curMonster.getHowManyDice()>6){
                x = 60;
            }else{
                x = 60+115;
            }
            
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

        Setting.window(this, backGround, "Roll Dice", 1000, 400, false);
        heading = Setting.windowText(this, curMonster.getpLabel().getText() + "\nClick roll button", 35, Color.BLACK, 0, 20, 1000, 40, false);
        
        
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
        
        if(curMonster.getTurn() > 0){
            int counter0 = 1, 
                counter1 = 1, 
                counter2 = 1, 
                smash = 0;
            for (int i = 0; i < dice.size(); ++i){
                int face = dice.get(i).getFaceUp();
                switch(face){
                    case 0:
                        updateVP(1,counter0);
                        ++counter0;
                        break;
                    case 1:
                        updateVP(2,counter1);
                        ++counter1;
                        break;
                    case 2:
                        updateVP(3,counter2);
                        ++counter2;
                        break;
                    case 3:
                        int ep = Integer.parseInt(curMonster.getEP().getText());
                        ep += 1;
                        curMonster.getEP().setText(Integer.toString(ep));
                        break;
                    case 4:
                        int hp = Integer.parseInt(curMonster.getHP().getText());
                        
                        if(hp<10){
                            hp += 1;
                        }
                        curMonster.getHP().setText(Integer.toString(hp));
                        break;
                    case 5:
                        Monster other;
                        for(int j = 0; j < monsters.size(); ++j){
                            other = monsters.get(j);
                        
                            if(curMonster.isInsideTokyo()){
                            
                                if(curMonster != other){
                                    int curHp = Integer.parseInt(other.getHP().getText());
                                    curHp -= 1;
                                    other.getHP().setText(Integer.toString(curHp));
                                    checkIfLose(other);
                                }
                            
                            }else if(other.isInsideTokyo()){
                                int curHp = Integer.parseInt(other.getHP().getText());
                                curHp -= 1;
                                other.getHP().setText(Integer.toString(curHp));
                                checkIfLose(other);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
            int size = monsters.size();
            if( size > 0){
                curMonster = monsters.get((monsters.indexOf(curMonster) + 1)% size);
                curMonster.getPCurrent().setText(curMonster.getpLabel().getText());
            }
            this.setVisible(false);
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
            
            //selects who takes first turn
            int firstToBe = -1;
            if(index > monsters.size()-2){
                
                int larger = 0;
      
                for(int i = 0; i < smashCounter.size(); ++i){
                    smash = smashCounter.get(i);
                    if(smash > larger){
                        larger = smash;
                        firstToBe = i;
                    }
                }  
           
                curMonster = monsters.get(firstToBe);
                curMonster.getPCurrent().setText(curMonster.getpLabel().getText());
                curMonster.setInsideTokyo(true);
                
                
                monsters.remove(firstToBe);
                monsters.addFirst(curMonster);
                
                for(int i = 0; i < monsters.size(); ++i){
                    monsters.get(i).setTurn(i + 1);
                }
                
                JOptionPane.showMessageDialog( null, curMonster.getpLabel().getText() + " won first turn" );
                moveInToTokyo(curMonster);
            }else{
                index = monsters.indexOf(curMonster) + 1;
                curMonster = monsters.get(index);
                curMonster.getPCurrent().setText(curMonster.getpLabel().getText());
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
        monster.setInsideTokyo(true);
        String moves = monster.getpLabel().getText() + ": " +monster.getName() + "\n";
                   moves +=  "moves into Tokyo\n";
            JOptionPane.showMessageDialog( null, moves );
    }
    
    public void updateVP(int plus, int counter){

        if(counter > 2){
            int value = Integer.parseInt(curMonster.getVP().getText());
            
            if(counter == 3){
                value += plus;
            }else if(counter > 3){
                value += 1;
            }
            curMonster.getVP().setText(Integer.toString(value));
            checkIfWon(value);
            
        }      
                
        
    }
    
    public void checkIfLose(Monster other){
        int hp = Integer.parseInt(other.getHP().getText());
        if(hp < 1){
            
            other.getVP().setForeground(Color.GRAY);
            other.getHP().setForeground(Color.GRAY);
            other.getEP().setForeground(Color.GRAY);
            other.getPC().setForeground(Color.GRAY);
            other.getpLabel().setVisible(false);
            other.getpIcon().setVisible(false);
            
            String lost = other.getpLabel().getText() + ": " +other.getName() + "\n";
            lost +=  "lost\n";
            
            JOptionPane.showMessageDialog( null, lost );
            
            if(other.isInsideTokyo()){
                moveInToTokyo(curMonster);
            }
            
            monsters.remove(other);
            
            checkIfWon(0);
            
        }
    }
    
    public void checkIfWon(int value){
        if((value > 19) || (monsters.size() < 2)){
            String winner = curMonster.getpLabel().getText() + ": " +curMonster.getName() + "\n";
                   winner +=  "became King of Tokyo\n";
                   winner += "with " + value + " Victoy Points.";
            JOptionPane.showMessageDialog( null, winner );
            monsters.clear();
            
            newGame = new JFrame();
            newGame.setVisible(true);
            
            int x = newGame.getX() + 250;
            Setting.button(newGame, yes, x, 150, 100, 50, false);
            Setting.buttonText(yes, "yes", 35, Color.black);
            yes.addActionListener(this::yesActionPerformed);
            
            javax.swing.JButton no = new javax.swing.JButton();
            Setting.button(newGame, no, x+200, 150, 100, 50, false);
            Setting.buttonText(no, "no", 35, Color.black);
            no.addActionListener(this::noActionPerformed);
            
            Setting.window(newGame, 800, 300, true);
            Setting.windowText(newGame, "Do you want to Play again?", 40, Color.black, 0, 50, 800, 50, false);
            
            this.setVisible(false);
        }
    }
    
    public void yesActionPerformed(java.awt.event.ActionEvent evt){
        newGame = new HowManyPlayers(newGame);
        newGame.setVisible(true);
        
    }
    
    public void noActionPerformed(java.awt.event.ActionEvent evt){
        System.exit(0);
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
