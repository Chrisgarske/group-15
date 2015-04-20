/* 2015 Büsra Yildiz, Taib Demirci, Ilker Turan  */

package de.hsm.tpe.group15;
/**
 * Klasse, die Informationen zu einer Währung verwalten kann.
 * <p>
 * Enthält den Namen der Währung, den Kürzel und Information, ob die Währung
 * eine Untereinheit hat oder nicht.
 * <p>
 * Die Daten gelangen über den Konstruktor in das Objekt und können danach nicht
 * mehr verändert werden, d.h. die Klasse ist immutable. Über die jeweiligen
 * get-Methoden können sie ausgelesen werden.
 * <p>
 * Klasse kann Beträge von einer Währung in eine andere umrechnen.
 * <p>
 * Klasse gibt Informationen zur Währung als String zurück.
 * <p>
 * 
 * @author Büsra, Ilker, Taib
 */
public class Currency implements Currencies {
	/** Name der Währung zB Euro, Rubel */
	private String name;
	/** Kürzel der Währung zB € oder RUB */
	private String code;
	/**
	 * Wechselkurs zum Dollar mit einer Genauigkeit von 4 Stellen hinter dem
	 * Komma
	 */
	private double exchangeRate;
	/** Information, ob eine Untereinheit existiert */
	private boolean subunit;

	/**
	 * Erzeugt eine Währung (Objekt), welche einen Namen, Kürzel und Wechselkurs
	 * zum Dollar hat und Information enthält, ob eine Untereinheit existiert.
	 * 
	 * @param name
	 *            - Name der Währung zB Euro, Rubel
	 * @param Kürzel
	 *            der Währung zB € oder RU
	 * @param exchangeRate
	 *            - Wechselkurs zum Dollar mit einer Genauigkeit von 4 Stellen
	 *            hinter dem Komma
	 * @param subunit
	 *            - Information, ob eine Untereinheit existiert
	 */
	public Currency(String name, String code, double exchangeRate,
			boolean subunit) {
		this.name = name;
		this.code = code;
		this.exchangeRate = exchangeRate;
		this.subunit = subunit;
	}

	/**
	 * Methode erlaubt es Beträge von einer Währung in die andere umzurechnen.
	 * Hierzu wird ein Betrag als long und eine Zielwährung als Parameter
	 * eingegeben. Um nicht den Wechselkurs zwischen allen Währungen zu
	 * speichern, werden die Beträge immer zuerst in Dollar umgerechnet und
	 * danach in die gewünschte Währung.
	 * 
	 * @param betrag
	 *            - der jeweilige Betarg, der umgerechnet werden soll
	 * @param toWaehrung
	 *            - die Zielwährung
	 * @return gibt den umegrechneten Betrag wieder als long zurück
	 */
	public long convert(long betrag, Currency toWaehrung) {
		double zahl = betrag;
		if (toWaehrung.equals(DOLLAR)) {
			if (exchangeRate > DOLLAR.exchangeRate) {
				return (long) (zahl /= getExchangeRate());
			} else {
				return (long) (zahl *= getExchangeRate());
			}
		} else {
			if (exchangeRate > DOLLAR.exchangeRate) {
				zahl /= exchangeRate;
				if (toWaehrung.exchangeRate > DOLLAR.exchangeRate) {
					return (long) (zahl *= toWaehrung.getExchangeRate());
				} else {
					return (long) (zahl /= toWaehrung.getExchangeRate());
				}
			} else {
				zahl *= exchangeRate;
				if (toWaehrung.exchangeRate > DOLLAR.exchangeRate) {
					return (long) (zahl *= toWaehrung.getExchangeRate());
				} else {
					return (long) (zahl /= toWaehrung.getExchangeRate());
				}
			}
		}

	}

	/** @return liefert den Wechselkurs der Währung als double zurück */
	public double getExchangeRate() {
		return this.exchangeRate;
	}

	/**
	 * @return liefert den Namen der Währung als String zurück
	 */
	public String getName() {
		return this.name;
	}

	/** @return liefert den Kürzel der Währung als String zurück */

	public String getCode() {
		return this.code;
	}

	/**
	 * @return true oder false, ob die Währung eine Untereinheit hat
	 */
	public boolean hasSubunit() {
		return this.subunit;
	}

	/** @see java.lang.Object#hashCode() */
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

	/*** @see java.lang.Object#equals(java.lang.Object) */
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

	/** *Gibt Informationen zur Währung als String zurück. */
	public String toString() {
		return name + "[" + code + "] 1 $ = " + exchangeRate + code;
	}
}
