public class Currency implements Currencies {
	// Attribute
	private String name;
	private String code;
	private double exchangeRate;
	private boolean subunit;

	public Currency(String name, String code, double exchangeRate,
			boolean subunit) {
		this.name = name;
		this.code = code;
		this.exchangeRate = exchangeRate;
		this.subunit = subunit;
	}

	public long convert(long betrag, Currency toWaehrung) {
		/**
		 * zuerst wird der Betrag in Dollar umgerechnet, anschließend von Dollar
		 * in die Zielwährung
		 */
		return (long) ((betrag * getExchangeRate()) * toWaehrung.getExchangeRate());

	}

	public double getExchangeRate() {
		return this.exchangeRate;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public boolean hasSubunit() {
		return this.subunit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		long temp;
		temp = Double.doubleToLongBits(exchangeRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (subunit ? 1231 : 1237);
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
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(exchangeRate) != Double
				.doubleToLongBits(other.exchangeRate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subunit != other.subunit)
			return false;
		return true;
	}

	
	public String toString() {
		return name + "[" + code + "] 1 $ = " + exchangeRate + code;
	}
}
