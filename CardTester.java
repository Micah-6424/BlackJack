import java.util.*;
public class CardTester
{
    //Red
    private static final int DIAMONDS = 1;
    private static final int HEARTS = 2;
    //Black
    private static final int SPADES = 3;
    private static final int CLUBS = 4;
    
    //non numbered cards
    private static final int ACE = 11;
    private static final int JACK = 12;
    private static final int QUEEN = 13;
    private static final int KING = 14;
    
    
    public static void main(String[] args)
    {
        Card AceOfDiamonds = new Card(ACE , DIAMONDS);
        System.out.println(AceOfDiamonds);
        
        Card kingOfClubs = new Card(KING , CLUBS);
        System.out.println(kingOfClubs);
        
        Card fourOfHearts = new Card(4 , HEARTS);
        System.out.println(fourOfHearts);
        
        Card queenOfSpades = new Card(QUEEN , SPADES);
        System.out.println(queenOfSpades);
        System.out.println("--------");
        
        
        // Scanner sc = new Scanner(System.in);
        // System.out.print("What is your name: ");
        // String name = sc.nextLine();
        
        // System.out.print("How much money do you have: ");
        // int money = sc.nextInt();
        
        // //WARNING after scanner reads int, it breaks it when going back 
        // //to string
        // sc.nextLine(); // fixes it
        // System.out.print("Do you want to start: ");
        // String start = sc.nextLine(); // wont work
        
        
        // System.out.println("\nname: " + name + "\nmoney: " + money 
        // + "\nStart?: " + start );
        
    }
}