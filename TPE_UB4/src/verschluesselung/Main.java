package verschluesselung;

public class Main {

	public static void main(String[] args) {
		//Aufgabe: Kombination der Schl�ssel verwenden
		
		CrypterCaesar jap = new CrypterCaesar();
		
		String ergebnis = jap.verschluesseln("Y", "SELAMINALEYKUEM");
		System.out.println(ergebnis);
	}

}
