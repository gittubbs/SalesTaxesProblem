package xpeppers.interview.shoppingbasket;
import xpeppers.interview.strategy.Item;


/**
 * 
 * The Interface ShoppingBasketInterface is used for representing a shopping basket.
 */
public interface ShoppingBasketInterface {
	
	/**
	 * Adds the Item "i" in the ShoppingBasket "quantity" times. 
	 *
	 * @param i - the Item to add in the shopping basket.
	 * @param quantity - the number of the same items you want to add to the shopping basket.
	 */
	public void add(Item i, int quantity);
	
	/**
	 * Returns the shopping basket formatted as a String.
	 *
	 * @return the shopping basket as a String.
	 */
	public String print();
	
}
