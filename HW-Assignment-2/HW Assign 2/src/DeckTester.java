import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * <p>This is a tester for the deck class</p> 
 * Oct 2, 2017
 * @author Patrick Riley
 */

/**
 * @author rileyp
 *
 */
public class DeckTester {

	/**
	 * @param args
	 *
	 *void
	 */
	public static void main(String[] args) {
		//NOTE: PLEASE RUN TESTS IN INDEPENDANT BLOCKS BECAUSE SOME TEST WILL IMPACT OTHER TESTS NEGATIVELY!!!!!
		File output = new File("output.txt");
		PrintWriter out = null;
		try {

			out = new PrintWriter(output);

		} catch (FileNotFoundException ex) {

			System.out.println("Cant open file: " + ex.getMessage() + " " + output);

		}
		
		
		Card c1 = new Card();
		out.println(c1);
		Card c2 = new Card(c1);
		out.println(c1.equals(c2));
		Card c3 = new Card(2,2);
		Card c4 = new Card("Ace", "Three");
		out.println(c3.compareTo(c4));
		Card c5 = new Card("ace", 5);
		Card c6 = new Card(1, "Jack");
		
		System.out.println();		
		
		Deck d1 = new Deck();
		out.println("Deck 1: \n" + d1 + "\n");
		Deck d3 = new Deck(d1);
		d1.shuffle();
		out.println(d1);
		Deck d2 = new Deck(false);
		out.println("Deck 2: \n" + d2 + "\n\n");
		Deck d4 = new Deck(d2);
		
		
		d1.shuffle();
		d1.selectionSort();
		RankComparator rc = new RankComparator();
		Arrays.sort(d3.getCards(),rc);
		out.println("Selection: \n" + d1);
		out.println(d1.equals(d3));
		
		
		
		d2.shuffle();
		d2.mergeSort();
		Arrays.sort(d4.getCards(),rc);
		out.println("Merge: \n" + d2);
		out.println("Are the decks equal after sort?" + d1.equals(d3));
		
		Deck[] hands = d1.deal(3, 5);
		hands[0].shuffle();
		for(Deck d: hands)
			out.println(d);
		
		
		try {
			Deck[] hand2 = d2.deal(5, 11);
			for(Deck d: hand2)
				out.println(d);
			}
		catch(NullPointerException ex){
			out.println("Tried to deal too many cards!");
		}
		
	
		
		out.println(d1.equals(d2));
		Card c7 = d1.pick();
		Card c8 = d2.pick();
		out.println(c1.compareTo(c2));
		
		out.close();
	}

}
