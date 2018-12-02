
import java.util.Comparator;

/**
 * Used to compare two Card objects
 * 
 * @author Sean Gibbons
 *
 */
public class CardComparator implements Comparator<Card> {
	// describes the order the cards are to be sorted
	private boolean ascending;

	public CardComparator() {
		ascending = true;
	}

	@Override
	public int compare(Card o1, Card o2) {
		int difference;
		// First compares based on suit but if suits equal then compares based on rank

		if (o1.getSuitInt() - o2.getSuitInt() == 0)
			difference = o1.getRank() - o2.getRank();
		else
			difference = o1.getSuitInt() - o2.getSuitInt();
		if (ascending)
			return difference;
		else
			return -1 * difference;
	}

	/**
	 * An equals method to check if two Cards have the same rank
	 * 
	 * @param o1
	 *            the first Card to be compared
	 * @param o2
	 *            the second Card to be compared
	 * @return whether the Cards are equal
	 */
	public boolean equals(Card o1, Card o2) {
		return this.compare(o1, o2) == 0;
	}

	/**
	 * Sets the compare to sort Cards in forward order
	 */
	public void setAscending() {
		ascending = true;
	}

	/**
	 * Sets the compare to sort Cards in backwards order
	 */
	public void setDescending() {
		ascending = false;
	}

}
