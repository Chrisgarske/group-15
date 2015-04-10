import java.util.ArrayList;

public class Account {
	/**
	 * Eine Liste der Objekte (Amount) wird angelegt.
	 * 
	 */

	ArrayList<Amount> list = new ArrayList<Amount>();

	private String owner;
	private Currency currency;

	Amount konto = new Amount(0, currency);

	public Account(String owner, Currency currency) {
		this.owner = owner;
		this.currency = currency;
	}

	/**
	 * Betr�ge werden auf das Konto gebucht; Wenn der Betrag in Fremdw�hrung
	 * ist, wird er automatisch umgerechnet.
	 * 
	 * @param betrag
	 *            = eingegebener Betrag + die W�hrung
	 */

	public void post(Amount betrag) {
		if (!(this.currency.equals(betrag.getCurrency()))) {
			long ergebnis = betrag.getCurrency().convert(
					(betrag.toLong() / 100), this.currency);
			Amount neu = new Amount(ergebnis, this.currency);
			list.add(neu);
		} else {
			list.add(betrag);
		}

	}

	/**
	 * Die Summe (Saldo) aller Buchungen werden abgefragt.
	 * 
	 * @return
	 */
	public Amount total() {
		long summe = 0;
		for (Amount amount : list) {
			summe += amount.toLong() / 100;
		}

		return new Amount(summe, this.currency);
	}

	public Currency getCurrency() {
		return currency;
	}

	public String getOwner() {
		return owner;
	}

	/**
	 * Die Bank zieht einen gewissen Promillesatz an Geb�hren vom Konto ab.
	 * Damit ergibt sich die Geb�hr als das Produkt aus Saldo und Promillesatz.
	 * 
	 * @param promille
	 *            = der jeweilige Promillesatz
	 */
	public void accountFee(int promille) {

	}

	/**
	 * Der Kontoauszug wird als String ausgegeben.
	 */
	public String toString() {
		return "Kontoinhaber: " + owner + "W�hrung: " + currency + "--------"
				+ " " + " ";
	}
}
