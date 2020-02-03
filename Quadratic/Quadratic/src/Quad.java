/**
 *
 *<p></p>
 *@author Patrick Riley
 *2017-09-08
 *
 */

/**
 * @author Patrick
 *
 */
public class Quad {
	private double a,b,c;
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public Quad(double aa,double bb, double cc){
		a = aa;
		b = bb;
		c = cc;
	}
	
	/**
	 * <p>This calculates the discriminant of a quadratic equation</p>
	 * @return double
	 */
	public  double discriminant(){
		return Math.pow(b,2) - 4*a*c;
	}
	
	/**
	 * <p>This will return an array that represents the number of real solutions</p>
	 * @return double[]
	 */
	public double[] root(){
		double[] sols;
		if(a == 0)
			throw new IllegalArgumentException("a == 0!");
		if(discriminant() < 0)
			return null;
		if(discriminant() >=0){
			sols = new double[] {1,1};
			return sols;
		}
		return null;
	}
}
