
import java.util.TreeSet;

/**
 * <p>this class represents an entry in the index with its word and its line numbers
 * </p>
 * 
 * @author Patrick Riley
 */

public class IndexEntry implements Comparable<IndexEntry> {

	private String word;
	private TreeSet<Integer> lineNums;

	/**
	 * <p>
	 * Constructs a new IndexEntry object
	 * </p>
	 * 
	 * @param wd
	 *            word to add
	 */
	public IndexEntry(String wd) {
		word = wd.toUpperCase();
		lineNums = new TreeSet<Integer>();
	}
	
	/**
	 * copy constructor for an IndexEntry
	 * @param e Index entry to be copied
	 */
	public IndexEntry(IndexEntry e) {
		word = e.getWord();
		lineNums = new TreeSet<Integer>(e.getLines());
	}
	
	/**
	 * creates an indexEntry with a line number
	 * @param wd word for the entry
	 * @param num line number for the entry
	 */
	public IndexEntry(String wd, int num) {
		word = wd.toUpperCase();
		lineNums = new TreeSet<Integer>();
		if (!lineNums.contains(num))
			lineNums.add(num);
	}

	/**
	 * 
	 * @return String word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Gets the TreeSet of lines
	 * @return TreeSet the set of line numbers
	 */
	public TreeSet<Integer> getLines() {
		return lineNums;
	}

	/**
	 * 
	 * @param num
	 *            the line number to add to the IndexEntry
	 */
	public void add(int num) {
		if (!lineNums.contains(num))
			lineNums.add(num);
	}

	@Override
	public int compareTo(IndexEntry i) {
		return word.toUpperCase().compareTo(i.getWord().toUpperCase());
	}

	@Override
	public String toString() {
		return word + " " + lineNums.toString().substring(1, lineNums.toString().length()-1 );
	}

}
