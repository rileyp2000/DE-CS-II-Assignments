import java.util.Comparator;

/**
 * This class compares indexEntries based upon IndexEntry's .compareTo, which compares based on alphabetical order
 */

/**
 * @author Patrick
 *
 */
public class IndexEntryComparator implements Comparator<String>{
	
	boolean ascend;
	
	/**
	 * default constructor, sets ascending
	 */
	public IndexEntryComparator(){
		ascend = true;
	}
	
	/**
	 * creates comparator thats either descending or ascending
	 * @param a if ascending or descending
	 */
	public IndexEntryComparator(boolean a){
		ascend = a;
	}
	
	@Override
	public int compare(String i1, String i2) {
		return  i1.compareTo(i2);
	}

}
