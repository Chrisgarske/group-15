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