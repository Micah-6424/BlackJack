public class HandTester {
	public static void main(String[] args) {
		/**
		 * Create a Hand and a Shoe.
		 * 
		 * Can you draw cards from the shoe and add them to the hand? Does the size of
		 * the Shoe work correctly? Do all of the Hand methods work correctly when
		 * interacting with the Shoe
		 */
		 
		Shoe s1 = new Shoe(2);
		Hand h1 = new Hand();
		System.out.println("Starting...\n\n");
		System.out.println("Shoe: " + s1);
		System.out.println("Hand: " + h1);
		System.out.println("Cards: " + h1.getUnicodeInHand());
        System.out.println("Status: " + h1.getStatus());
		System.out.println("\n\nMoving 4 cards from Shoe to hand...\n\n");
		h1.addCardToHand(s1);
		h1.addCardToHand(s1);
		h1.addCardToHand(s1);
		h1.addCardToHand(s1);
		System.out.println("Shoe: " + s1);
		System.out.println("Hand: " + h1);
		System.out.println("Cards: " + h1.getUnicodeInHand());
		System.out.println("Value: " + h1.getValue());
		System.out.println("Status: " + h1.getStatus());

		/*
		 * in my previous tester I demonstrated all of the needed methods so i have
		 * pasted it below
		 */
		 
		System.out.println("\n\n*Stuff in Hand Part 1 tester*...");
		Shoe shoe = new Shoe(2);
        Hand hand = new Hand();
        shoe.shuffle();
        System.out.println("before card added to hand....\n\n");
        System.out.println("Shoe: " + shoe.getShoe());
        System.out.println("Hand: " + hand.getHand());
        System.out.println("toString: " + hand);
        System.out.println("Cards: " + hand.getUnicodeInHand());
        System.out.println("Status: " + hand.getStatus());
        System.out.println("\n\nafter card added to hand....\n\n");
        hand.addCardToHand(shoe);
        hand.addCardToHand(shoe);
        hand.addCardToHand(shoe);
        System.out.println("Shoe: " + shoe.getShoe());
        System.out.println("Hand: " + hand.getHand());
        System.out.println("toString: " + hand);
        System.out.println("Cards: " + hand.getUnicodeInHand());
        System.out.println("Value: " + hand.getValue());
        System.out.println("Status: " + hand.getStatus());
        System.out.println("Size: " + hand.getSize());
        System.out.println("Bust?: " + hand.bust());
        System.out.println("BlackJack?: " + hand.checkBlackJack() + "\n\n");
        System.out.println("21?: " + hand.check21());
        System.out.println("\n\ntesting aces... \n\n");
        Hand testH = new Hand();
        testH.addCardToHand(new Card(10 ,1));
        testH.addCardToHand(new Card(11,2));
        testH.addCardToHand(new Card(11 ,4));
        System.out.println("Hand: " + testH.getHand());
        System.out.println("toString: " + testH);
        System.out.println("Cards: " + testH.getUnicodeInHand());
        System.out.println("Value: " + testH.getValue());
        System.out.println("Status: " + testH.getStatus());
        System.out.println("Size: " + testH.getHand().size());
        System.out.println("Bust?: " + testH.bust());
        System.out.println("BlackJack?: " + testH.checkBlackJack());
        System.out.println("21?: " + testH.check21());
        System.out.println("\n\nclearing test (to see if things update properly)... \n\n");
        testH.getHand().clear();
        System.out.println("Clear: " + testH.getHand());
        System.out.println("Value: " + testH.getValue());
        System.out.println("Status: " + testH.getStatus());
        System.out.println("Bust?: " + testH.bust());
        System.out.println("BlackJack?: " + testH.checkBlackJack());
        System.out.println("21?: " + testH.check21());
         
        System.out.println("\n\nTesting new hand...\n\n");
        Hand testH2 = new Hand();
        testH2.addCardToHand(new Card(11,3));
        testH2.addCardToHand(new Card(11,2));
        testH2.addCardToHand(new Card(11,4));
        testH2.addCardToHand(new Card(6,1));
        testH2.addCardToHand(new Card(7,1));
        testH2.addCardToHand(new Card(2,3));
        testH2.addCardToHand(new Card(3,2));
        System.out.println("Hand: " + testH2.getHand());
        System.out.println("toString: " + testH2);
        System.out.println("Cards: " + testH2.getUnicodeInHand());
        System.out.println("Value: " + testH2.getValue());
        System.out.println("Status: " + testH2.getStatus());
        System.out.println("Size: " + testH2.getHand().size());
        System.out.println("Bust?: " + testH2.bust());
        System.out.println("BlackJack?: " + testH2.checkBlackJack());
        System.out.println("21?: " + testH2.check21());
        System.out.println("\n\ntest...\n\n");
        Hand testH3 = new Hand();
        testH3.addCardToHand(new Card(11 , 2));
        testH3.addCardToHand(new Card(2 , 4));
        testH3.addCardToHand(new Card(11 , 1));
        testH3.addCardToHand(new Card(11 , 3));
        testH3.addCardToHand(new Card(8 , 1));
        System.out.println("Hand: " + testH3.getHand());
        System.out.println("toString: " + testH3);
        System.out.println("Cards: " + testH3.getUnicodeInHand());
        System.out.println("Value: " + testH3.getValue());
        System.out.println("Status: " + testH3.getStatus());
        System.out.println("Size: " + testH3.getHand().size());
        System.out.println("Bust?: " + testH3.bust());
        System.out.println("BlackJack?: " + testH3.checkBlackJack());
        System.out.println("21?: " + testH3.check21());
        System.out.println("\n\nFinal test...\n\n");
        Hand testH4 = new Hand();
        testH4.addCardToHand(new Card(10 , 3));
        testH4.addCardToHand(new Card(11 , 4));
        System.out.println("Hand: " + testH4);
        System.out.println("toString: " + testH4);
        System.out.println("Cards: " + testH4.getUnicodeInHand());
        System.out.println("Value: " + testH4.getValue());
        System.out.println("Status: " + testH4.getStatus());
        System.out.println("Size: " + testH4.getHand().size());
        System.out.println("Bust?: " + testH4.bust());
        System.out.println("BlackJack?: " + testH4.checkBlackJack());
        System.out.println("21?: " + testH4.check21());
	}
}
