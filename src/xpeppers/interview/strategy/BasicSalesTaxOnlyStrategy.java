package xpeppers.interview.strategy;


/**
 * 
 * The Class BasicSalesTaxOnlyStrategy represents the Strategy for calculating the Basic Sales tax rate only.
 */
public class BasicSalesTaxOnlyStrategy implements TaxStrategyInterface {
		
	/* (non-Javadoc)
	 * @see xpeppers.interview.strategy.TaxStrategyInterface#tax(double)
	 */
	@Override
	public double tax(double price) {
		
		return price * Rates.basicSalesTaxRate;
	}

}
