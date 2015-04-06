public class Currency extends Currencies {
	// Attribute
	private String name;
	private String code;
	private double exchangeRate;
	private boolean subunit;

	@Immutable
	public Currency(String name, String code, double exchangeRate,
			boolean subunit) {
		this.name = name;
		this.code = code;
		this.exchangeRate = exchangeRate;
		this.subunit = subunit;
	}

	public double convert(long betrag, Currency toWaehrung) {

		return (betrag) / toWaehrung.exchangeRate;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public boolean hasSubunit() {
		return subunit;
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

	@Override
	public String toString() {
		return "Currency [name=" + name + ", code=" + code + ", exchangeRate="
				+ exchangeRate + ", subunit=" + subunit + "]";
	}
}
