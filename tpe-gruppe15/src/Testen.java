import static org.junit.Assert.*;

import org.junit.*;


 public class Testen extends Currencies {
	@Test
	    public void testConvert() {
		long  betrag = 126;
		
		assertEquals(betrag, EURO.convert(100, DOLLAR));
		
	 }
	
	@Test
	public void testaddieren(){
		Amount betrag = new Amount(1567, DOLLAR);
		Amount betrag2 = new Amount(3456, EURO);
		
		assertEquals(new Amount(5444, EURO), betrag.add(betrag2));
	}


}
