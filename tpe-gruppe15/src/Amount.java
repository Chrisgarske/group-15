public class Amount {

	private long amount;
	private Currency currency;
	
    public Amount(long amount, Currency currency) {
    	this.amount = amount;
    	this.currency = currency;
    }

    public Amount(double amount, Currency currency) {
    	this.amount =((long)(amount*100))*100;
    	this.currency = currency;
    }

    public Amount add(Amount other) {
    	currency.convert(amount, other.currency);
    	long amount = this.amount + other.amount;
    	return new Amount(amount, currency);
    }

    public Amount subtract(Amount other) {
    	currency.convert(amount, other.currency);
    	long amount = this.amount - other.amount;
    	return new Amount(amount, currency);
    }

    public Amount multiply(double factor) {
    	double betrag= this.amount*factor;
    	return new Amount(betrag, currency);
    }

    public Amount multiply(int factor) {
    	int betrag= (int) (this.amount*factor);
    	return new Amount(betrag, currency);
    }

    public Amount percentage(int percent) {
    	return new Amount(amount*percent/100, currency);
    }

 /*   public long toLong() {
    	return amount; 
    } */

    public int getSign() {
    	if (amount < 0) {
    		return -1;
    	} else {
    		return 1;
    	}
    		
    	
    }

  /*  public double toDouble() {
    	return amount.toDouble();
    }*/

    public Currency getCurrency() {
    	return this.currency;
    }

    public String toString() {
    	return "Amount " + amount + "Currency " + currency;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amount other = (Amount) obj;
		if (amount != other.amount)
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}
}