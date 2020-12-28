
/*
 * Author: Paige Mabbitt
 * Date: December 6th, 2020
 * This is borrowed from in class example Uno Example and modified
 */
import java.util.ArrayList;

public class CheckForMatch {

	private static int index = 0;

	// check deck for math
	public static boolean checkForMatch(String cardToCheck, ArrayList<CardStructure> playerHand) {
		// loop through list to find card to remove
		for (CardStructure card : playerHand) {
			// get index of card to check
			if (card.getCardFaceWithNum().equals(cardToCheck)) {
				return (true);
			} else {
				index++;
			}
		}
		// return in case the card was not found
		return false;

	}

}
