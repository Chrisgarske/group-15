package verschluesselung;

public class Main {

	public static void main(String[] args) {
		//Aufgabe: Kombination der Schlüssel verwenden
		
		CrypterCaesar jap = new CrypterCaesar();
		
//		String ergebnis = jap.verschluesseln("T", "IJKLMNOPQRSTUVWXYZABCDEFGH");
//		System.out.println(ergebnis);
		
//		String rueck = jap.entschluesseln("T", "CDEFGHIJKLMNOPQRSTUVWXYZAB");
//		System.out.println(rueck);
		
		CrypterSubstitution hey = new CrypterSubstitution();
		
//		String ergebnis1 = hey.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "BATMAN");
//		System.out.println(ergebnis1);
		
//		String subrueck = hey.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "FUEOUN");
//		System.out.println(subrueck);
		
		CrypterXOR xor = new CrypterXOR();
		
		
		
		
//		String messi = xor.verschluesseln("TPERULES", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//		System.out.println(messi);
		
//		String xavi = xor.entschluesseln("TPERULES", "URFVPJB[]ZN^XBJCEBVF@ZRKMJ");
//		System.out.println(xavi);
		
		
		String gear1 = xor.entschluesseln("WINTERISCOMING", "RXZL_FO\\W_UXX_S]KPOVQCTLTQZVG]^L_FXWWIYYVDQD\\PQTQAEXAODQAXZRQBQEA[HLZW");
		System.out.println(gear1);
		
		String gear2 = jap.entschluesseln("T", "EQTXZTFOTPXQVXDTEDJDXPWCYXTQPTPXZTQDTFTPXCFMRDTFXRFWLFJVVQTFTPXVBTEETP");
		System.out.println(gear2);
		
		String gear3 = hey.entschluesseln("POIUZTREWQMNBVCXYLKJHGFDSA", "KWZDFZLUZVDWBDJZKJPJDVCIEDZWVZVDFZWJZLZVDILSXJZLDXLCRLPBBWZLZVDBHZKKZV");
		System.out.println(gear3);
		
	}
	

}
