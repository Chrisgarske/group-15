package verschluesselung;

public class Main {

	public static void main(String[] args) {
		//Aufgabe: Kombination der Schlüssel verwenden
		
		CrypterCaesar jap = new CrypterCaesar();
		
//		String ergebnis = jap.verschluesseln("B", "RANGO");
//		System.out.println(ergebnis);
		
//		String rueck = jap.entschluesseln("B", "TCPIQ");
//		System.out.println(rueck);
		
		CrypterSubstitution hey = new CrypterSubstitution();
		
		String ergebnis1 = hey.verschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "BATMAN");
//		System.out.println(ergebnis1);
		
		String subrueck = hey.entschluesseln("UFLPWDRASJMCONQYBVTEXHZKGI", "FUEOUN");
//		System.out.println(subrueck);
		
		CrypterXOR xor = new CrypterXOR();
		
		String messi = xor.verschluesseln("TPERULES", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		System.out.println(messi);
		
		String xavi = xor.entschluesseln("TPERULES", "URFVPJB[]ZN^XBJCEBVF@ZRKMJ");
		System.out.println(xavi);
		
	}
	

}
