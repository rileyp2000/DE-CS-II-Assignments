/**
 * this class represents a disk on the production line with a given radius
 */

/**
 * THis class represents a disk that will become part of the production line
 * @author Patrick
 *
 */

public class Disk implements Comparable<Disk> {
	
	private int radius;
	
	/**
	 * Creates a disk with a radius
	 * @param r Radius of the disk to be created
	 */
	public Disk(int r) {
		if(r <= 0 )
			throw new IllegalArgumentException("Not a valid radius");
		radius = r;
	}
	
	/**
	 * Gets the radius of the disk
	 * @return The radius of the disk
	 */
	public int getRadius() {
		return radius;
	}
	
	@Override
	public int compareTo(Disk d2) {
		return radius - d2.getRadius();
	}
	
	@Override
	public String toString(){
		int num = this.getRadius();
		String ret = num + " ";
		while(num > 0) {
			ret += "X";
			num--;
		}
		
		return ret;
	}
}
