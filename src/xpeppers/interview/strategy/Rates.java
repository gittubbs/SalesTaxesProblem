package xpeppers.interview.strategy;

/**
 * This class is used as a provider of rates for the tax strategies.
 * All the rates should be coded here instead of the Strategy classes. This approach adds a layer of independence.
 */
public final class Rates {
	
	/** The Constant basicSalesTaxRate . */
	public static final double basicSalesTaxRate = 0.1;
	
	/** The Constant importDutyTaxRate. */
	public static final double importDutyTaxRate = 0.05;
	
	/** The Constant exemptTaxRate. */
	//dummy variable, we don't like magic numbers
	public static final double exemptTaxRate = 0.0;
		
	/** The Constant basicSalesTaxPlusImportDutyRate. It's the sum of basicSalesTaxRat and importDutyTaxRate */
	public static final double basicSalesTaxPlusImportDutyRate = basicSalesTaxRate + importDutyTaxRate;
	
}
