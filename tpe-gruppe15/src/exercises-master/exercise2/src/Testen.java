
import static org.junit.Assert.*;

import org.junit.*;


 public class Testen implements Currencies {
	@Test
	    public void testConvert() {
		long  betrag = 126;
		
		assertEquals(betrag, EURO.convert(100, DOLLAR));
		
	 }
	
	@Test
	public void testAddieren(){
		Amount betrag = new Amount(89, DOLLAR);
		Amount betrag2 = new Amount(55, DOLLAR);
		
		assertEquals(new Amount(144, DOLLAR), betrag.add(betrag2));
	}
	
	@Test
	public void testSubtrahieren(){
		Amount betrag = new Amount(89, DOLLAR);
		Amount betrag2 = new Amount(167, EURO);
		
		assertEquals(new Amount(-55, EURO), betrag.subtract(betrag2));
	}
	
	@Test
	public void testMultiDouble(){
		Amount betrag = new Amount(5, DOLLAR);
		
		assertEquals(new Amount(65.0, DOLLAR), betrag.multiply(13.0));
	}
	
	
	@Test
	public void testMultiInt(){
		Amount betrag = new Amount(5, DOLLAR);
		
		assertEquals(new Amount(65, DOLLAR), betrag.multiply(13));
	}
	
	
	@Test
	public void testPercentage(){
		Amount betrag = new Amount(50, DOLLAR);
		
		assertEquals(new Amount(22, DOLLAR), betrag.percentage(44));
	}
	
	@Test
	public void testGetSign(){
		Amount betrag = new Amount(3420, YEN);
		Amount betrag2 = new Amount(-298, RUBEL);
		
		assertEquals(1, betrag.getSign());
		assertEquals(-1, betrag2.getSign());
	}
	
	@Test
	public void testToString(){
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
	

	public void testToDouble(){
		Amount euro = new Amount(196.9678236487134789, EURO);
		System.out.println(euro.toDouble());
		assertEquals(196.96, euro.toDouble());
	}
	
	@Test 
	public void testToLong(){
		Amount dollar = new Amount(196.96733737, DOLLAR);
		
		assertEquals(19696, dollar.toLong());
	}
	
	@Test
	public void testPost(){
		Account taib = new Account("Taib", DOLLAR);
		Amount betrag = new Amount(50, DOLLAR);
		taib.post(betrag);
		assertEquals(new Amount(0, DOLLAR), taib.total());
	}
	
	


}
