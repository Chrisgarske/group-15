package verschluesselung;

public class Main {

	public static void main(String[] args) {
		//Aufgabe: Kombination der Schlüssel verwenden
		
		CrypterCaesar jap = new CrypterCaesar();
		
		String ergebnis = jap.verschluesseln("B", "HALLO");
		System.out.println(ergebnis);
		
		String rueck = jap.entschluesseln("B", "JCNNQ");
		System.out.println(rueck);
		
		CrypterSubstitution hey = new CrypterSubstitution();
		String ergebnis1 = hey.verschluesseln(null, "BALU");
		System.out.println(ergebnis1);
		
		String subrueck = hey.entschluesseln(null, "FUCX");
		System.out.println(subrueck);
		
	}
	

}
