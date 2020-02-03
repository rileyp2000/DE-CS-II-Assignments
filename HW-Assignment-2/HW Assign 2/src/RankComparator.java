import java.util.Comparator;

/**
 * <p>
 * This is a rank comparator
 * </p>
 * 
 * @author rileyp
 *
 */
public class RankComparator implements Comparator<Card> {

	private boolean ascending;

	public RankComparator() {
		ascending = true;
	}

	/**
	 * 
	 * @param a
	 *            if order is ascending or not
	 */
	public RankComparator(boolean a) {
		ascending = a;
	}

	/**
	 * @return if cards are equal based on suit and rank
	 * @param comp
	 *            a card
	 * @param other
	 *            another card
	 */
	public boolean equals(Card comp, Card other) {
		if (other != null)
			return comp.getSuit().equals(other.getSuit()) && comp.getRankStr().equals(other.getRankStr());
		else
			return false;
	}

	/**
	 * @param c1
	 *            A card
	 * @param c2
	 *            another card
	 * 
	 * @return c1's rank - c2's rank
	 */
	@Override
	public int compare(Card c1, Card c2) {

		if (c1.getSuitInt() != c2.getSuitInt())
			if (ascending)
				return DeckConstants.getRANKS().length * (c1.getSuitInt() - c2.getSuitInt());
			else
				return -1 * (DeckConstants.getRANKS().length * (c1.getSuitInt() - c2.getSuitInt()));
		
		else if (c1.getRank() != c2.getRank())
			if (ascending)
				return c1.getRank() - c2.getRank();
			else
				return -1 * (c1.getRank() - c2.getRank());
		else
			return 0;
		
		/*
		 * if (ascending) return c1.getRank() - c2.getRank(); else return -1 *
		 * (c1.getRank() - c2.getRank());
		 */
	}

}
