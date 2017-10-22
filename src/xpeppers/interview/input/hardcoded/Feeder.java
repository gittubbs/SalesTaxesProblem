package xpeppers.interview.input.hardcoded;

import xpeppers.interview.shoppingbasket.ShoppingBasketListBD;
import xpeppers.interview.strategy.BasicSalesTaxOnlyStrategy;
import xpeppers.interview.strategy.BasicSalesTaxPlusImportDutyStrategy;
import xpeppers.interview.strategy.ExemptTaxStrategy;
import xpeppers.interview.strategy.ImportDutyTaxOnlyStrategy;
import xpeppers.interview.strategy.Item;
import xpeppers.interview.strategy.TaxStrategyInterface;

public class Feeder {

	public static void main(String[] args) {
		
		TaxStrategyInterface [] str = new TaxStrategyInterface[4];
		str[0] = new ExemptTaxStrategy();
		str[1] = new BasicSalesTaxOnlyStrategy();
		str[2] = new ImportDutyTaxOnlyStrategy();
		str[3] = new BasicSalesTaxPlusImportDutyStrategy();
		
		// --- Initialise Shopping Basket, INPUT 1
		ShoppingBasketListBD shoppingbasket = new ShoppingBasketListBD();
	
		Item b = new Item("Book", 12.49, new ExemptTaxStrategy());
		Item m = new Item("Music CD", 14.99, new BasicSalesTaxOnlyStrategy());
		Item cb = new Item("Chocolate Bar", 0.85, new ExemptTaxStrategy());
		
		shoppingbasket.addOne(b); shoppingbasket.addOne(m); shoppingbasket.addOne(cb);
		System.out.println(shoppingbasket.print());
		
		// --- Initialise Shopping Basket, INPUT 2, using generic add instead off addOne.
		System.out.println();
		Item ibc = new Item("Imported box of chocolates", 10.00, new ImportDutyTaxOnlyStrategy());
		Item ibf = new Item("Imported bottle of perfume", 47.50, new BasicSalesTaxPlusImportDutyStrategy());
		shoppingbasket = new ShoppingBasketListBD();
		shoppingbasket.add(ibc, 1); shoppingbasket.add(ibf, 1);

		System.out.println(shoppingbasket.print());
		// --- Initialise Shopping Basket, INPUT 3, using generic add instead off addOne.
		shoppingbasket = new ShoppingBasketListBD();
		System.out.println();
		Item ibp = new Item("Imported bottle of perfume", 27.99, new BasicSalesTaxPlusImportDutyStrategy());
		Item bp = new Item("Bottle of perfume", 18.99, new BasicSalesTaxOnlyStrategy());
		Item hp = new Item("Package of headache pill", 9.75, new ExemptTaxStrategy());
		Item ibc2 = new Item("Box of imported box of c.", 11.25, new ImportDutyTaxOnlyStrategy());
		
		shoppingbasket.addOne(ibp);
		shoppingbasket.addOne(bp);
		shoppingbasket.addOne(hp);
		shoppingbasket.addOne(ibc2);
		
		System.out.println(shoppingbasket.print());
		
	}

}
