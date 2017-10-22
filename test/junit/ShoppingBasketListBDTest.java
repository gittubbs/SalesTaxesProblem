package junit;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import xpeppers.interview.shoppingbasket.ShoppingBasketListBD;
import xpeppers.interview.strategy.ExemptTaxStrategy;
import xpeppers.interview.strategy.Item;

public class ShoppingBasketListBDTest {
	@Test
	public void roundingTest() throws Exception, SecurityException {
		// This test uses Java Reflection. ShoppingBasket instance
		ShoppingBasketListBD s = new ShoppingBasketListBD();
		
		// I want to test the rounding method. It is called "round" in the ShoppingBasketListBD class.
		Method method = s.getClass().getDeclaredMethod("round", double.class);
		method.setAccessible(true);
		
		//Let's try some values 
		BigDecimal [] bdv = new BigDecimal [101];
		double offset = 1.00;
		BigDecimal currentCent = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP);
		
		bdv[0] = new BigDecimal(offset);
		for(int i = 1; i<bdv.length; i++){
			bdv[i] = new BigDecimal(offset + (i / 100D)).setScale(2,RoundingMode.HALF_UP);

			BigDecimal rounded = (BigDecimal) method.invoke(s, bdv[i].doubleValue());
			
			assertEquals(rounded.doubleValue(),currentCent.doubleValue(),offset);
			
			if(i % 5 == 0){
				currentCent = currentCent.add(new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP));
			}
		}
		
	}
	
	public void sizeTest(){
		ShoppingBasketListBD s = new ShoppingBasketListBD();
		Item a = new Item("test",1, new ExemptTaxStrategy());
		Item b = new Item("test2",2, new ExemptTaxStrategy());
		
		s.addOne(a);
		s.addOne(b);
		
		assertEquals(s.howManyDifferentItems(),2,0);
	}
		
}
