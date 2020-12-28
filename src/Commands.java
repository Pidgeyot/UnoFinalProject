/* Commands
 * Author: Paige Mabbitt
 * Date: November 25th, 2020
 * DRAW was borrowed from in class exercise, the rest is my own work
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Commands {

	public ArrayList<CardStructure> processComand(String commandToProcess, ArrayList<CardStructure> playerHand) {
		Deck chooseDeck = new Deck(108);
		ArrayList<CardStructure> chooseCard = chooseDeck.populateDeck();
		// First we need to parse out the command if Play is the command
		// the card structure is always Face or Type and then the number with spaces
		// between
		String[] commandSplitted = commandToProcess.split(" ");
		// commandSplitted[0] = command
		// commandSplitted[1] = card Type (if available)
		// commandSplitted[2] = Card Number (if available)
		// Switch statement is used to transfer control to a
		// particular code block based on the tested variable
		switch (commandSplitted[0].toUpperCase()) {

		case "DRAW":
			// create cardStructure instance cardToAdd
			CardStructure cardToAdd = Deck.chooseCard(chooseCard);
			// create AddCard instance updateHand
			AddCard updateHand = new AddCard();
			// add cardToAdd to playerHand
			updateHand.addCard(cardToAdd, playerHand);
			// print out the card that was drawn and added
			System.out.println("The card drawn was " + cardToAdd);
			// exit case
			break;

		case "PLAY":

			// try to get the command
			try {
				String cardPlayed = commandSplitted[1] + " " + commandSplitted[2];
				// create instance of RemoveCard
				RemoveCard updateHandRemove = new RemoveCard();
				// instantiate scanner
				Scanner scanner = new Scanner(System.in);
				// if the command is either 4+ or Wild
				if (commandSplitted[1].matches("4+|Wild|")) {
					// if command is 4+
					if (commandSplitted[1].equals("4+")) {
						// unfinished
						System.out.println("Placeholder");
					}
					// if commandSplitted equal Wild
					if (commandSplitted[1].equals("Wild")) {
						// remove wild form hand
						updateHandRemove.getUpdatedHand(" Wild", playerHand);
						// ask the user to choose a new play card
						System.out.println("Please chose a new play card");
						// get player input
						String input = scanner.nextLine();
						// split input
						String[] newCard = input.split(" ");
						// put each input split into the commandSplitted array
						commandSplitted[1] = newCard[0];
						commandSplitted[2] = newCard[1];
						// create new CardStructure with inputed values
						CardStructure newPlayCard = new CardStructure(commandSplitted[1], commandSplitted[2]);
						// set newPlayCard to values
						Driver.setPlayCard(newPlayCard);
						// return the player hand
						return (playerHand);
					}
					// if command was not equal to 4+ or Wild, check if the current play card is
					// equal to Wild
				} else if (Driver.getPlayCard().getCard().equals(" Wild")) {
					// if true, remove the card typed from player hand
					updateHandRemove.getUpdatedHand(cardPlayed, playerHand);
					// create new CardStructure with inputed card
					CardStructure newPlayCard = new CardStructure(commandSplitted[1], commandSplitted[2]);
					// set the new play card as the play card
					Driver.setPlayCard(newPlayCard);
					// return playerHand
					return (playerHand);
					// if command card is not equal to 4+ or wild and the play card is not wild
					// check to see if the command card has the same color or value
				} else if (Driver.getPlayCard().getCard().equals(commandSplitted[1])
						|| Driver.getPlayCard().getCardNum().equals(commandSplitted[2])) {
					// if one of the values matches, check to make sure it is in the players hand
					if (CheckForMatch.checkForMatch(cardPlayed, playerHand) == true) {
						// if the command is a symbol
						if (commandSplitted[2].matches("skip|reverse|2+")) {
							// run proper symbol code (unfinished)
						} else {
							// else, remove the card typed from player hand
							updateHandRemove.getUpdatedHand(cardPlayed, playerHand);
							// create new CardStructure with inputed card
							CardStructure newPlayCard = new CardStructure(commandSplitted[1], commandSplitted[2]);
							// set the new play card as the play card
							Driver.setPlayCard(newPlayCard);
							// return playerHand
							return (playerHand);
						}
						// if checkMatch comes back false, tell the player
					} else {
						System.out.println("That card is not in your hand! Please input another command and card");
						// run play again with the same player
						Driver.play(playerHand);
					}
					// if the cards do not match, tell the player
				} else {
					System.out.println("That card does not match! Please input another command and card");
					// run play again with the same player
					Driver.play(playerHand);
				}
				// if command cannot be parsed, tell the player to input a proper command
			} catch (Exception e) {
				System.out.println("That was not a valid command and card. Please input command and card");
				// rubn play again with the same player
				Driver.play(playerHand);
			}
			// exit case
			break;

		case "UNO":
			// if the current player is the same one who has uno
			if (playerHand == Driver.hasUnoCheck() && Driver.hasUnoCheck() != null) {
				System.out.println("You called Uno! You're safe");
				// set hasUno to null
				Driver.setHasUno(null);
				Driver.play(playerHand);
				// if hasUno is already null, tell the player there is no one with Uno
			} else if (Driver.hasUnoCheck() == null) {
				System.out.println("There is no UNO to call right now!");
				// run play again with the same player
				Driver.play(playerHand);
			} else {
				// otherwise, tell the player they have called uno and two cards have been added
				// to the uno player
				System.out.println("You called Uno on someone else! They have two cards added to their deck");
				for (int i = 0; i < 2; i++)
					// add random card two times
					Driver.hasUno.add(Deck.chooseCard(chooseCard));
				Driver.play(playerHand);
			}
			// exit case
			break;
		default:
			// tell the use the command they entered was not valid
			System.out.println("That was not a valid command. Please type another");
			// run play again with the same player
			Driver.play(playerHand);
		}
		// if all else fails, return player hand
		return (playerHand);
	}

}
