import java.util.*;
public class Deck 
{
   //instance var
    protected ArrayList<Card> cards;
   
   public Deck() {
       ArrayList<Card> cardBuilder = new ArrayList<Card>();
       /*
       /these arrays cycle through each card in the correct order
       /Starting with the first loop containing spades and diamonds and
       /then going to clubs and hearts
       */
       
       int[] rankLoopPart1 = {11,2,3,4,5,6,7,8,9,10,12,13,14};
       int[] rankLoopPart2 = {14,13,12,10,9,8,7,6,5,4,3,2,11};
       int[] suitLoopPart1 = {3,1};
       int[] suitLoopPart2 = {4,2};
       
       //loops
       for(int i : suitLoopPart1) {
           for(int j : rankLoopPart1) {
               cardBuilder.add(new Card(j , i));
           }
       }
       for(int i : suitLoopPart2) {
           for(int j : rankLoopPart2) {
               cardBuilder.add(new Card(j , i));
           }
       }
       cards = cardBuilder;
   }
   
   public ArrayList<Card> getDeck() {
       return cards;
   }
   
   public int numCards() {
       return cards.size();
   }
   
   public Card drawCardDeck() {
       if(cards.size() > 0) {
           Card draw = cards.get(0);
           cards.remove(0);
           return draw;
       } else {
           return null;
       }
   }
   
   public String toString() {
       String cheese = "";
       for(Card i : cards) {
           cheese += i + "|";
       }
       return cheese;
   }
}
