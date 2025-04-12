public class Player extends Hand
{
   protected Hand pHand;
   protected double bankroll;
   
   public Player(Hand pHand , double bankroll) {
       this.pHand = pHand;
       this.bankroll = bankroll;
   }
   
   public Player() {
       
   }
   
   public Hand getPHand() {
       return pHand;
   }
   
   public double getBankroll() {
       return bankroll;
   }
   
   public void setBankroll(double newBankroll) {
       bankroll = newBankroll;
   }
   
   public Card hit(Shoe s) {
       s.reshuffle();
       return pHand.addCardToHand(s);
   }
   
   public String getPlayerUnicode() {
       return pHand.getUnicodeInHand();
   }
   
   public String toString() {
       return 
    	/*"Hand: " + this.getPHand() 
       + */ "\nCards: " + getPlayerUnicode()
       + "Value: " + pHand.getValue() ;
       
   }
   
   public String dealersHandStart() {
       //dealer.getPHand().getHand().get(1)
       return 
    	/*"Hand: x:x|" + this.getPHand().getHand().get(1) + "" 
       + */ " 🂠 | " + this.getPHand().getHand().get(1).getUnicode() + " |"
       + " " + this.getPHand().getHand().get(1).getValue();
       
   }
}
