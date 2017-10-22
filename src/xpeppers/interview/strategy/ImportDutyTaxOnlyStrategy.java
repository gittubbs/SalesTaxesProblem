package xpeppers.interview.strategy;


/**
 * 
 * The Class ImportDutyTaxOnlyStrategy represents the Strategy for calculating the import tax rate only.  
 */
public class ImportDutyTaxOnlyStrategy implements TaxStrategyInterface {

	/* (non-Javadoc)
	 * @see xpeppers.interview.strategy.TaxStrategyInterface#tax(double)
	 */
	@Override
	public double tax(double price) {
		return price * Rates.importDutyTaxRate;
	}

}
