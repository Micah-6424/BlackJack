public class DeckTester
{
   public static void main(String[] args)
   {
       Deck a = new Deck(); // +Deck()
       System.out.println(a.getDeck()); // +getDeck()
       System.out.println("cards left: " + a.numCards());
       System.out.println();
       System.out.println("removing: " + a.drawCardDeck()); //+drawCard() (top card)
       System.out.println();
       System.out.println(a.getDeck());
       System.out.println("cards left: " + a.numCards());
       System.out.println();
       System.out.println(a); //+toString()
   }
}
