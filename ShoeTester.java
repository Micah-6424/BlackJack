public class ShoeTester
{
    public static void main(String[] args)
    {
        System.out.println("Normal deck");
        Deck x = new Deck();
        System.out.println(x);
        System.out.println("cards in deck: " + x.numCards());
        System.out.println("removing: " + x.drawCardDeck());
        System.out.println(x);
        System.out.println("cards in deck: " + x.numCards());
        
        System.out.println("--------");
        System.out.println("Shoe with 4 decks");
        Shoe y = new Shoe(4); //create Shoe
        //y.shuffle(); //works properly
        System.out.println(y.getShoe());
        System.out.println("--------");
        System.out.println(y);  // toString()
        System.out.println("cards in shoe: " + y.shoeSize()); //size()
        
        System.out.println("removing: " + y.drawCard()); // draw()
        System.out.println(y); 
        System.out.println("cards in shoe: " +y.shoeSize());
        
        System.out.println("--------");
        System.out.println(y + "\nAdding deck to shoe"); 
        y.addDeck(); //adds one deck SHOE NOW HAS 5 DECKS
        System.out.println(y);
        System.out.println("cards in shoe: " + y.shoeSize()); // size continues to change
        System.out.println("--------");
        System.out.println("Before shuffle");
        System.out.println(y.shoeSize());
        System.out.println("after shuffle");
        y.shuffle();
        System.out.println(y);
        System.out.println(y.shoeSize());
        System.out.println("Shuffled size: should be 5 decks: " + y.getShoe().size());
        System.out.println("-------- \nTesting extreme cases\n");
        
        Shoe xyz = new Shoe(2);
        System.out.println(xyz);
        System.out.println("Original size: " + xyz.getShoe().size());
        for(int i = 0; i<1000; i++) {
            xyz.drawCard();
        }
        System.out.println(xyz.getShoe() );
        System.out.println(xyz.drawCard());
        System.out.println(xyz.shoeSize());
        xyz.addDeck();
        System.out.println(xyz);
        for(int i = 0; i<10; i++) {
            xyz.shuffle();
            System.out.println(xyz);
        }
        
        System.out.println("Ending size: " + xyz.getShoe().size() + " This is actualy correct because deck was added");
        
        System.out.println("removing: " + xyz.drawCard());
        System.out.println(xyz);
    }
}