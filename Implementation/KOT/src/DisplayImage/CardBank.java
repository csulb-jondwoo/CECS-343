/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayImage;

import java.util.LinkedList;

/**
 *
 * @author Hueletl
 */
public class CardBank {
    
    private LinkedList<Card> cardBank;
    
    public CardBank(){
        cardBank = new LinkedList<>();
        
        Card newCard;
        newCard = new Card("FireBreathing");
        newCard.setPrice(4);
        cardBank.add(newCard);
        
        newCard = new Card("FriendofChildren");
        newCard.setPrice(3);
        cardBank.add(newCard);
        
        newCard = new Card("Gourmet");
        newCard.setPrice(4);
        cardBank.add(newCard);
        
        newCard = new Card("Regeneration");
        newCard.setPrice(4);
        cardBank.add(newCard);
        
        newCard = new Card("SpikedTail");
        newCard.setPrice(5);
        cardBank.add(newCard);
    }
    
    public LinkedList<Card> getCardBank(){
        return cardBank;
    }
    
    public Card removeCard(int index){
        Card card = cardBank.get(index);
        cardBank.remove(index);
        return card;
    }
    
    public void addCard(Card card){
        cardBank.add(card);
    }
    
    public int getSize(){
        return cardBank.size();
    }
    
}
