/**
 * <p>This class represents a quadratic function</p> 
 * Sep 15, 2017
 * @author Patrick Riley
 */

/**
 * @author rileyp
 *
 */
public class QuadraticFunction implements Comparable<QuadraticFunction> {
	private int a, b, c;

	public QuadraticFunction(int aa, int bb, int cc) {
		a = aa;
		b = bb;
		c = cc;
	}

	// GETTERS AND SETTERS

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public int getC() {
		return c;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(int c) {
		this.c = c;
	}

	// <METHODS

	/**
	 * 
	 * @param x
	 * @return double value of function at x
	 *
	 */
	public double valueAt(double x) {
		return a * Math.pow(x, 2) + b * x + c;
	}

	/**
	 * @param other
	 *            the Other object
	 * @return if equal coefficients
	 */
	public boolean equals(Object other) {
		if (a == ((QuadraticFunction) other).getA() && b == ((QuadraticFunction) other).getB()
				&& c == ((QuadraticFunction) other).getC())
			return true;
		else
			return false;

	}

	/**
	 * 
	 * @param other
	 * @return int
	 *
	 */
	public int compareTo(QuadraticFunction other) {
		if (a - other.getA() != 0)
			return a - other.getA();
		else if (b - other.getB() != 0)
			return a - other.getB();
		else
			return c - other.getC();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return a + "x^2" + "+" + b + "x" + c;
	}

}
