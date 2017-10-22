package junit;
import static org.junit.Assert.*;

import org.junit.Test;

import xpeppers.interview.strategy.BasicSalesTaxOnlyStrategy;
import xpeppers.interview.strategy.ExemptTaxStrategy;
import xpeppers.interview.strategy.Item;

public class ItemTest {
	
	String name = "genericItem";
	double aPrice = 100;
	
	@Test
	public void testCreateItem() {
		
		Item genericItem = new Item (name, aPrice, new BasicSalesTaxOnlyStrategy());
		assertEquals(aPrice,genericItem.getPrice(),0);
		assertEquals(name,genericItem.getName());
	}
	
	
	@Test
	public void testHashCode(){
		//if two Items are the same, they have the same hashCode.
		
		Item item1 = new Item(name,aPrice,new BasicSalesTaxOnlyStrategy());
		Item item2 = new Item(name,aPrice,new BasicSalesTaxOnlyStrategy());
		
		assertEquals(item1.hashCode(),item2.hashCode());
		
		//Two items are the same even if they don't share the same Strategy.
		item2 = new Item(name,aPrice,new ExemptTaxStrategy());
		assertEquals(item1.hashCode(),item2.hashCode());
	}
	
	@Test
	public void testEquals(){
		Item item1 = new Item(name,aPrice,new BasicSalesTaxOnlyStrategy());
		Item item2 = new Item(name,aPrice,new BasicSalesTaxOnlyStrategy());
		
		assertTrue(item1.equals(item2));
		
		//reflexive property
		assertTrue(item2.equals(item1));
	
		//same item is the same!
		assertTrue(item1.equals(item1));
	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void priceLessThanZero() {
		double badPrice = -100;
		new Item (name, badPrice, new BasicSalesTaxOnlyStrategy());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nameIsEmpty(){
		new Item("",aPrice, new BasicSalesTaxOnlyStrategy());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nameIsNull(){
		new Item(null,aPrice, new BasicSalesTaxOnlyStrategy());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void strategyIsNull(){
		new Item(name,aPrice, null);
	}
	
	
}
