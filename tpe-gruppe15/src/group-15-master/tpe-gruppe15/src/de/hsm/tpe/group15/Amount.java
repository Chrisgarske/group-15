/* 2015 Büsra Yildiz, Taib Demirci, Ilker Turan  */
package de.hsm.tpe.group15;

/**
 * Klasse, die Beträge realisiert.
 * <p>
 * Die Objekte der Klasse sind immutable, d.h. nach Erzeugung können diese nicht
 * verändert werden. Die Methoden verändern den Zustand des Objektes nicht
 * sondern geben ein neues Objekt zurück.
 * <p>
 * Wenn ein Objekt angelegt wird, muss der Betrag und die Währung angegeben
 * werden. Der Betrag kann als double (max. zwei Nachkommastellen) oder long
 * angegeben werden. Aber er wird intern immer als long gespeichert.
 * <p>
 * Klasse kann feststellen, ob es sich um positive oder negative Beträge handelt
 * und kann diese verwalten.
 * <p>
 * Klasse enthält elementare Operationen, wie das Addieren/Subtrahieren zweier
 * Beträge, das Mutliplizieren eines Betrags mit einem double- bzw. int-Wert,
 * das Berechnen eines Prozentwertes von einem Betrag.
 * <p>
 * Klasse erlaubt das Auslesen als long/String/double.
 * <p>
 *
 * @author Büsra, Ilker, Taib
 */

public class Amount implements Currencies {
	/** Der Betrag */
	private long amount;
	/** Die dazugehörige Währung */
	private Currency currency;

	/**
	 * Erzeugt einen Betrag (long) mit der entsprechenden Währung.
	 * 
	 * @param amount
	 *            - Betrag in long
	 * @param currency
	 *            - die jeweilige Währung
	 */
	public Amount(long amount, Currency currency) {
		this.amount = (amount * 10000);
		this.currency = currency;
	}

	/**
	 * Erzeugt einen Betrag (double) mit der entsprechenden Währung.
	 * 
	 * @param amount
	 *            - Betrag in double
	 * @param currency
	 *            - die jeweilige Währung
	 */
	public Amount(double amount, Currency currency) {
		this.amount = ((long) (amount * 100)) * 100;
		this.currency = currency;
	}

	/** @return liefert die dazugehörige Währung des Betrags */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Addiert den gegebenen Betrag zu dieser und gibt das Ergebnis als neuen
	 * Betrag zurück.
	 *
	 * @param other
	 *            , der Betrag der zu dieser addiert werden soll
	 * @return das Ergebnis der Addition
	 */

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

	/**
	 * Subtrahiert den gegebenen Betrag zu dieser und gibt das Ergebnis als
	 * neuen Betrag zurück.
	 *
	 * @param other
	 *            der Betrag, der subtragiert wird
	 * @return das Ergebnis der Subtraktion
	 */

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

	/**
	 * Multipliziert diesen Betrag mit dem gegebenen double-Wert (factor) und
	 * gibt das Ergebnis als neuen Betrag zurück.
	 *
	 * @param factor
	 *            die Zahl, die mit dieser multipliziert werden soll
	 * @return das Ergebnis der Multiplikation mit der dazugehörigen Währung
	 */
	public Amount multiply(double factor) {
		double betrag = this.amount;
		betrag /= 10000;
		betrag *= factor;

		return new Amount(betrag, getCurrency());
	}

	/**
	 * Die Methode multipliziert diesen Betrag mit dem gegebenen int-Wert
	 * (factor) und gibt das Ergebnis als neuen Betrag zurück.
	 *
	 * @param factor
	 *            die Zahl, die mit dieser multipliziert werden soll
	 * @return das Ergebnis der Multiplikation mit der dazugehörigen Währung
	 */

	public Amount multiply(int factor) {
		long betrag = this.amount;
		betrag /= 10000;
		betrag *= factor;
		return new Amount(betrag, getCurrency());
	}

	/**
	 * Diese Methode berechnet einen Prozentwert von einem Betrag.
	 * 
	 * @return das Ergebnis, also der Prozentwert mit der dazugehörigen Währung
	 */
	public Amount percentage(int percent) {
		long betrag = this.amount;
		betrag /= 10000;
		return new Amount(betrag * percent / 100, getCurrency());
	}

	/**
	 * Der Wert wird als long ausgelesen, Vorzeichen wird nicht beachtet, es
	 * werden nur zwei Nachkommastellen ausgegeben.
	 * 
	 * @return der Betrag als long
	 */
	public long toLong() {
		double betrag = amount;
		betrag /= 100;

		long endBetrag = (long) (betrag);

		return endBetrag;
	}

	/**
	 * Die Methode stellt fest, ob es sich um einen positiven bzw. negativen
	 * Betrag handelt.
	 * 
	 * @return -1 wird ausgegeben, wenn der Betrag negativ ist.
	 * @return 1 wird ausgegeben, wenn der Betrag positiv ist.
	 */

	public int getSign() {
		if (amount < 0) {
			return -1;
		} else {
			return 1;
		}

	}

	/**
	 * Der Wert wird als double ausgelesen, wobei nur zwei Nachkommastellen im
	 * zurück gegebenen Wert vorhanden sind.
	 * 
	 * @return der Betrag als double
	 */

	public double toDouble() {
		double betrag = this.amount;
		betrag /= 100;

		return (Math.floor(betrag) / 100);
	}

	/** @see java.lang.Object#toString() */

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

	/** @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	/** @see java.lang.Object#equals(java.lang.Object) */
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
