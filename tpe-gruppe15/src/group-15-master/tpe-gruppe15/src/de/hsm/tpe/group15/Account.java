package de.hsm.tpe.group15;
/* 2015 Büsra Yildiz, Taib Demirci, Ilker Turan  */

/** 
 * Klasse, die Buchungen verwalten kann. Jedes Konto hat einen Inhaber (owner) und eine Währung(currency), auf die das Konto lautet.
 *<p>
 * Neue Instanzen werden mit Hilfe des Konstruktors erzeugt und initialisiert. 
 *<p>
 *Eine Liste der Beträge wird angelegt.
 *<p>
 * Die Klasse erlaubt es, positive wie negative Beträge auf das Konto zu buchen. 
 * Wenn der gebuchte Betrag in Fremdwährung ist, also von der Kontowährung abweicht, 
 * muss dieser Betrag automatisch umgerechnet werden.
 * <p>
 * Außerdem kann man die Summe aller Buchungen (Saldo) auf dem Konto abfragen.
 * <p>
 * Die Bank kann einen gewissen Promillesatz vom Konto abziehen.
 * <p>
 * Die Klasse erlaubt es, einen Auszug des Kontos zu bekommen.
 *
 * @author Büsra, Ilker, Taib
 */
import java.util.ArrayList;

public class Account implements Currencies {
	/** Eine Liste der Objekte (Beträge) wird angelegt. */
	ArrayList<Double> list = new ArrayList<Double>();
	/** Kontoinhaber wird angelegt */
	private String owner;
	/** Eine Währung wird angelegt, auf die das Konto lautet. */
	private Currency currency;

	/**
	 * Erzeugt einen neuen Kontoinhaber und die jeweilige Währung dessen.
	 * 
	 * @param owner
	 *            -Kontoinhaber * @param currency-Währung auf die das Konto
	 *            lautet.
	 * */
	public Account(String owner, Currency currency) {
		this.owner = owner;
		this.currency = currency;
	}

	/** @return gibt die Währung zurück */
	public Currency getCurrency() {
		return currency;
	}

	/** @return gibt den Kontoinhaber zurück */
	public String getOwner() {
		return owner;
	}

	/**
	 * Beträge werden auf das Konto gebucht. Ist der Betrag in Fremdwährung,
	 * wird er automatisch umgerechnet. Die Beträge werden an das Array "list"
	 * drangehängt.
	 * 
	 * @param betrag
	 *            -eingegebener Betrag, der auf das Konto gebucht werden soll +
	 *            die Währung
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

	/** @return Die Summe (Saldo) aller Buchungen werden zurückgegeben */
	public Amount total() {
		double summe = 0.0;
		for (Double stelle : list) {
			summe += stelle;
		}

		return new Amount(summe, getCurrency());
	}

	/**
	 * Die Bank zieht einen gewissen Promillesatz an Gebühren vom Konto ab.
	 * Damit ergibt sich die Gebühr als das Produkt aus Saldo und Promillesatz.
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
		return "Kontoinhaber: " + getOwner() + "\n" + "Währung: "
				+ getCurrency().getName() + "\n" + "---------- \n" + buchungen
				+ "---------- \n" + "Saldo: "
				+ String.format("%.2f", total().toDouble()) + " "
				+ getCurrency().getCode();
	}
}
