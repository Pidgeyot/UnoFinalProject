
/*Author: Paige Mabbitt
 *Date: November 15th, 2020
 *This is all my own work
 */
import java.util.ArrayList;

public class Deck {
	// create private variables
	private int deckSize = 108;
	ArrayList<CardStructure> deck = new ArrayList<CardStructure>();

	// constructor
	public Deck(int deckSizeVal) {
		this.deckSize = deckSizeVal;
	}

	// getters
	public int getDeckSize() {
		return deckSize;
	}

	// setters
	public void setDeckSize(int input) {
		deckSize = input;
	}

	// methods
	public ArrayList<CardStructure> populateDeck() {

		String currentColor = "";

		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				currentColor = "Red";
			} else if (i == 1) {
				currentColor = "Yellow";
			} else if (i == 2) {
				currentColor = "Green";
			} else if (i == 3) {
				currentColor = "Blue";
			}
			// for each color ( one for each of the 4 iteration of the four loop
			// create one 0 card, one Wild card,
			// two of each other number card, skips, reverses, and 2+
			deck.add(new CardStructure(currentColor, "0"));
			for (int j = 0; j < 2; j++) {
				deck.add(new CardStructure(currentColor, "1"));
				deck.add(new CardStructure(currentColor, "2"));
				deck.add(new CardStructure(currentColor, "3"));
				deck.add(new CardStructure(currentColor, "4"));
				deck.add(new CardStructure(currentColor, "5"));
				deck.add(new CardStructure(currentColor, "6"));
				deck.add(new CardStructure(currentColor, "7"));
				deck.add(new CardStructure(currentColor, "8"));
				deck.add(new CardStructure(currentColor, "9"));
				deck.add(new CardStructure(currentColor, "skip"));
				deck.add(new CardStructure(currentColor, "reverse"));
				deck.add(new CardStructure(currentColor, "2+"));
			}
			deck.add(new CardStructure("", "Wild"));
			// deck.add(new CardStructure("", "4+"));

		}

		return deck;
	}

	// choose random card out of deck
	public static CardStructure chooseCard(ArrayList<CardStructure> deck) {
		// create cardStructure with default values
		CardStructure card = new CardStructure("Yellow", "8");
		// set the card structure to a random object from deck
		card = (deck.get((int) (Math.random() * deck.size())));
		// remove the card from deck
		deck.remove(card);
		// return card
		return card;
	}

}
