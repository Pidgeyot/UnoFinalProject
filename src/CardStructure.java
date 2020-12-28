/* CardStructure
 * Author: Paige Mabbitt
 * Date: November 25th, 2020
 * Borrowed from in class exercise Uno Example
 */
public class CardStructure {
	// Define Attributes
	private String cardColor;
	private String cardVal;

	// constructor
	public CardStructure(String cardColorVal, String cardValVal) {
		this.cardColor = cardColorVal;
		this.cardVal = cardValVal;
	}

	public CardStructure(Object chooseCard) {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override annotation informs the compiler that the element is meant to
	 * override an element declared in a superclass. Overrride the toString() method
	 * in the java class. A string representation of an object can be obtained using
	 * the toString() method. This method is overriden so that the object values can
	 * be returned.
	 * 
	 */
	@Override
	public String toString() {
		return String.format(cardColor + " " + cardVal);
	}

	// getter
	public String getCard() {
		return (cardColor);
	}

	public String getCardNum() {
		return (cardVal);
	}

	public String getCardFaceWithNum() {
		return (cardColor + " " + cardVal);
	}

}
