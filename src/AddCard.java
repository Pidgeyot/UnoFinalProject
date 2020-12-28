
/* AddCard
 * Author: Paige Mabbitt
 * Date: November 20th, 2020
 * Borrowed from in class exercise Uno Example
 */
import java.util.ArrayList;

public class AddCard {
	// add card to hand
	public ArrayList<CardStructure> addCard(CardStructure cardToAdd, ArrayList<CardStructure> playerHand) {
		// Add the card to the players hand
		playerHand.add(cardToAdd);
		return playerHand;
	}

}
