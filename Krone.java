
package lab4;

public class Krone extends Currency {
	protected final String currencyName = "Krone";
	
	public Krone() {
		super();
	}
	
	// Potential problem if amt is negative.
	public Krone(double amt) throws Exception {
		super(amt);
	}
	
	// Gets currencyName ("Krone").
	// Pre: none.
	// Post: none.
	// Return: currencyName ("Krone").
	@Override
	public String getCurrencyName() {
		return currencyName;
	}

}
