
/**
 * Card class as part of Assignment 2
 * 
 * @author Sean Gibbons
 *
 */
public class Card implements Comparable<Card> {
	private int rank;
	private int suit;

	/************** CONSTRUCTORS *********/
	/**
	 * Default constructor creates Ace of Spades
	 */
	public Card() {
		rank = 1;
		suit = 0;
	}

	/**
	 * Constructor for int suit and int rank
	 * 
	 * @param suit
	 *            an int which will become the Card's suit
	 * @param rank
	 *            an int which will become the Card's rank
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;

	}

	/**
	 * Constructor for String suit and String rank
	 * 
	 * @param suit
	 *            a String which will become the Card's suit
	 * @param rank
	 *            a String which will become the Card's rank
	 */
	public Card(String suit, String rank) {
		this.suit = stringToIntSuit(suit);
		this.rank = stringToIntRank(rank);

	}

	/**
	 * Constructor for int suit and String rank
	 * 
	 * @param suit
	 *            an int which will become the Card's suit
	 * @param rank
	 *            a String which will become the Card's rank
	 */
	public Card(int suit, String rank) {

		this.suit = suit;
		this.rank = stringToIntRank(rank);
	}

	/**
	 * Constructor for String suit and int rank
	 * 
	 * @param suit
	 *            a String which will become the Card's suit
	 * @param rank
	 *            an int which will become the Card's rank
	 */
	public Card(String suit, int rank) {
		this.suit = stringToIntSuit(suit);
		this.rank = rank;

	}

	/**
	 * Copy constructor
	 * 
	 * @param o
	 *            the other Card to be copied
	 */
	public Card(Card o) {
		this.suit = o.getSuitInt();
		this.rank = o.getRank();

	}

	/************ GETTERS ***********/
	/**
	 * Returns the rank
	 * 
	 * @return the int value of rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns the suit
	 * 
	 * @return the suit as a String
	 */
	public String getSuit() {
		return intToStringSuit(suit);
	}

	/**
	 * Converts the int rank to the appropriate String
	 * 
	 * @return the String counterpart to the rank
	 */
	public String getRankStr() {
		return intToStringRank(rank);
	}

	/**
	 * Returns the int value of the suit
	 * 
	 * @return The int value of the Suit
	 */
	public int getSuitInt() {
		return suit;
	}

	@Override
	public String toString() {
		String r = getRankStr();
		String s = getSuit();

		// Adds the appropriate number of whitespaces to the rank so that, when placed
		// into columns in the Deck class, the String values of the Cards line up
		// correctly
		while (r.length() < DeckConstants.LENGTH_OF_RANK_STRING) {
			r = r + " ";
		}

		// Adds the appropriate number of whitespaces to the suit so that, when placed
		// into columns in the Deck class, the String values of the Cards line up
		// correctly
		while (s.length() < DeckConstants.LENGTH_OF_SUIT_STRING)
			s = s + " ";

		return r + " of " + s;
	}

	@Override
	public int compareTo(Card o) {
		// First compares based on suit but if suits equal then compares based on rank
		if (getSuitInt() - o.getSuitInt() == 0)
			return this.getRank() - o.getRank();
		else
			return getSuitInt() - o.getSuitInt();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Card))
			return false;
		else
			return this.compareTo((Card) o) == 0;

	}

	/******** HELPER METHODS ****/

	/**
	 * A helper method that returns the appropriate String value of the suit given
	 * as an int. This method is used to minimize the number of switch statements in
	 * the rest of the class.
	 * 
	 * @param s
	 *            the int value of a suit
	 * @return the String counterpart to the suit
	 */
	private String intToStringSuit(int s) {
		switch (s) {
		case 0:
			return "Clubs";
		case 1:
			return "Diamonds";
		case 2:
			return "Hearts";
		case 3:
			return "Spades";
		default:
			throw new IllegalArgumentException("Not a valid suit");
		}

	}

	/**
	 * A helper method that returns the appropriate int value of the suit given as a
	 * String. This method is used to minimize the number of switch statements in
	 * the rest of the class.
	 * 
	 * @param s
	 *            the String name of a suit
	 * @return the int value of the suit
	 */
	private int stringToIntSuit(String s) {
		s = s.trim().toLowerCase();
		switch (s) {
		case "clubs":
			return 0;
		case "diamonds":
			return 1;
		case "hearts":
			return 2;
		case "spades":
			return 3;
		default:
			throw new IllegalArgumentException("Not a valid suit");
		}

	}

	/**
	 * A helper method that returns the appropriate String value of a given int
	 * rank. This method is used to minimize the number of switch statements in the
	 * rest of the class.
	 * 
	 * @param r
	 *            the int value of a rank
	 * @return the String counterpart to the rank
	 */
	private String intToStringRank(int r) {
		switch (r) {
		case 1:
			return "Ace";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King ";
		default:
			throw new IllegalArgumentException("Not a valid rank");
		}

	}

	/**
	 * A helper method that returns the appropriate int value of a given String
	 * rank. This method is used to minimize the number of switch statements in the
	 * rest of the class.
	 * 
	 * @param r
	 *            the String name of a rank
	 * @return the int value of the rank
	 */
	private int stringToIntRank(String r) {
		r = r.trim().toLowerCase();

		switch (r) {
		case "ace":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		case "ten":
			return 10;
		case "jack":
			return 11;
		case "queen":
			return 12;
		case "king":
			return 13;
		default:
			throw new IllegalArgumentException("Not a valid rank");
		}

	}

}
