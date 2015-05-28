package verschluesselung;

import ausnahmen.IllegalKeyException;
import ausnahmen.IllegalMessageException;
import implementierung.CrypterFactory;
import implementierung.CrypterFactory.CrypterVerfahren;
import schnittstelle.Crypter;

public class Main {

	public static void main(String[] args) throws IllegalKeyException, IllegalMessageException{
		//Aufgabe: Kombination der Schl�ssel verwenden
		
		
		
		CrypterFactory factory = new CrypterFactory();
		Crypter jap = factory.CrypterErzeugen(CrypterVerfahren.CAESAR);
		Crypter hey = factory.CrypterErzeugen(CrypterVerfahren.SUBSTITUTION);
		Crypter xor = factory.CrypterErzeugen(CrypterVerfahren.XOR);
		
//		String ergebnis = jap.verschluesseln("T", "IJKLMNOPQRSTUVWXYZABCDEFGH");
//		System.out.println(ergebnis);
		
//		String rueck = jap.entschluesseln("T", "CDEFGHIJKLMNOPQRSTUVWXYZAB");
//		System.out.println(rueck);
		
//		String ergebnis1 = hey.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "BATMAN");
//		System.out.println(ergebnis1);
		
//		String subrueck = hey.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "FUEOUN");
//		System.out.println(subrueck);
		
//		String messi = xor.verschluesseln("TPERULES", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//		System.out.println(messi);
		
//		String xavi = xor.entschluesseln("TPERULES", "URFVPJB[]ZN^XBJCEBVF@ZRKMJ");
//		System.out.println(xavi);
		
		
//		String gear1 = xor.entschluesseln("WINTERISCOMING", "RXZL_FO\\W_UXX_S]KPOVQCTLTQZVG]^L_FXWWIYYVDQD\\PQTQAEXAODQAXZRQBQEA[HLZW");
//		System.out.println(gear1);
//		
//		String gear2 = jap.entschluesseln("T", "EQTXZTFOTPXQVXDTEDJDXPWCYXTQPTPXZTQDTFTPXCFMRDTFXRFWLFJVVQTFTPXVBTEETP");
//		System.out.println(gear2);
//		
//		String gear3 = hey.entschluesseln("POIUZTREWQMNBVCXYLKJHGFDSA", "KWZDFZLUZVDWBDJZKJPJDVCIEDZWVZVDFZWJZLZVDILSXJZLDXLCRLPBBWZLZVDBHZKKZV");
//		System.out.println(gear3);
	}
}
