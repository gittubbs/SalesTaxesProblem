package xpeppers.interview.shoppingbasket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;

import xpeppers.interview.strategy.Item;


/**
 * 
 * The Class ShoppingBasketListBD is based on two LinkedList - one for the Items and another for the 
 * quantities.
 * "BD" in the Class name means BigDecimal. Due to the necessary tax rounding, the algorithm uses this kind of data structure
 *  for keeping and operating on decimal numbers.
 */
public class ShoppingBasketListBD implements ShoppingBasketInterface {

	/** The Items list of this ShoppingBasket. */
	private LinkedList<Item> list = new LinkedList<>();
	
	/** Number of same Items. */
	private LinkedList<Integer> quantityList = new LinkedList<>();

	/** The rounding scale used by BigDecimal. Since we are representing money, 2 decimals will be fine. */
	int scale = 2;
	
	/* (non-Javadoc)
	 * @see xpeppers.interview.shoppingbasket.ShoppingBasketInterface#add(xpeppers.interview.strategy.Item, int)
	 */
	@Override
	public void add(Item i, int quantity) {
		list.add(i);
		quantityList.add(quantity);
	}

	/**
	 * Same as calling add with quantity = 1. 
	 *
	 * @param i - the item to add
	 */
	public void addOne(Item i) {
		add(i, 1);
	}
	
	/**
	 * Returns the size of the list containing the items. 
	 * @return the size of the list containing the items.
	 */
	public int howManyDifferentItems(){
		return list.size();
	}
	
	/* (non-Javadoc)
	 * @see xpeppers.interview.shoppingbasket.ShoppingBasketInterface#print()
	 */
	@Override
	public String print() {
		// maybe we can fill a capacity based on the list's weight. Maybe in v2.0 :P 
		StringBuilder sb = new StringBuilder();

		Iterator<Integer> it = quantityList.iterator();
		//How much of taxes are we paying?
		BigDecimal totalTaxes = new BigDecimal(0);
		//Grand total
		BigDecimal total = new BigDecimal(0);

		for (Item item : list) {
			int q = it.next();
			sb.append(q);
			sb.append(" " + item.getName());

			// Tax should be approximated, therefore we call the round function.
			BigDecimal currentTax = round(item.tax());
			totalTaxes = totalTaxes.add(currentTax);

			// Total should not be approximated. HALF_UP rounding mode has been set in order to
			// have two decimals exact arithmetics.
			BigDecimal partialTotal = new BigDecimal(item.getPrice()).add(currentTax).setScale(scale,
					RoundingMode.HALF_UP);
			BigDecimal currentTotal = partialTotal.multiply(new BigDecimal(q));

			total = total.add(currentTotal);

			sb.append(": " + (currentTotal.doubleValue()));
			//Calling lineSeparator increments portability of this software.
			sb.append(System.lineSeparator());
		}

		sb.append("Sales Taxes: ");
		sb.append(totalTaxes.doubleValue());
		sb.append(System.lineSeparator());
		sb.append("Total: ");
		sb.append(total.doubleValue());

		return sb.toString();
	}

	/**
	 * Rounds to the upper 0.05. Uses Math.ceil() function.
	 * 
	 * @param toRound the to round
	 * @return the big decimal
	 */
	private BigDecimal round(double toRound) {
		return new BigDecimal(Math.ceil(toRound * 20) / 20).setScale(scale, RoundingMode.HALF_UP);
		// .doubleValue();
	}

}
