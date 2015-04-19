package de.hsm.tpe.group15;
/* 2015 B�sra Yildiz, Taib Demirci, Ilker Turan  */

/** 
 * Klasse, die Buchungen verwalten kann. Jedes Konto hat einen Inhaber (owner) und eine W�hrung(currency), auf die das Konto lautet.
 *<p>
 * Neue Instanzen werden mit Hilfe des Konstruktors erzeugt und initialisiert. 
 *<p>
 *Eine Liste der Betr�ge wird angelegt.
 *<p>
 * Die Klasse erlaubt es, positive wie negative Betr�ge auf das Konto zu buchen. 
 * Wenn der gebuchte Betrag in Fremdw�hrung ist, also von der Kontow�hrung abweicht, 
 * muss dieser Betrag automatisch umgerechnet werden.
 * <p>
 * Au�erdem kann man die Summe aller Buchungen (Saldo) auf dem Konto abfragen.
 * <p>
 * Die Bank kann einen gewissen Promillesatz vom Konto abziehen.
 * <p>
 * Die Klasse erlaubt es, einen Auszug des Kontos zu bekommen.
 *
 * @author B�sra, Ilker, Taib
 */
import java.util.ArrayList;

public class Account implements Currencies {
	/** Eine Liste der Objekte (Betr�ge) wird angelegt. */
	ArrayList<Double> list = new ArrayList<Double>();
	/** Kontoinhaber wird angelegt */
	private String owner;
	/** Eine W�hrung wird angelegt, auf die das Konto lautet. */
	private Currency currency;

	/**
	 * Erzeugt einen neuen Kontoinhaber und die jeweilige W�hrung dessen.
	 * 
	 * @param owner
	 *            -Kontoinhaber * @param currency-W�hrung auf die das Konto
	 *            lautet.
	 * */
	public Account(String owner, Currency currency) {
		this.owner = owner;
		this.currency = currency;
	}

	/** @return gibt die W�hrung zur�ck */
	public Currency getCurrency() {
		return currency;
	}

	/** @return gibt den Kontoinhaber zur�ck */
	public String getOwner() {
		return owner;
	}

	/**
	 * Betr�ge werden auf das Konto gebucht. Ist der Betrag in Fremdw�hrung,
	 * wird er automatisch umgerechnet. Die Betr�ge werden an das Array "list"
	 * drangeh�ngt.
	 * 
	 * @param betrag
	 *            -eingegebener Betrag, der auf das Konto gebucht werden soll +
	 *            die W�hrung
	 */
	public void post(Amount betrag) {
		if (!(this.currency.equals(betrag.getCurrency()))) {
			double ergebnis = betrag.getCurrency().convert((betrag.toLong()),
					this.currency);

			list.add(ergebnis);
		} else {
			list.add(betrag.toDouble());
		}
	}

	/** @return Die Summe (Saldo) aller Buchungen werden zur�ckgegeben */
	public Amount total() {
		double summe = 0.0;
		for (Double stelle : list) {
			summe += stelle;
		}

		return new Amount(summe, getCurrency());
	}

	/**
	 * Die Bank zieht einen gewissen Promillesatz an Geb�hren vom Konto ab.
	 * Damit ergibt sich die Geb�hr als das Produkt aus Saldo und Promillesatz.
	 * 
	 * @param promille
	 *            = der jeweilige Promillesatz
	 */
	public void accountFee(int promille) {
		double prozentSatz = promille;
		double gebuehr = (total().toDouble() * (prozentSatz / 1000));

		int letzteStelle = ((int) (gebuehr * 1000)) % 10;
		if (letzteStelle >= 5) {
			gebuehr = (Math.round(gebuehr * 1000) / 1000);
		} else {
			gebuehr = Math.floor(gebuehr * 100) / 100;
		}

		if (gebuehr > 0) {
			list.add(-(gebuehr));
		} else {
			list.add(gebuehr);
		}
	}

	/**
	 * Der Kontoauszug wird als String ausgegeben.
	 */
	public String toString() {
		String buchungen = "";
		for (Double stelle : list) {
			buchungen += String.format("%.2f", stelle) + " "
					+ getCurrency().getCode() + " \n";
		}
		return "Kontoinhaber: " + getOwner() + "\n" + "W�hrung: "
				+ getCurrency().getName() + "\n" + "---------- \n" + buchungen
				+ "---------- \n" + "Saldo: "
				+ String.format("%.2f", total().toDouble()) + " "
				+ getCurrency().getCode();
	}
}
