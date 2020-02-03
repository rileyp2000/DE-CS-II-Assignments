/**
 * <p>
 * This is the class that represents a card for hw assignment 2
 * </p>
 * 
 * 
 * @author Patrick Riley
 */

public class Card implements Comparable<Card>{

	private String suit;
	private String rank;
	private static final String[] SUITS = DeckConstants.getSUITS();
	private static final String[] RANKS = DeckConstants.getRANKS();
	

	public Card() {
		suit = SUITS[0];
		rank = RANKS[0];
	}
	
	/**
	 * 
	 * @param c another card to be copied
	 */
	public Card(Card c){
		suit = c.getSuit();
		rank = c.getRankStr();
	}
	
	/**
	 * 
	 * @param sui Suit represented as an Integer between 0 and 3 inclusive
	 * @param ran Rank represented as an int between 2 and 14 inclusive
	 */
	public Card(int sui, int ran) {
		if (sui < SUITS.length)
			suit = SUITS[sui];
		else
			suit = SUITS[0];

		if (ran != 0 && ran != 1)
			rank = RANKS[ran-2];
		else
			throw new IllegalArgumentException("Invalid Number passed in");
	}
	
	/**
	 * 
	 * @param sui Suit represented as a String 
	 * @param ran Rank represented as a String
	 */
	public Card(String sui, String ran) {
		suit = SUITS[findSuit(sui)];
		rank = RANKS[findRank(ran)];
	}
	
	/**
	 * 
	 * @param sui Suit represented as a String
	 * @param ran Rank represented as an int between 2 and 14 inclusive
	 */
	public Card(String sui, int ran) {
		
		suit = SUITS[findSuit(sui)];
		
		if (ran != 0 && ran != 1)
			rank = RANKS[ran-2];
		else
			throw new IllegalArgumentException("Invalid Number passed in");	}
	
	/**
	 * 
	 * @param sui Suit represented as an Integer between 0 and 3 inclusive
	 * @param ran Rank represented as a String
	 */
	public Card(int sui, String ran) {
		
		if (sui < SUITS.length)
			suit = SUITS[sui];
		else
			suit = SUITS[0];
		
		rank = RANKS[findRank(ran)];
	}
	
	//Getters 
	/**
	 * 
	 * @return Suit the suit as a string
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * 
	 * @return suit the suit as an int
	 */
	public int getSuitInt(){
		return findSuit(suit);
	}
	
	/**
	 * 
	 * @return Rank the rank as an int
	 */
	public int getRank() {
		return findRank(rank);
	}
	
	/**
	 * 
	 * @return rank the rank as a String
	 */
	public String getRankStr(){
		return rank;
	}
	


	// Private helper methods
	/**
	 * 
	 * @param rank a particular rank
	 * @return int the index of the rank
	 */
	private int findRank(String rank) {
		for (int i = 0; i < RANKS.length; i++) {
			if (RANKS[i].trim().toLowerCase().equals(rank.trim().toLowerCase()))
				return i;
		}
		return 0;
	}
	
	/**
	 * 
	 * @param suit a particular suit
	 * @return int the index of the suit
	 */
	private int findSuit(String suit) {
		for (int i = 0; i < SUITS.length; i++)
			if (SUITS[i].trim().toLowerCase().equals(suit.trim().toLowerCase()))
				return i;
		return 0;
	}
	
	//Methods
	/**
	 * @return returns card in formula rank of suit
	 */
	public String toString(){
		return rank + " of " + suit;
	}
	
	/**
	 * @return if cards are equal based on suit and rank
	 * @param other another card 
	 */
	public boolean equals(Object other){
		if(other instanceof Card)
			return suit.equals(((Card)other).getSuit()) && rank.equals(((Card)other).getRankStr());
		else
			return false;
	}
	
	/**
	 * 
	 * @param c another card
	 * @return difference in rank between the cards
	 */
	public int compareTo(Card c){
		if(getSuitInt() != c.getSuitInt())
			return RANKS.length * (getSuitInt() - c.getSuitInt());
		else
			if(getRank() != c.getRank())
				return getRank() - c.getRank();
			else
				return 0;
	}
	
	
}
