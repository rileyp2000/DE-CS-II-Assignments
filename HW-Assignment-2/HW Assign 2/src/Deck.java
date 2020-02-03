/**
 * <p>
 * This class represents a deck of cards
 * </p>
 * Sep 29, 2017
 * 
 * @author Patrick Riley
 */

public class Deck {
	private Card[] cards;
	private int topCard;
	private boolean sorted;

	private static final int NUMSUITS = (DeckConstants.getSUITS()).length;
	private static final int NUMCARDS = (DeckConstants.getRANKS()).length;
	private static final int TOTALCARDS = NUMSUITS * NUMCARDS;

	public Deck() {
		sorted = true;
		cards = createDeck();

	}
	
	/**
	 * 
	 * @param d another deck to be copied
	 */
	public Deck(Deck d) {
		sorted = d.sorted;
		Card[] card = d.getCards();
		cards = new Card[d.topCard + 1];
		for(int i = 0 ; i < cards.length; i ++)
			cards[i] = new Card(card[i]);
		topCard = d.topCard;
	}

	/**
	 * 
	 * @param s
	 *            if sorted or not
	 */
	public Deck(boolean s) {
		cards = createDeck();
		// shuffles the deck if it's not supposed to be sorted
		if (!sorted)
			shuffle();
		
		sorted = s;
	}

	/**
	 * 
	 * @param c
	 *            array of cards
	 */
	public void setCards(Card[] c) {
		cards = c;
	}

	/**
	 * 
	 * @param s
	 *            if sorted or not
	 */
	public void setSorted(boolean s) {
		sorted = s;
	}

	/**
	 * 
	 * @param top
	 *            sets the top card of the deck
	 */
	public void setTopCard(int top) {
		topCard = top;
	}

	/**
	 * 
	 * @return array of cards that represent a deck
	 */
	private Card[] createDeck() {
		// the new deck
		Card[] cards = new Card[TOTALCARDS];
		// the official suits and ranks
		String[] suits = DeckConstants.getSUITS();
		String[] ranks = DeckConstants.getRANKS();
		// tracks which card to add
		int cardCounter = 0;

		for (int i = 0; i < NUMSUITS; i++) {
			for (int j = 0; j < NUMCARDS; j++) {
				cards[cardCounter] = (new Card(suits[i], ranks[j]));
				cardCounter++;
			}
		}

		// sets the value of the topcard;
		setTopCard(cards.length - 1);

		return cards;

	}
	
	
	public Card[] getCards() {
		return cards;
	}

	/**
	 * <p>
	 * This shuffles the deck and EDITS THE ACTUAL ARRAY
	 * </p>
	 */
	public void shuffle() {
		// what to replace the unshuffled deck with
		Card[] replace = new Card[TOTALCARDS];

		// takes a random card from the original cards and then adds it to the shuffled
		// array
		for (int i = 0; i <= topCard; i++) {
			int rand = (int) (Math.random() * topCard);

			// makes sure doesnt shuffle a previously chosen card
			while (cards[rand] == null)
				rand = (int) (Math.random() * (topCard + 1));

			replace[i] = cards[rand];
			cards[rand] = null;

		}
		// sets the cards to shuffled array
		setCards(replace);
		// shows that deck is no longer sorted
		setSorted(false);

	}

	/**
	 * <p>
	 * Converts deck to String, represented differently based on type of Deck
	 * </p>
	 */
	public String toString() {
		String result = "";
		if (topCard == TOTALCARDS - 1) {
			for (int r = 0; r < NUMCARDS; r++) {
				for (int s = 0; s < NUMSUITS; s++)
					result += cards[NUMCARDS * s + r] + "\t";
				result += "\n";

			}
		} else {
			for (int i = 0; i <= topCard; i++)
				result += cards[i].toString() + "\n";
		}
		return result;

	}

	/**
	 * 
	 * @param d
	 *            A deck to compare to
	 * @return If the decks are equal
	 */
	public boolean equals(Deck d) {
		Deck d1 = new Deck(this);
		Deck d2 = new Deck(d);
		d1.mergeSort();
		d2.mergeSort();
		
		if (cards.length != d.cards.length)
			return false;

		for (int i = 0; i < TOTALCARDS; i++) {
			if (cards[i] != d.cards[i])
				return false;
		}

		return true;
	}

