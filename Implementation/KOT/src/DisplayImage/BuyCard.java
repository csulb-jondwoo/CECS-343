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
    
    private String card1, card2, card3, card4, card5;
    private LinkedList<Card> storeCards;
    private LinkedList <Monster> monsters;
    private final LinkedList <JButton> cardButtons;
    private LinkedList<String> cardName;
    private Monster curMonster;
    private JButton cardButton;
    private JLabel backGround;
    private final int heading;
    private javax.swing.JButton Confirm;
    private Card card;
    private int check0, check1, check2;
    String cName = "";
    private CardBank cardBank;
    private int selectedCard;
    private JButton refresh;
//    public BuyCard(BuyCard buyCard, Monster curMonster) {
//        Setting.window(this, buyCard.getWidth(), buyCard.getHeight(), true);
//        this.setContentPane(buyCard.getContentPane());
//        this.cards = buyCard.cards;
//        this.monsters = buyCard.monsters;
//        this.cardButtons = buyCard.cardButtons;
//        this.cardName = buyCard.cardName;
//        this.backGround = buyCard.backGround;
//    }
    public BuyCard(LinkedList <Monster> monsters, JButton refresh) {
        this.cardBank = new CardBank();
        this.refresh = refresh;
        refresh.addActionListener(this::refreshActionPerformed);
        this.monsters = monsters;
        this.curMonster = monsters.get(0);
        this.storeCards = new LinkedList<Card>();
        monsters = new LinkedList<Monster>();
        cardName = new LinkedList<String>();
        cardButtons = new LinkedList<JButton>();
        backGround = new JLabel();
        card1 = "FireBreathing";
        card2 = "FriendofChildren";
        card3 = "Gourmet";
        card4 = "Regeneration";
        card5 = "SpikedTail";
        cName = "";
        
        cardName.add(card1);
        cardName.add(card2);
        cardName.add(card3);
        cardName.add(card4);
        cardName.add(card5);
        
        Confirm = new javax.swing.JButton();
        
        int windowW = 1200;
        int windowH = 800;
        int windowMX = windowW/2;
       
        Setting.button(this, Confirm, 0, 0, 100, 30, false);
        Confirm.setText("Confirm");
        Confirm.setVisible(false);
        Confirm.addActionListener(this::ConfirmActionPerformed);
        int size;
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
            
//            if(storeCards.isEmpty()){
//                storeCards.add(newCard);
//            }else{
//                
//                for(int j = 0; j < storeCards.size(); ++j){
//                    if(storeCards.get(j).getCardName() == newCardName){
//                        newCard = card.cardGenerator();
//                        newCardName = newCard.getCardName();
//                    }else{
//                        storeCards.add(newCard);
//                    }
//                }
//                
//                
//                storeCards.add(newCard);
//            }
            // Check to make sure we dont get the same cards
//            if(i == 0) {
//                check0 = index;
//                
//            } else if(i == 1) {
//                check1 = index;
//            } else if(i == 2) {
//                check2 = index;
//            }
//            if(i == 1) {
//                while(index == check0) {
//                    index = card.cardGenerator();
//                }
//            }
//            else if(i == 2) {
//                while(index == check1 || index == check0) {
//                    index = card.cardGenerator();
//                }
//            }
//            
            setCard(newCard, curMonster.getPlayer(),x, y, 250, 266);
            
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
            
            //get a new card from bank
            //add new card to storeCards
            //refresh window with storeCards.size()
            updateWindow(storeCards.size());
                
        } else {
            JOptionPane.showMessageDialog( null, curMonster.getpLabel().getText() + " NOT enough EP!!" );
        }
        
        
        

     }
     
     private void setCard(Card newCard, int playerNumber,int x, int y, int w, int h){
        
//        cardButton = new JButton();
        
        Setting.button(this, newCard, x, y, w, h, true);
        Setting.image(newCard, newCard.getCardName() + ".jpg");
//        cardButtons.add(cardButton);
        cardButtons.add(newCard);
        
    }
     private void CardAction(int i){
        selectedCard = i;
        moveConfirmCancelButtons(cardButtons.get(selectedCard));
        
        //card = new Card(monsters.size() + 1, cardName.get(i));//creating the monster with name and player number
//        String cName = "";
//        if(i == 0) {
//            cName = cardName.get(check0);
//        } else if( i == 1) {
//            cName = cardName.get(check1);
//        } else if( i == 2) {
//            cName = cardName.get(check2);
//        } 
    }
     private void moveConfirmCancelButtons(javax.swing.JButton card){
        
        int x = card.getX() + (card.getWidth()-Confirm.getWidth())/2 ;
        int y = card.getY() + 200;
        
        Confirm.setLocation(x, y);
        Confirm.setVisible(true); 
    }
     
    public Card removeCard(int index){
        Card card =  storeCards.get(index);
        storeCards.remove(index);
        return card;
    }
    
    public void refreshActionPerformed(java.awt.event.ActionEvent evt){
       updateWindow(storeCards.size());
    }
    
    public void updateWindow(int size){
        this.curMonster = monsters.get(0);
        
        JLabel line = (JLabel) getContentPane().getComponent(heading);
        line.setText(curMonster.getpLabel().getText());
        
         for(int i = 0; i < size; i++) {
            int x = 70;
            int y = 130;
            int k = i % 3;
            
            if(k == 0){
                y += ((i/3)*(266 +  50));
            }else{
                x = x + k*(300 + 80);    
                y = y + ((int)Math.floor(i/3) * (266 + 50));
            }
            
            Card newCard = storeCards.get(i);

            setCard(newCard, curMonster.getPlayer(),x, y, 250, 266);
            
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
    }
}
