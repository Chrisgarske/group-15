package verschluesselung;

public class Main {

	public static void main(String[] args) {
		//Aufgabe: Kombination der Schlüssel verwenden
		
//		CrypterCaesar jap = new CrypterCaesar();
//		
//		String ergebnis = jap.verschluesseln("B", "HALLO");
//		System.out.println(ergebnis);
//		
//		String rueck = jap.entschluesseln("B", "JCNNQ");
//		System.out.println(rueck);
		
		CrypterSubstitution hey = new CrypterSubstitution();
		String ergebnis = hey.verschluesseln(null, "B");
		System.out.println(ergebnis);
	
}
}