package junit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import xpeppers.interview.input.json.JSONItemConverter;
import xpeppers.interview.strategy.BasicSalesTaxOnlyStrategy;
import xpeppers.interview.strategy.Item;
import xpeppers.interview.strategy.TaxStrategyHelper;

public class JSONTest {

	String name = "genericItem";
	double aPrice = 100;
	int quantity = 1;
	
	@Test
	public void testCreateItem() throws JSONException {
		//Creates a generic item
		Item genericItem = new Item (name, aPrice, new BasicSalesTaxOnlyStrategy());
		
		//Create this item as a JSON
		JSONObject json = new JSONObject();
		json.put("name", genericItem.getName());
		json.put("price", genericItem.getPrice());
		json.put("isExempt", false);
		json.put("isImported", false);
		json.put("quantity",quantity);
		
		//System.out.println(json);
		
		//Let's Retrieve the Item crafted by our JSON manager class
		Item toTest = JSONItemConverter.toItem(json);
		assertTrue(toTest.equals(genericItem));
		
		//Let's ask for the quantity
		assertEquals(quantity,JSONItemConverter.getQuantity(json));
	}
	
	@SuppressWarnings("unused")
	@Test(expected = JSONException.class)
	public void tryToCreateAnItemFromBadJSON () throws JSONException{
		JSONObject json = new JSONObject();
		//a JSON with only one attribute, an exception is thrown.
		json.put("name", "test");
		Item toTest = JSONItemConverter.toItem(json);
	}

	@SuppressWarnings("resource")
	@Test
	public void readAGoodJSONFromDisk() throws JSONException, IOException{
		String content = new Scanner(new File("test//aGoodJson")).next();
		JSONObject json = new JSONObject(content);
		Item genericItem = new Item (name, aPrice, TaxStrategyHelper.getStrategy(false, false));
		
		assertEquals(JSONItemConverter.toItem(json),genericItem);
	}
}
