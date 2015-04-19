package de.hsm.tpe.group15;
public class Amount implements Currencies {

	private long amount;
	private Currency currency;

	public Amount(long amount, Currency currency) {
		this.amount = (amount * 10000);
		this.currency = currency;
	}

	public Amount(double amount, Currency currency) {
		this.amount = ((long) (amount * 100)) * 100;
		this.currency = currency;
	}

	public Currency getCurrency() {

		return currency;
	}

	public Amount add(Amount other) {
		long summe = 0;
		if (currency.equals(other.currency)) {
			summe = toLong() + other.toLong();
		} else {
			double ergebnis = other.currency.convert(other.toLong(), currency);
			summe = (long) (toLong() + ergebnis);
		}

		return new Amount(summe, getCurrency());
	}

	public Amount subtract(Amount other) {
		long summe = 0;
		if (currency.equals(other.currency)) {
			summe = toLong() - other.toLong();
		} else {
			double ergebnis = other.currency.convert(other.toLong(), currency);

			summe = (long) (toLong() - ergebnis);
		}

		return new Amount(summe, getCurrency());
	}

	public Amount multiply(double factor) {
		double betrag = this.amount;
		betrag /= 10000;
		betrag *= factor;

		return new Amount(betrag, getCurrency());
	}

	public Amount multiply(int factor) {
		long betrag = this.amount;
		betrag /= 10000;
		betrag *= factor;
		return new Amount(betrag, getCurrency());
	}

	public Amount percentage(int percent) {
		long betrag = this.amount;
		betrag /= 10000;
		return new Amount(betrag * percent / 100, getCurrency());
	}

	public long toLong() {
		double betrag = amount;
		betrag /= 100;

		long endBetrag = (long) (betrag);

		return endBetrag;
	}

	public int getSign() {
		if (amount < 0) {
			return -1;
		} else {
			return 1;
		}

	}

	public double toDouble() {
		double betrag = this.amount;
		betrag /= 100;

		return (Math.floor(betrag) / 100);
	}

	public String toString() {

		if (currency.getName().equals(YEN.getName())) {
			long betrag = amount;
			betrag /= 10000;
			return betrag + " " + getCurrency().getCode();

		} else if (amount < 1 && amount > -1) {
			double betrag = this.amount;
			betrag /= 10000;
			return String.format("%.2f", betrag) + " "
					+ getCurrency().getCode();
		} else {
			double betrag = this.amount;
			betrag /= 10000;
			return String.format("%.2f", betrag) + " "
					+ getCurrency().getCode();
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