import java.util.Arrays;

/**
 * Represents a group of Card objects
 * 
 * @author Sean Gibbons
 *
 */

public class Deck {
	private Card[] cards;
	private int topCard;// keeps track of the card currently in the last position
	private boolean sorted;
	private static Card[] temp;

	/**
	 * The no-args constructor which will automatically make a standard 52 card Deck
	 */
	public Deck() {
		resetDeck();
	}

	/**
	 * Constructor with one arg which creates and then shuffles the Deck
	 */

	public Deck(boolean sort) {
		this.resetDeck();
		if (!sort)
			this.shuffle();
	}

	/**
	 * Copy constructor
	 * 
	 * @param o
	 *            the Deck to be copied
	 */
	public Deck(Deck o) {
		this.cards = o.getCards();
		this.topCard = o.getTopCard();
		o.sorted = o.getSorted();

	}

	/**
	 * Creates a standard 52 card deck
	 */
	public void resetDeck() {
		cards = new Card[DeckConstants.TOTAL_CARDS];
		topCard = cards.length - 1;
		int r = 1;
		int s = 0;
		for (int i = 0; i < DeckConstants.TOTAL_CARDS; i++) {
			cards[i] = new Card(s, r);
			r++;
			if (r > DeckConstants.RANK_PER_SUIT) {
				r = 1;
				s++;
			}
		}
		sorted = true;

	}

	/**
	 * A simple check of whether the object is sorted
	 * 
	 * @return whether the object is sorted
	 */
	public boolean getSorted() {

		return sorted;
	}

	/**
	 * Returns the array of Cards
	 * 
	 * @return the array of Cards
	 */
	public Card[] getCards() {
		return cards;
	}

	/*
	 * Sets the cards of a deck
	 */
	public void setCards(Card[] c) {
		cards = c;
	}

	/**
	 * Gets the Card at a specific position in the Deck
	 * 
	 * @param i
	 *            the index of the Card to check
	 * @return the Card at the given position
	 */
	public Card getCard(int i) {
		return cards[i];
	}

	/**
	 * Sets the value of the Card at a given position to a given Card
	 * 
	 * @param i
	 *            the index of the Card to change
	 * @param c
	 *            the Card to change
	 */

	public void setCard(int i, Card c) {
		cards[i] = new Card(c);
	}

	/**
	 * The topCard is the card at the last position in the cards array, equal to
	 * cards.length-1
	 * 
	 * @return the current topCard
	 */
	public int getTopCard() {
		return topCard;

	}

	/**
	 * Randomly shuffles the cards in the deck
	 */
	public void shuffle() {
		sorted = false;
		for (int i = topCard - 1; i > 0; i--) {
			int randomPos = (int) (Math.random() * topCard);
			Card temp = cards[i];
			cards[i] = cards[randomPos];
			cards[randomPos] = temp;
		}

	}

