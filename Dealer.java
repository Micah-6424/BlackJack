import java.awt.Font;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.applet.*;

public class Dealer extends Player {

	// Player info
	private Player player;
	private Hand playerH;
	// dealer info
	private Player dealer;
	private Hand dealerH;
	// game info
	private Shoe shoe;
	private int roundCount = 1;
	private boolean noMoney = false;
	private double currentBet;
	private boolean dealerStands = false;
	private boolean playerStands = false;
	// image
	ImageIcon image = new ImageIcon("backround.jpg");
	// frame
	private JFrame frame;

	public Dealer() {

	}

	public void start() {

		if (roundCount == 1) {
			music();
			frameCreate();
			printRules();
			createPlayer();
			createDealer();
			shoeCreate();

			popupNoResponse("Great Lets start!", 30);

		}

		if (roundCount > 1) {
			exit();
			player.getPHand().clearHand();
			dealer.getPHand().clearHand();
			popupNoResponse("Bankroll: $" + player.getBankroll(), 30);
			playerStands = false;
			dealerStands = false;
		}
		setGameBet();
		dealStartingCards();
		gameOver();
		playersTurn();
		playerStands = true;
		gameOver();
		dealersTurn();
		dealerStands = true;
		gameOver();
	}

	// Print game rules
	public void printRules() {
		popupNoResponse("<html><br> ♣ Welcome ♠ to <span style=\"color: rgb(184, 49, 47);\"> ♦ Blackjack! ♥</html>", 30);
	}

	// get player info
	// create player
	public void createPlayer() {
		double br;
		do {
			br = popUpInputExact("Please enter your bankroll", 30);
		} while (br < 0);

		playerH = new Hand();
		player = new Player(playerH, br);
	}

	public void createDealer() {

		dealerH = new Hand();
		dealer = new Player(dealerH, -1);
	}

	// create shoe (consturctor?)
	public void shoeCreate() {
		shoe = new Shoe(4);
		shoe.shuffle();
	}

	// start
	public void setGameBet() {
		if (player.getBankroll() == 0) {
			popupNoResponse("\nTime for you to stop playing, you lost enough money already!", 30);
			noMoney = true;
			System.exit(1);
		} else {
			do {
				double amount = popUpInputExact(
						"<html><h1>Round " + roundCount + "</h1>" + invisibleLine() + "<br> Your current balance is $"
								+ player.getBankroll() + "<br>How much would you like to bet?</html>",
						30);
				currentBet = amount;
			} while (currentBet > player.getBankroll() || currentBet <= 0);

		}
		player.setBankroll(player.getBankroll() - currentBet);

	}

	public void checkOutOfMoney() {
		if (noMoney == true) {

			popupNoResponse("\nGAME OVER!", 30);
		} else {

		}
	}

	public void dealStartingCards() {
		player.hit(shoe);
		dealer.hit(shoe);
		player.hit(shoe);
		dealer.hit(shoe);
	}

	public boolean push() {
		return playerH.getValue() == dealerH.getValue() && playerStands && dealerStands;
	}

	public void gameOver() {
		if (playerH.getValue() == 21 && dealerH.getValue() < 21 && !dealerStands && playerH.getSize() == 2) {

			popupNoResponse("<html>" + invisibleLine() + "BLACKJACK! : collect $" + currentBet * 1.5 + "</html>", 50);
			player.setBankroll(currentBet + currentBet * 1.5 + player.getBankroll());
			roundCount++;
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			start();
		} else if (playerH.getValue() > 21) {
			popupNoResponse("<html>BUST!</html>", 30);
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			roundCount++;
			start();
		} else if (playerStands && playerH.getValue() <= 21 && dealerStands && dealerH.getValue() > 21) {
			popupNoResponse("YOU WIN : collect $" + currentBet, 30);
			player.setBankroll(currentBet + currentBet + player.getBankroll());
			roundCount++;
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			start();
		} else if (dealerStands && playerStands && playerH.getValue() > dealerH.getValue() && playerH.getValue() < 50) {
			popupNoResponse("YOU WIN : collect $" + currentBet, 30);
			player.setBankroll(currentBet + currentBet + player.getBankroll());
			roundCount++;
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			start();
		} else if (dealerStands && playerStands && playerH.getValue() == dealerH.getValue()) {
			popupNoResponse("<html>PUSH</html>", 30);
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			player.setBankroll(player.getBankroll() + currentBet);
			roundCount++;
			start();
		} else if (push()) {
			popupNoResponse("<html>PUSH</html>", 30);
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			player.setBankroll(player.getBankroll() + currentBet);
			roundCount++;
			start();
		} else if (playerH.getValue() > dealerH.getValue() && playerH.getValue() <= 21 && playerH.getSize() > 2
				&& dealerStands && playerStands) { // win 21
			popupNoResponse("YOU WIN : collect $" + currentBet, 30);
			player.setBankroll(currentBet + currentBet + player.getBankroll());
			roundCount++;
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			start();
		} else if (playerH.getValue() > dealerH.getValue() && playerH.getValue() == 21 && playerH.getSize() == 2) {
			popupNoResponse("BLACKJACK! : collect $" + currentBet * 1.5, 30);
			player.setBankroll(currentBet + currentBet * 1.5 + player.getBankroll());
			roundCount++;
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			start();
		} else if (playerH.getValue() < dealerH.getValue() && dealerH.getValue() <= 21 && (playerStands == true)) {
			popupNoResponse("Dealer Wins : you lose $" + currentBet, 30);
			roundCount++;
			popupNoResponse("<html><h1>Game Results<h1>" + invisibleLine() + "<br>" + printGame() + "</html>", 50);
			start();
		} else {
		}

	}

