import java.util.Random;

/**
 * This represents a message in the queue
 * @author rileyp
 *
 */
public class Message implements Comparable{
	private int priority, arrival;
	private static final Random R = new Random(651465733);
	
	/**
	 * This Creates a new message with a given arrival time
	 * @param a arrival time of the message
	 */
	public Message(int a) {
		priority = R.nextInt(5);
		arrival = a;
	}
	
	/**
	 * Gets the arrival time of the message
	 * @return Arrival time of the Message
	 */
	public int getArrival() {
		return arrival;
	}
	
	/**
	 * Gets the priority of the message
	 * @return The priority of the message
	 */
	public int getPriority() {
		return priority;
	}
	
	@Override
	public String toString(){
		return "Message of priority " + priority + ", Arrived at " + arrival;
	}
	
	@Override
	public int compareTo(Object m) {
		return priority - ((Message) m).getPriority();
	}
}
