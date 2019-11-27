/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author lamnguyen
 */
public class BuyCard extends javax.swing.JFrame{
    
    private LinkedList<Card> storeCards;
    private LinkedList <Monster> monsters;
    private final LinkedList <JButton> cardButtons;
    private Monster curMonster;
    private JLabel backGround;
    private final int heading;
    private javax.swing.JButton Confirm;
    private Card card;
    
    private CardBank cardBank;
    private int selectedCard;
    private JLabel head;

    public BuyCard(LinkedList <Monster> monsters, JButton refresh) {
        this.cardBank = new CardBank();
        refresh.addActionListener(this::refreshActionPerformed);
        this.monsters = monsters;
        this.curMonster = monsters.get(0);
        this.storeCards = new LinkedList<>();
        cardButtons = new LinkedList<>();
        backGround = new JLabel();
        
        Confirm = new javax.swing.JButton();
        
//        int windowW = 1200;
//        int windowH = 800;
//        int windowMX = windowW/2;
       
        Setting.button(this, Confirm, 0, 0, 100, 30, false);
        Confirm.setText("Confirm");
        Confirm.setVisible(false);
        Confirm.addActionListener(this::ConfirmActionPerformed);
//        int size;
        if(cardBank.getSize()>0)
         
        for(int i = 0; i < 3; i++) {
            int x = 70;
            int y = 130;
            int k = i % 3;
            
            if(k == 0){
                y += ((i/3)*(266 +  50));
            }else{
                x = x + k*(300 + 80);    
                y = y + ((int)Math.floor(i/3) * (266 + 50));
            }
            
            int index = (int)(Math.random() * cardBank.getSize());
            
            Card newCard = cardBank.removeCard(index);
            storeCards.add(newCard);
            cardButtons.add(newCard);
            
            setCard(newCard, x, y, 250, 266);
            
            switch (i) {
                case 0:  
                    newCard.addActionListener(this::Card0ActionPerformed);
                    break;
                case 1:  
                    newCard.addActionListener(this::Card1ActionPerformed);
                    break;
                case 2:  
                    newCard.addActionListener(this::Card2ActionPerformed);
                    break;
                default:
                    break;
            }      
            
        }
       Setting.window(this, backGround, "Card Store", 1150, 600, false);
        heading = Setting.windowText(this, curMonster.getpLabel().getText() + "\nClick to buy card", 35, Color.BLACK, 0, 50, 1000, 40, false); 
        head = (JLabel) getContentPane().getComponent(heading);
    }
    
     private void Card0ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        CardAction(0);
        
        
         
    }                                          

    private void Card1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        CardAction(1);
        
    }                                          

    private void Card2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        CardAction(2);
        
    }                     
     
     
     private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {  
         
        int ep = Integer.parseInt(curMonster.getEP().getText());
     
        int price = storeCards.get(selectedCard).getPrice();
        if(ep >= price) {
            ep -= price;
            
            card = removeCard(selectedCard);//needs to check if cardBank has cards left
            curMonster.addCard(card);//if cardBank is empty, this line does not apply
            curMonster.getEP().setText(Integer.toString(ep));
            int pc = Integer.parseInt(curMonster.getPC().getText()) + 1;
            curMonster.getPC().setText(Integer.toString(pc));
            Confirm.setVisible(false);
            card.setVisible(false);
            //get a new card from bank
            //add new card to storeCards
            //refresh window with storeCards.size()
            updateWindow(storeCards.size());
                
        } else {
            JOptionPane.showMessageDialog( null, curMonster.getpLabel().getText() + " NOT enough EP!!" );
        }
        
        
        

     }
     
     private void setCard(Card newCard, int x, int y, int w, int h){
        
        Setting.button(this, newCard, x, y, w, h, true);
        Setting.image(newCard, newCard.getCardName() + ".jpg");

    }
     private void CardAction(int i){
        selectedCard = i;
        moveConfirmCancelButtons(cardButtons.get(selectedCard));
    }
     private void moveConfirmCancelButtons(javax.swing.JButton card){
        
        int x = card.getX() + (card.getWidth()-Confirm.getWidth())/2 ;
        int y = card.getY() + 200;
        
        Confirm.setLocation(x, y);
        Confirm.setVisible(true); 
    }
     
    public Card removeCard(int index){
        Card card =  storeCards.get(index);
//        storeCards.remove(index);
        return card;
    }
    
    public void refreshActionPerformed(java.awt.event.ActionEvent evt){
       updateWindow(storeCards.size());
        
    }
    
    public void updateWindow(int size){
        this.curMonster = monsters.get(0);
        head.setText(curMonster.getpLabel().getText());
    }
}
