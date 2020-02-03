import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author rileyp
 *
 */
public class Trader implements Comparable<Trader> {
	private Brokerage brokerage;
	private String username, password;
	private Queue<String> mailbox;
	private TraderWindow myWindow;

	public Trader(Brokerage b, String un, String pwd) {
		brokerage = b;
		username = un;
		password = pwd;
		mailbox = new LinkedList<String>();
	}

	/**
	 * @return the username
	 */
	public String getName() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @return if has any messages
	 *
	 *boolean
	 */
	public boolean hasMessages() {
		return mailbox.size() != 0;

	}
	
	/**
	 * Creates a new TraderWindow for this trader and saves a reference to it in myWindow. 
	 * Removes and displays all the messages, if any, from this trader's mailbox by calling myWindow.show(msg) for each message.
	 *
	 *void
	 */
	public void openWindow() {
		myWindow = new TraderWindow(this);
		for (int i = mailbox.size()-1; i >= 0; i--)
			myWindow.showMessage(mailbox.remove());
	}
	
	
	
	/**
	 * Adds msg to this trader's mailbox and displays all messages. If this trader is logged in 
	 * (myWindow is not null) removes and shows all the messages in the mailbox by calling myWindow.showMessage(msg) 
	 * for each msg in the mailbox.
	 * @param msg a message to be added to this trader's mailbox
	 *
	 *void
	 */
	public void receiveMessage(String msg) {
		mailbox.add(msg);
		if (myWindow != null) {
			for (int i = mailbox.size()-1; i >= 0; i--)
				myWindow.showMessage(mailbox.remove());
		}
	}
	
	/**
	 * 
	 * @param symbol gets a quote for a symbol
	 *
	 *void
	 */
	public void getQuote(String symbol) {
		brokerage.getQuote(symbol, this);
	}
	
	/**
	 * logs out a user
	 * 
	 *
	 *void
	 */
	public void quit() {
		brokerage.logout(this);
	}
	
	/**
	 * places an order
	 * @param order order to be placed
	 *
	 *void
	 */
	public void placeOrder(TradeOrder order) {
		brokerage.placeOrder(order);
	}

	@Override
	public int compareTo(Trader other) {
		String n1 = this.getName().toLowerCase();
		String n2 = other.getName().toLowerCase();
		return n1.compareTo(n2);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Trader)
			return compareTo(((Trader) other)) == 0;
		else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trader Brokerage: " + brokerage + ", Username: " + username;
	}

}
