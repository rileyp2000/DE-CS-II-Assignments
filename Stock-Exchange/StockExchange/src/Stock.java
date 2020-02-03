/**
 * <p></p> 
 * Oct 25, 2017
 * @author Patrick Riley
 */
import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * @author rileyp
 *
 */
public class Stock implements Comparable<Stock> {
	private String symbol, name;
	private int dayVolume;
	private double lowPrice, highPrice, lastPrice;
	private static DecimalFormat money = new DecimalFormat("$#,##0.00");
	
	private PriorityQueue<TradeOrder> buyOrders;
	private PriorityQueue<TradeOrder> sellOrders;
	
	public Stock(String s, String n, double p) {
		symbol = s;
		name = n; 
		lowPrice = p;
		highPrice = p;
		lastPrice = p;
		dayVolume = 0;
		sellOrders = new PriorityQueue<TradeOrder>(new PriceComparator());
		buyOrders = new PriorityQueue<TradeOrder>(new PriceComparator(false));
	}
	
	public String getQuote() {
		String qt = name + " (" + symbol + ")\n" + "Price: " + lastPrice + "\t" + "hi: "
				+ highPrice+ "\t" + "low: " + lowPrice + "\t" + "vol: " + dayVolume + "\n";
		qt += " Ask: ";
		if (!buyOrders.isEmpty()) {
			qt += buyOrders.peek().getPrice();
			qt += " size: " + buyOrders.peek().getShares();
		} else
			qt += "none ";

		qt += " Bid: ";
		if (!sellOrders.isEmpty()) {
			qt += sellOrders.peek().getPrice();
			qt += " size: " + sellOrders.peek().getShares();
		} else
			qt += "none ";
		return qt;
	}
	
	public void placeOrder(TradeOrder order) {
		String msg = "";
		
		if(order.isBuy()) {
			buyOrders.add(order);
			msg += "Buy: ";
		}
			else {
				sellOrders.add(order);
				msg += "Sell: ";
			}
		msg += symbol + " (" + name + ")\n " + order.getShares() + " at ";
		if(order.isLimit())
			msg += money.format(order.getPrice());
		else
			msg += "market";
		dayVolume += order.getShares();
		order.getTrader().receiveMessage(msg);
	}
	
	public int compareTo(Stock s) {
		return (int)Math.round(lastPrice - s.lastPrice);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stock symbol:" + symbol + ", name:" + name 
				+ ", initial price:" + money.format(lastPrice);
	}
	
	
}
