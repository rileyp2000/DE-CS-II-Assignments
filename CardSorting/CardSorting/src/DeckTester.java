import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DeckTester {

	public static void main(String[] args) {
		PrintWriter out = outputFile("output.txt");

		// Tests the three Deck constructors
		Deck d1 = new Deck();
		Deck d2 = new Deck(false);
		Deck d3 = new Deck(d2);
		out.println("Three Decks have been created, d1, d2, and d3");
		out.println("d1 should be sorted: ");
		out.println(d1);
		out.println("d2 should be random: ");
		out.println(d2);
		d3.arraySort();
		out.println("d3 has been sorted using Arrays.sort");
		out.println(d3);
		out.println();
		out.println();

		// Tests mergeSort
		out.println("Now testing mergeSort on d2");
		d2.mergeSort();
		out.println("d2 should now be sorted: ");
		out.println(d2);
		out.println("Is d2 the exact same as the deck sorted with Arrays.sort? " + d2.exactEquals(d3));

		out.println();
		out.println();

		// Tests selectionSort
		out.println("Now testing selectionSort on d1");
		d1.shuffle();
		out.println("d1 should now be random: ");
		out.println(d1);
		d1.selectionSort();
		out.println("d1 should now be sorted: ");
		out.println(d1);
		out.println("Is d1 the exact same as the deck sorted with Arrays.sort? " + d2.exactEquals(d3));

		out.println();
		out.println();

		// Tests pick
		out.println("Now testing pick on d1");
		out.println(d1.pick());
		out.println("Prints the remaining Cards in d1\n" + d1); // should be almost full as only 1 card has been removed

		for (int i = 0; i < DeckConstants.TOTAL_CARDS - 2; i++) {
			// Tests pick by removing and printing all the cards from d1
			out.println(d1.pick());
		}
		out.println("Prints the remaining Cards in d1\n" + d1); // should be empty as all cards have been removed

		out.println();
		out.println();

		// Tests deal
		out.println("Now testing deal on d1");
		d1.resetDeck();
		out.println("Resetting d1 and shuffling...");
		d1.shuffle();
		Deck[] warGame = d1.deal(2, 25);
		out.println("Now dealing two hands of 25 cards each");
		out.println(warGame[0]);
		out.println(warGame[1]);
		out.println("Here are the remaining cards in d1 ");
		out.println(d1);

		// Tests mergeSort and selectionSort on the smaller dealt hands
		out.println("Here is the first hand sorted using mergeSort");
		warGame[0].mergeSort();
		out.println(warGame[0]);

		out.println();
		out.println("Here is the second hand sorted using selectionSort");
		warGame[1].selectionSort();
		out.println(warGame[1]);

		// Tests equals
		out.println("Resetting d1");
		d1.resetDeck();
		out.println("Now testing .equals");
		out.println("Does d1 equal d2? " + d1.equals(d2));
		out.println("Do the two hands of 25 cards each equal each other? " + warGame[0].equals(warGame[1]));

		out.close();
	}

	/**
	 * Creates a file of the given name (used to create an output)
	 * 
	 * @param fName
	 *            The name of the file to be created
	 * @return A PrintWriter of the same name as fName which can be manipulated and
	 *         then saved
	 */
	public static PrintWriter outputFile(String fName) {
		File fileName = new File(fName);

		PrintWriter output = null;

		try {
			output = new PrintWriter(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Cannot open " + fName);
			return null;

		}

		return output;
	}
}
