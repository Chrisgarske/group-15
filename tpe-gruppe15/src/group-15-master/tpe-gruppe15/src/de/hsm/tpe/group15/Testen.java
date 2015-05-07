package de.hsm.tpe.group15;
import static org.junit.Assert.*;

import org.junit.*;

public class Testen implements Currencies {

	@Test
	public void testConvert() {
		long betrag1 = 19917;
		long betrag2 = 230;
		long betrag3 = 362;
		long betrag4 = 253;
		long betrag5 = 21978;

		assertEquals(betrag1, EURO.convert(230, YEN));
		assertEquals(betrag2, YEN.convert(20000, EURO));
		assertEquals(betrag3, CHF.convert(300, EURO));
		assertEquals(betrag4, DOLLAR.convert(200, EURO));
		assertEquals(betrag5, DOLLAR.convert(200, YEN));

	}

	@Test
	public void testAddieren() {
		Amount betrag = new Amount(89, DOLLAR);
		Amount betrag2 = new Amount(55, EURO);

		assertEquals(new Amount(13234, DOLLAR), betrag.add(betrag2));
	}

	@Test
	public void testSubtrahieren() {
		Amount betrag = new Amount(89, DOLLAR);
		Amount betrag2 = new Amount(167, EURO);

		assertEquals(new Amount(-4259, DOLLAR), betrag.subtract(betrag2));
	}

	@Test
	public void testMultiDouble() {
		Amount betrag = new Amount(5, DOLLAR);

		assertEquals(new Amount(65.0, DOLLAR), betrag.multiply(13.0));
	}

	@Test
	public void testMultiInt() {
		Amount betrag = new Amount(5, DOLLAR);

		assertEquals(new Amount(65, DOLLAR), betrag.multiply(13));
	}

	@Test
	public void testPercentage() {
		Amount betrag = new Amount(50, DOLLAR);

		assertEquals(new Amount(22, DOLLAR), betrag.percentage(44));
	}

	@Test
	public void testGetSign() {
		Amount betrag = new Amount(3420, YEN);
		Amount betrag2 = new Amount(-298, RUBEL);

		assertEquals(1, betrag.getSign());
		assertEquals(-1, betrag2.getSign());
	}

	@Test
	public void testToString() {
		Amount euro = new Amount(0.99, EURO);
		Amount euro2 = new Amount(12.90, EURO);
		Amount rubel = new Amount(-0.09, RUBEL);
		Amount yen = new Amount(9818, YEN);
		Amount chf = new Amount(0.00, CHF);

		assertEquals("0,99 €", euro.toString());
		assertEquals("12,90 €", euro2.toString());
		assertEquals("-0,09 RUB", rubel.toString());
		assertEquals("9818 ¥", yen.toString());
		assertEquals("0,00 CHF", chf.toString());
	}

	@Test
	public void testToDouble() {
		Amount euro = new Amount(196.9678236487134789, EURO);

		Amount test = new Amount(euro.toDouble(), EURO);
		Amount ergebnis = new Amount(196.96, EURO);

		assertEquals(ergebnis, test);
	}

	@Test
	public void testToLong() {
		Amount dollar = new Amount(196.96733737, DOLLAR);

		assertEquals(19696, dollar.toLong());
	}

	@Test
	public void testPostUndTotal() {
		Account hueseyin = new Account("boy", DOLLAR);
		Amount para = new Amount(456, EURO);
		hueseyin.post(para);

		assertEquals(new Amount(35933, DOLLAR), hueseyin.total());
	}

	@Test
	public void testAccountFee() {
		Account taib = new Account("Taib Demirci", EURO);
		Amount betrag1 = new Amount(344, EURO);
		Amount betrag2 = new Amount(-55, EURO);
		Amount betrag3 = new Amount(3000, EURO);
		Amount betrag4 = new Amount(-678, EURO);
		Amount betrag5 = new Amount(-90, EURO);

		taib.post(betrag1);
		taib.post(betrag2);
		taib.post(betrag3);
		taib.post(betrag4);
		taib.post(betrag5);

		taib.accountFee(1);

		assertEquals(251848, taib.total().toLong());

	}

}