	/**
	 * 
	 * @param numHands
	 *            number of desired hands
	 * @param numCards
	 *            number of desired cards in each hand
	 * @return the hands represented as deck arrays
	 */
	public Deck[] deal(int numHands, int numCards) {
		Deck[] ret = new Deck[numHands];

		if (numHands * numCards <= topCard) {
			for (int i = 0; i < numHands; i++) {
				Card[] hand = new Card[numCards];
				ret[i] = new Deck();
				int indexControl = 0;
				for (int c = topCard; c > topCard - numCards; c--) {
					hand[indexControl] = cards[c];
					cards[c] = null;
					indexControl++;
				}
				setTopCard(topCard - numCards);
				ret[i].setCards(hand);
				ret[i].setTopCard(ret[i].cards.length - 1);
			}
			return ret;
		} else
			return null;

	}

	/**
	 * 
	 * @return a randomly picked card from the deck
	 */
	public Card pick() {
		int randCard = 0;

		do {
			randCard = (int) (Math.random() * topCard);
		} while (cards[randCard] == null);
		Card c = remove(randCard);
		this.setTopCard(topCard - 1 );
		return c;
	}
	
	/**
	 * 
	 * @param index the index to be removed
	 * @return the removed card
	 */
	public Card remove(int index){
		Card[] replace = new Card[cards.length - 1];
		
		for(int i = 0; i < index; i++)
			replace[i] = cards[i];
		
		Card ret = new Card(cards[index]);
		
		for(int i = index; i < cards.length-1; i++)
			replace[i] = cards[i+1];
		
		this.setCards(replace);
		return ret;
	}
	
	/**
	 * <p>
	 * Sorts the deck according to the selection sort algorithm. Taken from the
	 * Skylit website student files
	 * </p>
	 */
	public void selectionSort() {
		for (int n = topCard; n > 1; n--) {

			int max = 0;
			for (int i = 1; i < n; i++) {
				if (cards[i].compareTo(cards[max]) > 0)
					max = i;
			}

			Card temp = cards[max];
			cards[max] = cards[n - 1];
			cards[n - 1] = temp;
		}
	}

	/**
	 * <p>
	 * This is what is called to perform the mergeSort
	 * </p>
	 */
	public void mergeSort() {
		int n = topCard;
		Card[] temp = new Card[n+1];
		recursiveSort(cards, 0, n, temp);
	}

	/**
	 * <p>
	 * Recursive helper method: sorts cards[from], ..., cards[to]
	 * </p>
	 * 
	 * @param cards
	 *            the array of cards of the deck
	 * @param from
	 *            where to start sorting from
	 * @param to
	 *            where to end sorting to
	 * @param temp
	 *            a temporary place to store Cards
	 */
	private static void recursiveSort(Card[] cards, int from, int to, Card[] temp) {
		if (to - from < 2) { // Base case: 1 or 2 elements
			if (to > from && cards[to].compareTo(cards[from]) < 0) {
				// swap cards[to] and cards[from]
				Card aTemp = cards[to];
				cards[to] = cards[from];
				cards[from] = aTemp;
			}
		} else { // Recursive case
			int middle = (from + to) / 2;
			recursiveSort(cards, from, middle, temp);
			recursiveSort(cards, middle + 1, to, temp);
			merge(cards, from, middle, to, temp);
		}
	}

	
	/**
	 * <p>
	 * Merges cards[from] ... cards[middle] and cards[middle+1] ... cards[to] into
	 * one sorted array cards[from] ... cards[to]
	 * </p>
	 * 
	 * @param cards
	 *            the array of cards of the deck
	 * @param from
	 *            where to start merging from
	 * @param middle
	 *            middle of the array
	 * @param to
	 *            where to end merging
	 * @param temp
	 *            place to store temporary cards
	 */
	private static void merge(Card[] cards, int from, int middle, int to, Card[] temp) {
		int i = from;
		int j = middle + 1;
		int k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to) {
			if (cards[i].compareTo(cards[j]) < 0)
				temp[k] = cards[i++];
			else
				temp[k] = cards[j++];
			k++;
		}

		// Copy the tail of the first half, if any, into temp:
		while (i <= middle)
			temp[k++] = cards[i++];

		// Copy the tail of the second half, if any, into temp:
		while (j <= to)
			temp[k++] = cards[j++];

		// Copy temp back into cards
		for (k = from; k <= to; k++)
			cards[k] = temp[k];
	}

}
