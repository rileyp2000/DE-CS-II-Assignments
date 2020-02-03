import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author rileyp
 *
 */
@SuppressWarnings("serial")
public class TTT_HC extends Board {

	// private ArrayList<Object> winners;
	Object[] winners;
	private final int ARRAYSIZE = 431;

	public TTT_HC(String title) {
		super(title);
		winners = new Object[ARRAYSIZE];
		fillWinners();
	}

	@SuppressWarnings("unchecked")
	private void fillWinners() {
		String fn = "TicTacToeWinners.txt";

		Scanner file = fileToScanner(fn);

		while (file.hasNextLine()) {
			String board = file.nextLine();
			super.setBoardString(board);
			try {
				winners[myHashCode()].toString();
			} catch (NullPointerException | IndexOutOfBoundsException ex) {
				winners[myHashCode()] = new BooleanData(board);
				continue;
			}

			if (winners[myHashCode()] instanceof BooleanData) {
				ArrayList<BooleanData> arr = new ArrayList<BooleanData>();
				arr.add((BooleanData) winners[myHashCode()]);
				arr.add(new BooleanData(board));
				winners[myHashCode()] = arr;
			} else
				((ArrayList<BooleanData>) winners[myHashCode()]).add(new BooleanData(board));
		}

	}

	private static Scanner fileToScanner(String s) {
		File f = new File(s);
		Scanner ret = null;

		try {
			ret = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("No File!!");
			System.exit(1);
		}

		return ret;
	}

	@Override
	int myHashCode() {
		int total = 0;
		int curChar = 0;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				char item = super.charAt(r, c);
				switch (item) {
				case 'x':
					curChar = 11;
					break;
				case 'o':
					curChar = 7;
					break;
				default:
					curChar = 5;

				}
				total += curChar * (Math.pow((r + 1), 2) * (c + 1));
			}
		}
		return total - 430;
	}

	@Override
	boolean isWin(String s) {
		return false;
	}

	@Override
	boolean isWin() {
		return false;
	}

	@SuppressWarnings("unchecked")
	public void printStats() {
		int total = 0;
		int numBuckets = 0;
		int numAlone = 0;
		int maxSize = 0;
		int finalVal = 0;
		double avgBucket = 0;
		for (int i = 0; i < winners.length; i++) {
			if (winners[i] != null) {
				total++;
				finalVal = i;
				if (winners[i] instanceof ArrayList<?>) {
					// System.out.println("ArrayList " +
					// ((ArrayList<BooleanData>) winners[i]).size());
					numBuckets++;
					avgBucket += ((ArrayList<BooleanData>) winners[i]).size();
					if (((ArrayList<BooleanData>) winners[i]).size() > maxSize)
						maxSize = ((ArrayList<BooleanData>) winners[i]).size();
				} else {
					// System.out.println("BooleanData");
					numAlone++;
				}
			}
		}
		avgBucket /= numBuckets;
		System.out.println("Total: " + total + "\nNumber Buckets: " + numBuckets + " \nNumber Single Entries: "
				+ numAlone + " \nMax Bucket Size: " + maxSize + " \nLast stored value index: " + finalVal
				+ " \nAverage bucket size: " + avgBucket);
	}

	public void printDistro() {
		int fourths = (winners.length - 1) / 4;
		int tenths = (winners.length - 1) / 10;

		int total = 0;
		for (int q = 0; q < 4; q++) {
			for (int i = q * fourths + 1; i < (q + 1) * fourths; i++) {
				if (winners[i] != null)
					total++;
			}
			System.out.println("Q" + (q + 1) + ": " + total);
			total = 0;
		}

		total = 0;

		for (int q = 0; q < 10; q++) {
			for (int i = q * tenths + 1; i < (q + 1) * tenths; i++) {
				if (winners[i] != null)
					total++;
			}
			System.out.println("P" + (q + 1) + ": " + total);
			total = 0;
		}
	}

	public static void main(String[] args) {
		TTT_HC test = new TTT_HC("title");
		test.printStats();
		test.printDistro();

	}
}
