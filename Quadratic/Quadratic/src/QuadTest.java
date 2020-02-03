/**
 *
 *<p></p>
 *@author Patrick Riley
 *2017-09-10
 *
 */

/**
 * @author Patrick
 *
 */
public class QuadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quad quad1 = new Quad(1,5,1);
		Quad quad2 = new Quad(5,1,5);
		quad1.discriminant();
		   
		   //this should return 0
		      System.out.println("Num of Sols: " + quad1.root().length);
		   
		   //this should print null
		      System.out.println("Num of Sols: " + quad2.root()); //+"\nSolutions: " + (QuadRoot.roots(1,5,1))[0] + "   " + (QuadRoot.roots(1,5,1))[1]);
		   
		   //should throw an exception(REMOVE FORWARD SLASHES ON NEXT LINE TO TEST)
		   //   System.out.println("Num of Sols: " + (QuadRoot.roots(0,5,1) ).length);
		

	}

}
