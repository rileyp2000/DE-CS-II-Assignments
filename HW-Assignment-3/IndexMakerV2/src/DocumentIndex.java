
/**
 * <p>This is the index of the document</p>
 * @author Patrick Riley
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class DocumentIndex extends TreeMap<String, IndexEntry> {

	/**
	 * creates a DocumentIndex with a comparator
	 */
	public DocumentIndex() {
		super(new IndexEntryComparator());
	}

	/**
	 * This method adds the line number of a specific words to an Index Entry, and
	 * creates one if it doesn't exist already
	 * 
	 * @param word
	 *            word to find if inserted
	 * @param line
	 *            the line number that the word occurs on
	 * 
	 */
	public void addWord(String word, int line) {
		word = word.toUpperCase();
		if (this.containsKey(word))
			this.get(word).add(line);
		else
			this.put(word, new IndexEntry(word, line));

	}

	/**
	 * 
	 * @param str
	 *            a line of text
	 * @param num
	 *            the line number of the text
	 */
	public void addAllWords(String str, int num) {
		String[] words = str.split("\\W+");
		for (String s : words) {
			if (!s.equals(""))
				addWord(s, num);
		}
	}
	
	@Override
	public String toString() {
		String ret = "";
		Set<String> keyVal = keySet();
	    for (String entry : keyVal)
	      ret += get(entry) + "\n";
	    return ret;
	}
}
