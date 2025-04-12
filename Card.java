public class Card
{
	// suits
	
	// --Red
	// DIAMONDS = 1;
	// HEARTS = 2;
	// --Black
	// SPADES = 3;
	// CLUBS = 4;
	
	// non numbered cards
	// ACE = 11;
	    //ace is only worth one if it will prevent them from busting
	// JACK = 12;
	// QUEEN = 13;
	// KING = 14;
	
	// Instance var
	private int value;
	private int rank;
	private int suit;
	
    //cards
    private String[] allRanks = {"BLANK", "BLANK", "2","3","4","5","6","7",
                                "8","9","10","A", "J","Q","K"}; 
    
    private String[] allSuits = {"BLANK" , "♦","♥","♠","♣"};
    
    /*CodeHs has been having issues saving so I have copied it into
    a different IDE in case it deletes again */
    private String[][] unicode = {
        {},
        //Diamonds
        {"BLANK", "BLANK", "🃂","🃃","🃄","🃅","🃆","🃇","🃈","🃉","🃊","🃁", "🃋","🃍","🃎"},
        //Hearts
        {"BLANK", "BLANK", "🂲","🂳","🂴","🂵","🂶","🂷","🂸","🂹","🂺","🂱", "🂻","🂽","🂾"},
        //Spades
        {"BLANK", "BLANK", "🂢","🂣","🂤","🂥","🂦","🂧","🂨","🂩","🂪","🂡", "🂫","🂭","🂮"},
        //Clubs
        {"BLANK", "BLANK", "🃒","🃓","🃔","🃕","🃖","🃗","🃘","🃙","🃚","🃑", "🃛","🃝","🃞"}
        
    };
   
    //Contstructor
    public Card(int rank , int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    //getter methods
    
    public String getRank() {
        return allRanks[rank];
    }
    
    public String getSuit() {
        return allSuits[suit];
    }
    
    
    public int getValue() {
        value = rank;
        if(value > 11) 
            value = 10;
        return value;
    }
    
    public String getUnicode() {
        return unicode[suit][rank];
    }
    //to string
    public String toString() {
        return  getRank() + ":" + getSuit();
    }
    
}
