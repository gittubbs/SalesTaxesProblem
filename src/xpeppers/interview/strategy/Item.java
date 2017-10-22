package xpeppers.interview.strategy;

/**
 * 
 * The Class Item represents an Item. This class has been designed applying the Strategy Pattern.
 * For further informations, please refeer to the README.
 */
public class Item {
	
	/** Item's name. */
	private String name;
	
	/** Item's price. */
	private double price;
	
	/** The strategy to use in order to calculate the applied tax. */
	private final TaxStrategyInterface strategy;
	
	/**
	 * Instantiates a new item.
	 *
	 * @param name - The name. This parameter cannot be null nor empty.
	 * @param price - Item's price. This parameter cannot be negative.
	 * @param strategy - The strategy to use in order to calculate the applied tax.
	 */
	public Item (String name, double price, TaxStrategyInterface strategy){
		if (name == null || name.isEmpty()){
			throw new IllegalArgumentException("Name cannot be empty");
		}
		if(price < 0){
			throw new IllegalArgumentException("Price cannot be negative");
		}
		if(strategy == null){
			throw new IllegalArgumentException("Strategy shouldn't be null");
		}
		
		this.name = name;
		this.price = price;
		this.strategy = strategy;
	}
	
	
	/**
	 * Gets the name of the item.
	 *
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Gets the price of the item.
	 *
	 * @return the price
	 */
	public double getPrice(){
		return this.price;
	}
	
	/**
	 * Returns the tax rate for this item specified by a TaxStrategy.
	 *
	 * @return the tax rate for this item as a double.
	 */
	public double tax(){
		return this.strategy.tax(this.price);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Item))
			return false;
		if(o == this)
			return true;
		Item i = (Item) o;
		// Two items are the same if they've got the same name and the same price.
		return ( i.getName().compareTo(this.name) == 0 && i.getPrice() == this.price );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		int A_PRIME_NUMBER = 71;
		return (this.name.hashCode() * A_PRIME_NUMBER) + (int) this.price;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.name+": "+this.price;
	}
}
