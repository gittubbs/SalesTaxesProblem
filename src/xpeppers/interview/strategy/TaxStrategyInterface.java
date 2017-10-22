package xpeppers.interview.strategy;


/**
 * 
 * The Interface TaxStrategyInterface. It's used as abstraction for Strategy classes.
 */
public interface TaxStrategyInterface {

	/**
	 * Return the tax rate.
	 *
	 * @param price - The tax amount is calculated on this parameter.
	 * @return the tax amount as a double.
	 */
	double tax(double price);

}