import java.util.*;
public class Hand extends Shoe
{
    //instance var
    private ArrayList<Card> cardsInHand;
    private int handValue;
    private int numCardsInHand;
    
    //constructor
   
    public Hand() {
        handValue = 0;
        numCardsInHand = 0;
        cardsInHand = new ArrayList<Card>();
    }
    
    //getter methods
    public ArrayList<Card> getHand() {
        return cardsInHand;
    }
    
    public int getHandValue() {
        return handValue;
    }
    
    public int numCards() {
        return numCardsInHand;
    }
    
    public Card addCardToHand(Shoe x) {
        Card a =  x.drawCard();
        cardsInHand.add(a);
        return a;
    }
    
    public void addCardToHand(Card x) {
        cardsInHand.add(x);
    }
    
    public void clearHand() {
        cardsInHand.clear();
    }
    
    public int getValue() {
        int hValue = 0;
        for(Card c : cardsInHand) {
            hValue += c.getValue();
        }
        
        if(hValue > 21) {
            for(Card c : cardsInHand) {
                if(c.getValue() == 11) {
                    hValue = hValue - 10;
                }
                if(hValue <= 21) 
                    break;
            }
        }
        return hValue;
    }
    
    public int getSize() {
        return this.getHand().size();
    }
    
    public boolean check21() {
        return this.getValue() == 21;
    }
    
    public boolean checkBlackJack() {
        return this.getValue() == 21 && this.getHand().size() == 2;
    }
    public boolean bust() {
        return this.getValue() > 21;
    }
    
    public boolean checkBust() {
        return this.getValue() > 21;
    }
    
    public String getUnicodeInHand() {
        String cheese = "";
        for(Card c : this.getHand()) {
            cheese += c.getUnicode() + " | ";
        }
        
        return cheese;
    }
    
    public String getStatus() {
        if(checkBust() == true) {
            return "Bust";
        } else if(checkBlackJack() == true) {
            return "BlackJack!";
        } else if(check21() == true) {
            return "21!";
        } else {
            return "Game is still running...";
        }
    }
    

    
    public String toString() {
        String cheese = "";
        for(Card i : cardsInHand) {
           cheese += i + "|";
       }
       return cheese;
        
    }
    
}
