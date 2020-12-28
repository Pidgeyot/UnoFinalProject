/* Hand
 * Author: Paige Mabbitt
 * Date: November 20th, 2020
 * createHand borrowed from in class exercise, the rest is my own work
 */

import java.util.ArrayList;

public class Hand {

	private ArrayList<CardStructure> hand1;
	private ArrayList<CardStructure> hand2;
	private ArrayList<CardStructure> hand3;
	private ArrayList<CardStructure> hand4;

	public ArrayList<CardStructure> createHand() {
		// Create an arrayList to add to the hand that is being dealt
		ArrayList<CardStructure> drawCard = new ArrayList<CardStructure>();
		Deck newDeck = new Deck(108);
		ArrayList<CardStructure> playDeck = newDeck.populateDeck();
		// Manually add cards (should be done randomly)
		for (int i = 0; i < 7; i++) {
			CardStructure cardToAdd = Deck.chooseCard(playDeck);
			drawCard.add(cardToAdd);
		}
		return (drawCard);
	}

	public void instHands() {
		// create the 4 hands
		setHand1();
		setHand2();
		setHand3();
		setHand4();
	}

	// setters
	public void setHand1() {
		hand1 = createHand();
	}

	public void setHand2() {
		hand2 = createHand();
	}

	public void setHand3() {
		hand3 = createHand();
	}

	public void setHand4() {
		hand4 = createHand();
	}

	// getters
	public ArrayList<CardStructure> getHand1() {
		return hand1;
	}

	public ArrayList<CardStructure> getHand2() {
		return hand2;
	}

	public ArrayList<CardStructure> getHand3() {
		return hand3;
	}

	public ArrayList<CardStructure> getHand4() {
		return hand4;
	}
}
