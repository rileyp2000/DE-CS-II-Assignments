/**
 * <p></p> 
 * Oct 25, 2017
 * @author Patrick Riley
 */

import java.text.DecimalFormat;

public class SafeTradeTest {

	/**
	 * @param args
	 *
	 *void
	 */
	public static void main(String[] args) {
		Stock s = new Stock("MSFT", "Microsoft", 950.50);
		System.out.println(s);
		
		TradeOrder t = new TradeOrder(new Trader(null, "billyBob", "Windows12"), "MSFT", false, false, 100, 900);
		System.out.println(t);

	}

}