	@Override
	public String toString() {

		String result = "";

		if (topCard == DeckConstants.TOTAL_CARDS - 1) { // Prints in four columns if the Deck is full
			for (int i = 0; i < topCard / DeckConstants.NUM_OF_SUITS + 1; i++) {
				result = result + cards[i];
				for (int j = DeckConstants.RANK_PER_SUIT; j < topCard - 1; j += DeckConstants.RANK_PER_SUIT) {
					result = result + "\t" + cards[i + j];
				}

				result = result + "\n";
			}
		}

		else
			for (int i = 0; i < topCard; i++) { // else prints in one column
				result = result + cards[i] + "\n";

			}

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Deck) {
			Deck t1 = this;
			t1.selectionSort();
			Deck t2 = (Deck) o;
			t2.selectionSort();
			// Sorts the decks to be compared to ensure decks are equal even if not in the
			// same order
			return t1.toString().equals((t2).toString());
		} else
			return false;
	}

	/**
	 * A more strict .equals method that requires the cards be in the same order
	 * 
	 * @param o
	 *            the other Deck to be checked
	 * @return whether the two Decks are exactly the same
	 */
	public boolean exactEquals(Object o) {
		if (o instanceof Deck) {
			Deck t1 = this;
			Deck t2 = (Deck) o;
			return t1.toString().equals((t2).toString());
		} else
			return false;
	}

	/**
	 * Selects a Card from a random position in the deck and removes it, collapsing
	 * the Deck around the new empty space
	 * 
	 * @return the randomly chosen Card
	 */
	public Card pick() {
		return removeCard((int) (Math.random() * topCard));

	}

	/**
	 * A helper method which removes a Card from a given position and collapses the
	 * Deck around the new empty space, used in pick() and deal()
	 * 
	 * @param pos
	 *            the position of the card to be removed in the current deck
	 * @return the Card that has been removed
	 */
	private Card removeCard(int pos) {
		Card select = cards[pos];
		Card[] smallDeck = new Card[topCard--];
		for (int i = topCard; i > pos; i--) {
			smallDeck[i - 1] = cards[i];
		}
		for (int i = 0; i < pos; i++) {
			smallDeck[i] = cards[i];
		}
		cards = smallDeck;
		return select;
	}

	/**
	 * A method which deals cards from the top of the deck into a given number of
	 * hands
	 * 
	 * @param numHands
	 *            the number of hands to be dealt
	 * @param numPerHand
	 *            the number of cards per hand to be dealt
	 * @return an Array of Decks, each with a specific number of cards per hand
	 */
	public Deck[] deal(int numHands, int numPerHand) {
		Deck[] hands = new Deck[numHands];
		for (int i = 0; i < numHands; i++) {
			Deck temp = new Deck();
			temp.cards = new Card[numPerHand];
			temp.sorted = false;
			for (int j = 0; j < numPerHand; j++) {
				temp.cards[j] = this.removeCard(topCard);
			}
			hands[i] = temp;
			hands[i].topCard = temp.cards.length - 1;
		}

		return hands;
	}

	/********************************************************
	 * SELECTION SORT
	 ********************************************************/

	/**
	 * Sorts the array of Cards using the selectionSort algorithm
	 */
	public void selectionSort() {
		sorted = true;
		for (int n = topCard; n > 0; n--) {
			for (int i = 0; i < n; i++) {
				if (cards[i].compareTo(cards[n]) > 0) {
					Card aTemp = cards[i];
					cards[i] = cards[n];
					cards[n] = aTemp;
				}
			}

		}
	}

	/**************************************************
	 * MERGE SORT
	 **************************************************/
	/**
	 * Sorts the cards of a given Deck using the mergeSort algorithm
	 * 
	 */
	public void mergeSort() {
		Deck.sort(getCards());

	}

	// Sorts a[0], ..., a[a.length-1] in ascending order
	// using the Mergesort algorithm.
	private static void sort(Card[] a) {
		int n = a.length;
		temp = new Card[n];
		recursiveSort(a, 0, n - 1);
	}

	/**
	 * A method that combines the elements of an array back together into ascending
	 * order
	 * 
	 * @param c
	 *            the array of cards to be sorted
	 * @param start
	 *            the position of the first card to be sorted
	 * @param middle
	 *            the position of the middle of the array of cards
	 * @param end
	 *            the position of the last card
	 */

	private static void merge(Card[] c, int from, int middle, int to) {
		int i = from, j = middle + 1, k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to) {
			if (c[i].compareTo(c[j]) <= -1) {
				temp[k] = c[i]; // Or simply temp[k] = a[i++];
				i++;
			} else {
				temp[k] = c[j];
				j++;
			}
			k++;
		}

		// Copy the tail of the first half, if any, into temp:
		while (i <= middle) {
			temp[k] = c[i]; // Or simply temp[k++] = a[i++]
			i++;
			k++;
		}

		// Copy the tail of the second half, if any, into temp:
		while (j <= to) {
			temp[k] = c[j]; // Or simply temp[k++] = a[j++]
			j++;
			k++;
		}

		// Copy temp back into a
		for (k = from; k <= to; k++)
			c[k] = temp[k];
	}

	/**
	 * A recursive method which divides the array into smaller arrays until they are
	 * either 1 or 2 elements in length. These elements are swapped as appropriate
	 * and then merged back into the larger whole.
	 * 
	 * @param c
	 *            the array of cards to be sorted
	 * @param start
	 *            the position of the first card to be sorted
	 * @param end
	 *            the position of the last card to be sorted
	 */
	private static void recursiveSort(Card[] c, int from, int to) {
		if (to - from < 2) // Base case: 1 or 2 elements
		{
			if (to > from && c[to].compareTo(c[from]) <= -1) {
				// swap a[to] and a[from]
				Card aTemp = c[to];
				c[to] = c[from];
				c[from] = aTemp;
			}
		} else // Recursive case
		{
			int middle = (from + to) / 2;
			recursiveSort(c, from, middle);
			recursiveSort(c, middle + 1, to);
			merge(c, from, middle, to);
		}
	}

	/**
	 * Helper method used to check sorting
	 */
	public void arraySort() {
		Arrays.sort(cards);

	}
}
