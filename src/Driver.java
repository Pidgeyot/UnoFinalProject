
/* Driver
 * Author: Paige Mabbitt
 * Date: November 20th, 2020
 * play and print methods borrowed from in class exercise, the rest is my own work
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	// instantiate variables
	public static Deck deck = new Deck(108);
	public static Hand hand = new Hand();
	public static CardStructure playCard;
	public static ArrayList<CardStructure> player;
	public static int nextPlayer = 1;
	public static int playerTurn = 1;
	public static ArrayList<CardStructure> hasUno = null;
	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		// Print instructions
		System.out.printf(
				"Welcome to UNO! When typing commands, please type the\ncommand, then a space and type the card as displayed.\n(Ex. Play Yellow 8. It is case sensitive!) Have fun!\n\n");
		// instantiate player hand arrayLists and deck
		ArrayList<CardStructure> player1;
		ArrayList<CardStructure> player2;
		ArrayList<CardStructure> player3;
		ArrayList<CardStructure> player4;
		ArrayList<CardStructure> playDeck = deck.populateDeck();
		// instantiate hands
		hand.instHands();
		// assign each player a unique hand
		player1 = hand.getHand1();
		player2 = hand.getHand2();
		player3 = hand.getHand3();
		player4 = hand.getHand4();
		// set the first play card equal to a random card from the deck
		playCard = Deck.chooseCard(playDeck);
		// run nextPlayer using the starting playCard and player hands
		nextPlayer(playCard, player1, player2, player3, player4);
	}

	// Print
	private static void print(ArrayList<CardStructure> myCards) {
		System.out.println(myCards);
	}

	// play using the current player hand
	public static void play(ArrayList<CardStructure> player) {
		// tell the player which hand is being displayed
		System.out.printf("\nThis is player %d's hand:\n", playerTurn);
		// print current hand
		print(player);
		// check hand for uno
		checkForUno(player);
		// print out information for the player
		System.out.println("---------------------");
		System.out.printf("This is the card in play: %s\n\n", playCard);
		System.out.println("Commands");
		System.out.println("[DRAW] [PLAY] [UNO]");
		System.out.println("---------------------");
		System.out.println("Please enter a command: ");
		// detect input
		String commandTyped = console.nextLine();
		// tell the player what they typed
		System.out.printf("This is what was typed: %s\n", commandTyped);
		// instantiate new instance of commands
		Commands processCommand = new Commands();
		// set player equal to outcome of processComand with args of commandTyped and
		// player
		player = processCommand.processComand(commandTyped, player);
		// check for a win
		checkForWin(player);
	}

	// set playCare
	public static void setPlayCard(CardStructure newPlayCard) {
		playCard = newPlayCard;
	}

	// getPlayCard
	public static CardStructure getPlayCard() {
		return playCard;
	}

	// check current hand for uno
	public static void checkForUno(ArrayList<CardStructure> currentPlayer) {
		// if the size of the hand is 1
		if (currentPlayer.size() == 1) {
			// set the current hand as hasUno
			hasUno = currentPlayer;
			// output the player has uno
			System.out.printf("Player %d has uno!\n", playerTurn);
		}
		// if the current player is the hasUno but the size has changed
		if (currentPlayer == hasUno && currentPlayer.size() != 1) {
			// set hasUno to null
			hasUno = null;
		}
	}

	// return hasUno
	public static ArrayList<CardStructure> hasUnoCheck() {
		return hasUno;
	}

	// set hasUno
	public static void setHasUno(ArrayList<CardStructure> input) {
		hasUno = input;
	}

	// check current hand for win
	public static void checkForWin(ArrayList<CardStructure> currentPlayer) {
		// if deck size is equal to zero
		if (currentPlayer.size() == 0) {
			// declare the player has one
			System.out.printf("Player %d has won!\n", playerTurn);
			// close scanner
			console.close();
			// stop the program
			System.exit(0);
		}
	}

	// move to next player
	public static void nextPlayer(CardStructure playCard, ArrayList<CardStructure> player1,
			ArrayList<CardStructure> player2, ArrayList<CardStructure> player3, ArrayList<CardStructure> player4) {
		// for the int playerTurn, decide which players turn it is
		// after each case, set playerTurn to equal the next case when ran again
		switch (nextPlayer) {
		case 1:
			player = player1;
			playerTurn = 1;
			nextPlayer = 2;
			break;
		case 2:
			player = player2;
			playerTurn = 2;
			nextPlayer = 3;
			break;
		case 3:
			player = player3;
			playerTurn = 3;
			nextPlayer = 4;
			break;
		case 4:
			player = player4;
			playerTurn = 4;
			nextPlayer = 1;
			break;
		default:
			System.out.println("Uh-oh! Something went wrong");
		}
		// run play using the set player
		play(player);
		// after the play, run nextPLayer again
		nextPlayer(playCard, player1, player2, player3, player4);

	}
}
