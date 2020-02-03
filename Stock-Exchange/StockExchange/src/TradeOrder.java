/**
 * <p></p> 
 * Oct 25, 2017
 * @author Patrick Riley
 */

public class TradeOrder {
	
	private Trader trader;
	private int numShares;
	private double price;
	private String symbol;
	private boolean buy, market;
	
	TradeOrder(Trader trade, String s, boolean buyOrder, boolean marketOrder, int shares, double p){
		trader = trade;
		symbol = s;
		price = p;
		buy = buyOrder;
		market = marketOrder;
		numShares = shares;		
	}

	/**
	 * @return the trader
	 */
	public Trader getTrader() {
		return trader;
	}



	/**
	 * @return the numShares
	 */
	public int getShares() {
		return numShares;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}



	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}


	/**
	 * @return the buy
	 */
	public boolean isBuy() {
		return buy;
	}
	
	/**
	 * @return the buy
	 */
	public boolean isSell() {
		return !buy;
	}
	
	/**
	 * @return the market
	 */
	public boolean isMarket() {
		return market;
	}

	/**
	 * @return the market
	 */
	public boolean isLimit() {
		return !market;
	}
	
	/**
	 * 
	 * @param shares a number of shares to be subtracted.
	 *
	 *void
	 */
	public void subtractShares(int shares) {
		if(shares > numShares)
			throw new IllegalArgumentException("shares > numShares!!");
		numShares -= shares;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TradeOrder Trader= " + trader + ", numShares= " + numShares + ", price= " + price + ", symbol= " + symbol
				+ ", Buy = true, Sell = false: Order is " + buy + ", Market = true, Limit = false: Order is " + market;
	}
	
	
}
