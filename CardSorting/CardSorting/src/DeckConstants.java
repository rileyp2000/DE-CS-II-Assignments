/**
 * A class of constants to be used in Deck and Card classes
 * 
 * @author Sean Gibbons
 *
 */
public class DeckConstants {
	// Values taken from a standard 52 card set
	public final static int NUM_OF_SUITS = 4;
	public final static int RANK_PER_SUIT = 13;
	public final static int TOTAL_CARDS = NUM_OF_SUITS * RANK_PER_SUIT;

	// Used in ensuring the columns line up correctly, each part of the Card's
	// toString needs the appropriate number of characters
	public final static int LENGTH_OF_RANK_STRING = 6;
	public final static int LENGTH_OF_SUIT_STRING = 6;

}
