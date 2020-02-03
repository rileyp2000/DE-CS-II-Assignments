/**
 * this represents a point in the grid of numbers
 * @author Patrick
 *
 */
public class Point {
	private int r,c,val;
	
	public Point(int row, int col, int value) {
		r = row;
		c = col;
		val = value;
	}
	
	public Point(Point p){
		r = p.getR();
		c = p.getC();
		val = p.getVal();
	}

	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * @return the c
	 */
	public int getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(int c) {
		this.c = c;
	}

	/**
	 * @return the val
	 */
	public int getVal() {
		return val;
	}
	
	@Override
	public boolean equals(Object o){
		return ((Point)o).getR() == r && ((Point)o).getC() == c && ((Point)o).getVal() == val; 
	}
	
	@Override
	public String toString(){
		return "" + val;
	}
}
