
/* RemoveCard
 * Author: Paige Mabbitt
 * Date: November 20th, 2020
 * Borrowed from in class exercise
 */
import java.util.ArrayList;

public class RemoveCard {

	// define attributes
	private int index;

	public RemoveCard() {
		index = 0;
	}

	// remove card from player
	public ArrayList<CardStructure> getUpdatedHand(String cardToRemove, ArrayList<CardStructure> playerHand) {
		// loop through list to find card to remove
		for (CardStructure card : playerHand) {
			// get index of card to remove
			if (card.getCardFaceWithNum().equals(cardToRemove)) {
				// Remove card and return arrayList
				playerHand.remove(index);
				return (playerHand);
			} else {
				index++;
			}
		}
		// return in case the card was not found
		return playerHand;

	}

}
