import java.util.ArrayList;

/**
 * <p></p>
 * @author Patrick Riley
 */

public class IndexEntry {
	
	private String word;
	private ArrayList<Integer> numsList;
	
	/**
	 * <p>Constructs a new IndexEntry object</p>
	 * @param wd word to add
	 */
	public IndexEntry(String wd){
		word = wd.toUpperCase();
		numsList = new ArrayList<Integer>();
	}
	
	/**
	 * 
	 * @return String word
	 */
	public String getWord() {
		return word;
	}
	
	public void add(int num){
		if(!numsList.contains(num))
			numsList.add(num);
	}

	@Override
	public String toString() {
		return "IndexEntry [word=" + word + ", numsList=" + numsList + "]";
	}
	
	
}
