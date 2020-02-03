import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <p>This represents a brokerage company and its traders</p> 
 * Oct 26, 2017
 * @author Patrick Riley
 */

/**
 * @author rileyp
 *
 */
public class Brokerage implements Login {

	private TreeMap<String, Trader> registeredTrader;
	private TreeSet<Trader> loggedInTraders;
	private StockExchange exchange;

	public Brokerage() {
		exchange = new StockExchange();
		registeredTrader = new TreeMap<String, Trader>();
		loggedInTraders = new TreeSet<Trader>();
	}

	public Brokerage(StockExchange e) {
		exchange = e;
		registeredTrader = new TreeMap<String, Trader>();
		loggedInTraders = new TreeSet<Trader>();
	}

	/**
	 * Tries to register a new user with a given screen name and password;
	 * 
	 * @param name
	 *            the screen name of the user.
	 * @param password
	 *            the password for the user.
	 * @return 0 if successful, or an error code (a negative integer) if failed:<br>
	 *         -1 -- invalid screen name (must be 4-10 chars)<br>
	 *         -2 -- invalid password (must be 2-10 chars)<br>
	 *         -3 -- the screen name is already taken.
	 */
	public int addUser(String name, String password) {
		int len = name.length();
		if (len < 4 || len > 10)
			return -1;
		len = password.length();
		if (len < 2 || len > 10)
			return -2;
		if (registeredTrader.containsKey(name))
			return -3;
		registeredTrader.put(name, new Trader(this, name, password));
		return 0;
	}

	/**
	 * Tries to login a user with a given screen name and password;
	 * 
	 * @param name
	 *            the screen name of the user.
	 * @param password
	 *            the password for the user.
	 * @return 0 if successful, or an error code (a negative integer) if failed:<br>
	 *         -1 -- screen name not found<br>
	 *         -2 -- invalid password<br>
	 *         -3 -- user is already logged in.
	 */
	public int login(String name, String password) {
		Trader t = registeredTrader.get(name);
		if (t == null)
			return -1;
		if (loggedInTraders.contains(t))
			return -3;
		String storedPassword = t.getPassword();
		if (!storedPassword.equals(password))
			return -2;
		else {
			t.openWindow();
			loggedInTraders.add(t);
			if(!t.hasMessages())
			t.receiveMessage("Welcome to Safe Trade");
			return 0;
		}

	}

	/**
	 * <p>
	 * Logs out the Trader
	 * </p>
	 * 
	 * @param t
	 *            Trader to be removed
	 *
	 *            void
	 */
	public void logout(Trader t) {
		if (loggedInTraders.contains(t))
			loggedInTraders.remove(t);
	}
	
	/**
	 * 
	 * @param symbol what stock to get a quote for
	 * @param trader what trader the symbol quote is taken from
	 *
	 *void
	 */
	public void getQuote(String symbol, Trader trader) {
		trader.receiveMessage(exchange.getQuote(symbol));
	}

	public void placeOrder(TradeOrder order) {
		exchange.placeOrder(order);
	}

}
