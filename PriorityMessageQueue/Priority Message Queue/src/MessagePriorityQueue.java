import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author rileyp
 *
 */
public class MessagePriorityQueue {
	
	private ArrayList<LinkedList<Message>> priorities;
	private ArrayList<ArrayList<TimeData>> times;
	
	private final static int TOTAL_MESSAGES = 10000;
	
	private int[] totals;
	
	/**
	 * Instantiates the 5 queues of messages and the arraylists of the various times of each
	 */
	public MessagePriorityQueue() {
		priorities = new ArrayList<LinkedList<Message>>();
		times = new ArrayList<ArrayList<TimeData>>();
		
		for (int i = 0; i < 5; i++)
			priorities.add(new LinkedList<Message>());
		
		for (int i = 0; i < 5; i++)
			times.add(new ArrayList<TimeData>());
		totals = new int[5];
	}
	
	/**
	 * Places the message into the proper queue based on its priority
	 * @param m The message to be placed into a queue
	 */
	public void sort(Message m) {
		System.out.println(m);
		int pri = m.getPriority();
		priorities.get(pri).add(m);
		totals[pri] = totals[pri] + 1;
	}
	
	/**
	 * Removes the first message that has been waiting for more than 4 minutes
	 * @param cur The current time
	 */
	public void processMessages(int cur) {
		for (int i = 0; i < 5; i++) {
			if (priorities.get(i).peek() != null) {
				if (cur - priorities.get(i).peek().getArrival() >= 4) {
					Message m = priorities.get(i).remove();
					//System.out.println(m);
					
					//for analysis purposes
					times.get(m.getPriority()).add(new TimeData(cur,cur - m.getArrival()));
					return;
				}
			}
		}
	}
	
	/**
	 * Adds some values to the queues before the removal begins
	 * @return the time at which the loop stops iterating
	 */
	public int prefill() {
		int i = 0;
		for (i = 1; i <= 8; i++) {
			Message m = new Message(i);
			sort(m);
		}
		return i-1;
	}
	
	/**
	 * Removes any remaining values from the queues
	 * @param i the time at which to begin removing the messages
	 */
	public void removeRest(int i) {
		while (priorities.get(0).peek() != null || priorities.get(1).peek() != null || priorities.get(2).peek() != null
				|| priorities.get(3).peek() != null || priorities.get(4).peek() != null) {
			processMessages(i);
			i++;
		}

	}
	
	/**
	 * Analysis of the wait times for the various priorities
	 */
	public void analyzeWait() {
		for(int m = 0; m < 5; m++)
			System.out.println(totals[m]);
		System.out.println(times);
		int sum = 0;
		for (int queue = 0; queue < 5; queue++) {
			for (TimeData i : times.get(queue)) {
				sum += i.getWaitTime();
			}
			System.out.println("Message of Priority " + queue + " has average wait of :"
					+ ((sum + 0.0) / times.get(queue).size()) + " minutes");
			sum = 0;
		}
	}

	public static void main(String[] args) {
		MessagePriorityQueue sim = new MessagePriorityQueue();
		
		//adds values to the queues to begin
		int i = sim.prefill();
		
		//Starts adding and removing more values
		for (i = i + 1; i <= TOTAL_MESSAGES; i++) {
			Message m = new Message(i);
			sim.sort(m);
			sim.processMessages(i);
		}
		sim.removeRest(i);
		sim.analyzeWait();
		/*
		 * for(int i = 1; i < 101; i++){ System.out.println(new Message(i)); }
		 */

	}
}
