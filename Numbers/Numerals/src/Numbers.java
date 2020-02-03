 /**
 * @user: rileyp
 * @date: Sep 6, 2017
 * @name: Numbers.java
 */

/**
 * @author Patrick Riley
 *
 */
import java.util.Scanner;
public class Numbers {

	/**
	 * @param: args
	 * @user: rileyp
	 * @date: Sep 6, 2017
	 * @method: main
	 */
	public static void main(String[] args) {
		//this adds a Scanner and then asks for 2 numbers
		Scanner kybd = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n1 = kybd.nextInt();
		System.out.println("Enter another number: ");
		int n2 = kybd.nextInt();
		System.out.printf("Braden added %d and %d and got %d\n", n1, n2, add(n1,n2));
		kybd.close();

	}
	
	/**
	 * 
	 * @param: n1
	 * @param: n2
	 * @return: sum of n1 and n2
	 * @user: rileyp
	 * @date: Sep 7, 2017
	 * @method: add
	 */
	public static int add(int n1, int n2) {
		return n1 + n2;
		
	}
	
	/**
	 * 
	 * @param: n1
	 * @param: n2
	 * @return: difference of n1 and n2
	 * @user: rileyp
	 * @date: Sep 8, 2017
	 * @method: difference
	 */
	public static int difference(int n1, int n2) {
		return n1-n2;
		
	}
	
	/**
	 * 
	 * @param: n1
	 * @param: n2
	 * @return: the product of n1 and n2
	 * @user: rileyp
	 * @date: Sep 8, 2017
	 * @method: product
	 */
	public static int product(int n1, int n2) {
		return n1*n2;
	}
	
	/**
	 * 
	 * @param: n1
	 * @param: n2
	 * @return: the quotient of n1 and n2
	 * @user: rileyp
	 * @date: Sep 8, 2017
	 * @method: quotient
	 */
	public static double quotient(int n1, int n2) {
		return (n1+.0)/n2;
	}
}
	
