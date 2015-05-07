package de.hsm.tpe.group15;
/* 2015 Büsra Yildiz, Taib Demirci, Ilker Turan  */

/** 
Klasse, die vorgefertigte Objekte von Währungen mit ihren dazugehörigen Wechselkursen enthält.
Diese kann man innerhalb des Programms wiederverwenden. Die Währungen sind jeweils mit Kurs zum Dollar vorgegeben.
<p>
* @author Büsra, Ilker, Taib
 */

public interface Currencies {

	/** US-Dollar */
	public static final Currency DOLLAR = new Currency("Dollar", "$", 1.0000,
			true);

	/** EURO */
	public static final Currency EURO = new Currency("Euro", "€", 1.2690, true);

	/** Japanischer Yen */
	public static final Currency YEN = new Currency("Yen", "¥", 0.0091, false);

	/** Rubel der russischen Föderation */
	public static final Currency RUBEL = new Currency("Rubel", "RUB", 0.0255,
			true);

	/** Schweizer Franken */
	public static final Currency CHF = new Currency("Franken", "CHF", 1.0509,
			true);
}
