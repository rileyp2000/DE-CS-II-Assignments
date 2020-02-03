import java.util.Stack;

/**
 * @author Patrick
 *
 */
@SuppressWarnings("serial")
public class Tower extends Stack<Disk> {
	
	/**
	 * Creates a tower that is a stack of disks
	 */
	public Tower() {
		super();
	}
	
	@Override
	public String toString() {
		String ret = "";
		while(!this.isEmpty()) {
			ret += this.pop();
			ret += "\n";
		}
		return ret;
	}

	
}
