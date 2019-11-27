/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;
/**
 *
 * @author lamnguyen
 */
public class Card extends JButton{
    
    
    private int price;
    private String cardName;
    private int player;
    private int cardNumber;
    
    //private LinkedList<BufferedImage> cardImages;
    
    //private LinkedList<BufferedImage> cardGenerator;
   
    
    public Card(String name) {
        
        this.player = player;
        this.cardName = name;
       
    }
    
    public Card cardGenerator(){
        setCardNumber((int) (Math.random() * 5));
        Card newCard = new Card("");
        if(getCardNumber() == 0){
            newCard.setCardName("FireBreathing");
            newCard.setPrice(4);
        } else if(getCardNumber() == 1) {
            newCard.setCardName("FriendofChildren");
            newCard.setPrice(3);
        } else if(getCardNumber() == 2) {
            newCard.setCardName("Gourmet");
            newCard.setPrice(4);
        } else if(getCardNumber() == 3) {
            newCard.setCardName("Regeneration");
            newCard.setPrice(4);
        } else if(getCardNumber() == 4) {
            newCard.setCardName("SpikedTail");
            newCard.setPrice(5);
        }
        return newCard;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        if(this.getCardName() == "FireBreathing"){
            return 4;
        } else if(this.getCardName() == "FriendofChildren") {
            return 3;
        } else if(this.getCardName() == "Gourmet") {
            return 4;
        } else if(this.getCardName() == "Regeneration") {
            return 4;
        } else if(this.getCardName() == "SpikedTail") {
            return 5;
        } 
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the cardNumber
     */
    public int getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the cardName
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * @param cardName the cardName to set
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    
   
    
}
