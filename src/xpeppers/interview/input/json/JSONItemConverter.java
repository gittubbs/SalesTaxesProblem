package xpeppers.interview.input.json;

import org.json.JSONException;
import org.json.JSONObject;

import xpeppers.interview.strategy.Item;
import xpeppers.interview.strategy.TaxStrategyHelper;

/**
 * @author Giulio Di Lieto
 * 
 * The Class JSONItemConverter provides some statics methods used to convert JSONs to Items.
 * 
 */
public final class JSONItemConverter {
	
	/**
	 * Private constructor.
	 */
	private JSONItemConverter(){ 
		//nothing to see here...
	}

	/**
	 * Tries to parse a well-formatted JSON to Item. In this version of SalesTaxesProblem, we assume that the
	 * JSON is well formatted and has "name", "price", "isExempt" and "isImported" fields.
	 *
	 * @param json - the JSON we want to convert to Item.
	 * @return the Item converted from the JSON.
	 * @throws JSONException if the JSON is not well-formatted or it doesn't have all the needed fields.
	 */
	public static Item toItem(JSONObject json) throws JSONException {
		return new Item(json.getString("name"),json.getDouble("price"),
				TaxStrategyHelper.getStrategy(json.getBoolean("isExempt"), 
						json.getBoolean("isImported")));
	}

	/**
	 * Useful for putting items in a shoppingbasket object, gets the value of "quantity" key in the JSON. 
	 *
	 * @param json - The JSON representing the Item.
	 * @return the value of "key" field.
	 * @throws JSONException if the JSON is not well-formatted or it doesn't have the "quantity" field.
	 */
	public static int getQuantity(JSONObject json) throws JSONException {
		return json.getInt("quantity");
	}
	
}