	public void playersTurn() {
		while (playerH.getValue() < 21) {

			boolean choiceMade = false;
			do {

				int choice = (int) popUpHit("<html><h2>Current Bet $" + currentBet + "\t|| \t Bankroll $"
						+ player.getBankroll() + "<br>" + printLine() + "</h2>" + invisibleLine() + "<br>Dealer:"
						+ dealer.dealersHandStart() + "<br>Player: " + player.getPlayerUnicode() + " "
						+ player.getPHand().getValue() + "<br><br></html>", 60);
				if (choice == 1) {
					player.hit(shoe);
					choiceMade = true;
				} else if (choice == 2) {
					choiceMade = true;
					playerStands = true;
					return;
				} else if (choice == 3) {
					choiceMade = true;
					doubleDown();
					if (playerStands) {
						return;
					}
				} else {

				}

			} while (!choiceMade);

			choiceMade = false;

		}
	}

	public boolean doubleDown() {

		if (playerH.getSize() == 2 && player.getBankroll() >= currentBet) {
			player.hit(shoe);
			playerStands = true;
			player.setBankroll(player.getBankroll() - currentBet);
			currentBet = currentBet * 2;

			return true;

		} else {
			popupNoResponse("You can not double down!", 30);
			return false;
		}
	}

	public void dealersTurn() {
		popupNoResponse("DEALERS TURN", 50);

		popupNoResponse(dealer + "", 50);
		while (true) {
			if (dealerH.getValue() < 17) {
				dealer.hit(shoe);
				popupNoResponse("Dealer Hit", 50);
				popupNoResponse("\nDealer\n" + dealer + "\n", 50);
			}
			if (dealerH.getValue() >= 17) {
				break;
			}
		}

		dealerStands = true;
		return;
	}

	public void exit() {
		if (player.getBankroll() == 0) {
			popupNoResponse("\nTime for you to stop playing, you lost enough money already!", 30);
			noMoney = true;
			System.exit(1);
		}
		boolean responce = false;
		do {
			int check = (int) popUpPlaying("\nWould you like to keep playing?", 30);
			if (check == 1) {
				responce = true;
			} else if (check == 2) {

				popupNoResponse("\n\nTHANKS FOR PLAYING\nYou leave with $" + player.getBankroll(), 30);
				System.exit(1);
			} else {
			}
		} while (!responce);

	}

	public String printLine() {
		return "⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯";
	}

	public String printGame() {
		return "<html>Dealer: " + dealer + "<br>Player: " + player + "</html>";
	}

	public String invisibleLine() {
		return "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
	}

	public void frameCreate() {
		frame = new JFrame();
		frame.setSize(1000, 1000);

		try {
			URL picture = this.getClass().getResource("/org/imgs/Game.jpg");
			frame.setContentPane(new JLabel(new ImageIcon(picture)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.pack();
		frame.setVisible(true);
	}

	public void popupNoResponse(String dialogue, int fontSize) {
		String title = "Blackjack";
		JLabel label = new JLabel(dialogue);
		Font f = new Font("Arial", Font.BOLD, fontSize);
		label.setFont(f);
		JOptionPane.showMessageDialog(frame, label, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public int popUpHit(String dialogue, int fontSize) {
		String title = "Blackjack";
		JLabel label = new JLabel(dialogue);
		Font f = new Font("Arial", Font.BOLD, fontSize);
		label.setFont(f);
		String[] choices = { "Hit", "Stand", "Doubledown" };
		String choice = (String) JOptionPane.showInputDialog(frame, label, title, JOptionPane.INFORMATION_MESSAGE, null,
				choices, choices[0]);
		if (choice.equals("Hit")) {
			return 1;
		} else if (choice.equals("Stand")) {
			return 2;
		} else if (choice.equals("Doubledown")) {
			return 3;
		}
		return -1;
	}

	public double popUpPlaying(String dialogue, int fontSize) {
		String title = "Blackjack";
		JLabel label = new JLabel(dialogue);
		Font f = new Font("Arial", Font.BOLD, fontSize);
		label.setFont(f);
		String[] choices = { "Yes", "No" };
		String choice = (String) JOptionPane.showInputDialog(frame, label, title, JOptionPane.INFORMATION_MESSAGE, null,
				choices, choices[0]);
		if (choice.equals("Yes")) {
			return 1;
		} else if (choice.equals("No")) {
			return 2;
		} else {
			return -1;
		}

	}

	public double popUpInputExact(String dialogue, int fontSize) {
		String title = "Blackjack";
		JLabel label = new JLabel(dialogue);
		Font f = new Font("Arial", Font.BOLD, fontSize);
		label.setFont(f);
		boolean responce = false;
		while (true) {
			double choiceDouble = 0.0;
			try {
				String choice = (String) JOptionPane.showInputDialog(frame, label, title,
						JOptionPane.INFORMATION_MESSAGE);

				choiceDouble = Double.parseDouble(choice);
				responce = true;
			} catch (Exception e) {
				responce = false;
			}
			if (!responce) {

			} else {
				return choiceDouble;
			}

		}

	}

	public void music() {
		try {
			  AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/wav/blackjackMusic.wav"));
			  Clip clip = AudioSystem.getClip();
			  clip.open(audio);
			  clip.start();
			} 
			catch(Exception e ) {
				System.out.println("Error, music not loaded");
			} 
	}



}