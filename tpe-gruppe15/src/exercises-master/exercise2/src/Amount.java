public class Amount implements Currencies {

	private long amount;
	private Currency currency;

	public Amount(long amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Amount(double amount, Currency currency) {
		this.amount = ((long) (amount * 100)) * 100;
		this.currency = currency;
	}

	public Amount add(Amount other) {
		long summe;
		if (this.currency.equals(other.currency)) {
			summe = this.amount + other.amount;
		} else {
			long ergebnis = currency.convert(amount, other.currency);
			summe = ergebnis + other.amount;
		}
		return new Amount(summe, other.currency);
	}

	public Amount subtract(Amount other) {
		long summe;
		if (this.currency.equals(other.currency)) {
			summe = this.amount - other.amount;
		} else {
			long ergebnis = currency.convert(amount, other.currency);
			summe = ergebnis - other.amount;
		}
		return new Amount(summe, other.currency);
	}

	public Amount multiply(double factor) {
		double betrag = this.amount;
		betrag *= factor;

		return new Amount(betrag, currency);
	}

	public Amount multiply(int factor) {
		long betrag = this.amount;
		betrag *= factor;
		return new Amount(betrag, currency);
	}

	public Amount percentage(int percent) {
		long betrag = this.amount;
		return new Amount(betrag * percent / 100, currency);
	}

	public long toLong() {
		double betrag = amount;
		betrag /= 10000;
		long endBetrag =(long) Math.floor(betrag * 100);
		return endBetrag;
	}

	public int getSign() {
		if (amount < 0) {
			return -1;
		} else {
			return 1;
		}

	}

	// yap beni recep
	public double toDouble() {
		double betrag = amount;
		betrag /= 10000;
		return (Math.floor(betrag * 100) / 100);
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public String toString() {

		if (currency.getName().equals(YEN.getName())) {
			return amount + " " + currency.getCode();
		} else if (amount < 1 && amount > -1) {
			double betrag = this.amount;
			betrag /= 10000;
			return String.format("%.2f", betrag) + " " + currency.getCode();
		} else {
			double betrag = this.amount;
			betrag /= 10000;
			return String.format("%.2f", betrag) + " " + currency.getCode();
		}
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