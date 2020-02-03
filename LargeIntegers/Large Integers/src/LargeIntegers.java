/**
 * <p>This program will add to large integers that are represented as arrays</p>
 * @author Patrick Riley
 */

/**
 * @author Patrick
 *	
 */
public class LargeIntegers{
	private static final int N = 30;

	
	/**
	 * 
	 * @param a array to add
	 * @param b array to add
	 * @return int[] of result of a+b
	 */
	public static int[] add(int[] a, int[] b){
		int[] result = new int[30];
		int carry = 0;
		
		int aVal = a[N-1];
		int bVal = b[N-1];
		
		for(int i = N-1; i >=0; i--){
			aVal = a[i];
			bVal = b[i];
			if(aVal + bVal + carry < 10){
				result[i] = aVal + bVal + carry;
				carry = 0;
			}
			else {
				result[i] = (aVal + bVal + carry)-10;
				carry = 1;
			}
		}
		return result;
	}


}
