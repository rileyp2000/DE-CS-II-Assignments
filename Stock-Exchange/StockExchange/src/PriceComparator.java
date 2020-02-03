import java.util.Comparator;

/**
 * <p></p> 
 * Nov 1, 2017
 * @author Patrick Riley
 */

/**
 * @author rileyp
 *
 */
public class PriceComparator implements Comparator<TradeOrder> {
 boolean ascend;
 
 public PriceComparator() {
	 ascend = true;
 }
 
 public PriceComparator(boolean a) {
	 ascend = a;
 }
 
 /**
  *0 if both orders are market orders;
  *-1 if order1 is market and order2 is limit;
  *1 if order1 is limit and order2 is market;
  *the difference in prices, rounded to the nearest cent, 
  *if both order1 and order2 are limit orders. In the latter 
  *case, the difference returned is cents1 - cents2 or 
  *cents2 - cents1, depending on whether this is an ascending
  *or descending comparator (ascending is true or false).
  *
  * @param t1 first order
  * @param t2 second order
  * @return
  *
  *int
  */
 public int compare(TradeOrder t1, TradeOrder t2) {
	 if(t1.isMarket() && t2.isMarket())
		 return 0;
	 if(t1.isMarket() && t2.isLimit())
		 return -1;
	 if(t1.isLimit() && t2.isMarket())
		 return 1;
	 if(ascend)
		 return (int)(100 * (t1.getPrice() - t2.getPrice()));
	 else
		 return (int)(100 * (t2.getPrice() - t1.getPrice()));
 }	
}
