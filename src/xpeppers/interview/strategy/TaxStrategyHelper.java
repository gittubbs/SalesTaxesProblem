package xpeppers.interview.strategy;

public final class TaxStrategyHelper {
	private TaxStrategyHelper(){};
	
	public static TaxStrategyInterface getStrategy(boolean isExempt, boolean isImported){
		if(isExempt && isImported){
			//An exempt item but imported, import duty tax only.
			return new ImportDutyTaxOnlyStrategy();
		}
		if(isExempt && !isImported){
			// An exempt and not imported item, no tax at all.
			return new ExemptTaxStrategy();
		}
		if(!isExempt && isImported){
			// a non-exempt and imported item, maximum tax, BST + import duty.
			return new BasicSalesTaxPlusImportDutyStrategy();
		}
		if(!isExempt && !isImported){
			// a non-exempt and local (not imported) item, BST only.
			return new BasicSalesTaxOnlyStrategy();
		}
		return null; //unreachable!
	}
}
