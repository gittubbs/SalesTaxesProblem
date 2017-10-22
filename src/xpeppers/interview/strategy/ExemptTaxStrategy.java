package xpeppers.interview.strategy;

/**
 * 
 * The Class ExemptTaxStrategy represents the Strategy for calculating the exempt tax rate.
 */
public class ExemptTaxStrategy implements TaxStrategyInterface {

	/* (non-Javadoc)
	 * @see xpeppers.interview.strategy.TaxStrategyInterface#tax(double)
	 */
	@Override
	public double tax(double price) {
		return price * Rates.exemptTaxRate;
	}

}
