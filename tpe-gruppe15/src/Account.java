public class Account {
	
	private String owner;
	private Currency currency;

	Amount konto = new Amount(0, currency);

    public Account(String owner, Currency currency) {
    	this.owner = owner;
    	this.currency = currency;
    }

    public void post(Amount betrag) {
   
    	if(!betrag.getCurrency().equals(this.currency)){
    		Amount ergebnis = new Amount (betrag.getCurrency().convert(betrag.toLong(), this.currency), this.currency);
    		this.konto.add(ergebnis);
    	}
    	this.konto.add(betrag);
    }

    public Amount total() {
    	return konto;
    }

    public Currency getCurrency() {
    	return currency;
    }

    public String getOwner() {
    	return owner;
    }

    public void accountFee(int promille) {
    }

    public String toString() {
    }
}
