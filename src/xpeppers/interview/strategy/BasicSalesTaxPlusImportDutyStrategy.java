package xpeppers.interview.strategy;


/**
 * 
 * The Class BasicSalesTaxPlusImportDutyStrategy represents the Strategy for calculating the tax rate for exempt items.
 */
public class BasicSalesTaxPlusImportDutyStrategy implements TaxStrategyInterface {

	/* (non-Javadoc)
	 * @see xpeppers.interview.strategy.TaxStrategyInterface#tax(double)
	 */
	@Override
	public double tax(double price) {
		return price * Rates.basicSalesTaxPlusImportDutyRate;
	}

}
