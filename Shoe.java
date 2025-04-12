import java.util.*;
public class Shoe extends Deck
{
    //instance var
    protected ArrayList<Card> cardsInShoe = new ArrayList<Card>();
    protected int numDecks;
    
    //constructor
    public Shoe(int numDecks) {
        this.numDecks = numDecks;
        for(int i = 0; i< numDecks; i++){ //adds x decks to shoe
            for(Card j : cards) {
                cardsInShoe.add(j);
            }
        }
    }
    
    public Shoe() {
        
    }
    
    //methods
    public int shoeSize() {
        return cardsInShoe.size();
    }
    
    public ArrayList<Card> getShoe() {
        return cardsInShoe;
    }
    
    public void addDeck() {
        for(Card j : cards) {
            cardsInShoe.add(j);
        }
        numDecks++;
    }
    
    public Card drawCard() {
        if(cardsInShoe.size() > 0) {
           Card draw = cardsInShoe.get(0);
           cardsInShoe.remove(0);
           return draw;
       } else {
           return null;
       }
    }
    
    public void shuffle() { 
        //rebuilding deck (not shuffled)
        // if(cardsInShoe.size() > 20) {
        //     return;
        // }
        
        
        cardsInShoe.clear();
        
        
        ArrayList<Card> unshuffled = new ArrayList<Card>();
        for(int i = 0; i< numDecks; i++){ //adds x decks to shoe
            for(Card j : cards) {
                unshuffled.add(j);
            }
        }
       // unshuffled = full shoe INDEX: 0-259 with deck size of 5
        
        //creates random indexs
        Integer[] indexs = new Integer[unshuffled.size()];
        int index = 0;
        while(indexs[unshuffled.size()-1] == null) {
            int randomNum = (int)(Math.random()*unshuffled.size());
            if(!Arrays.asList(indexs).contains(randomNum)) {
                indexs[index] = randomNum;
                index++;
            } 
        }
        
        //adds random indexed cards to shoe
        for(int i : indexs) {
            cardsInShoe.add(unshuffled.get(i));
        }
        
    }
    
    
    public void reshuffle() { 
        if(cardsInShoe.size() > 20) {
            return;
        }
        System.out.println("\nReshuffling...\n");
        cardsInShoe.clear();
        
        
        ArrayList<Card> unshuffled = new ArrayList<Card>();
        for(int i = 0; i< numDecks; i++){ //adds x decks to shoe
            for(Card j : cards) {
                unshuffled.add(j);
            }
        }
       // unshuffled = full shoe INDEX: 0-259 with deck size of 5
        
        //creates random indexs
        Integer[] indexs = new Integer[unshuffled.size()];
        int index = 0;
        while(indexs[unshuffled.size()-1] == null) {
            int randomNum = (int)(Math.random()*unshuffled.size());
            if(!Arrays.asList(indexs).contains(randomNum)) {
                indexs[index] = randomNum;
                index++;
            } 
        }
        
        //adds random indexed cards to shoe
        for(int i : indexs) {
            cardsInShoe.add(unshuffled.get(i));
        }
        
    }
    
    //toString
    public String toString() {
        String cheese = "";
        for(Card i : cardsInShoe) {
           cheese += i + "|";
       }
       return cheese;
        
    }
    
    
    
}
