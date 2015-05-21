package verschluesselung;

public class CrypterCaesar implements Crypter {
	// Methode für verschlüsselung
	private String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	char[] alpha2 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z' };

	@Override
	public String verschluesseln(String key, String message)
		//	throws IllegalKeyException, IllegalMessageException 
	{

		int stelle = 0;

		boolean gefunden = true;
		for (int i = 0; i < alpha.length && gefunden; i++) {
			if (key == alpha[i]) {
				stelle = i + 1;
				gefunden = false;
			}
		}

		char[] ergebnis = message.toCharArray();

		for (int i = 0; i < ergebnis.length; i++) {
			if ((ergebnis[i] - 'A') + stelle < alpha2.length) {
				ergebnis[i] = alpha2[(ergebnis[i] - 'A') + stelle];
			}else{
				int diff = (ergebnis[i] - 'A') + stelle - alpha2.length;
				ergebnis[i] = alpha2[diff];
			}
		}

		String endErgebnis = "";
		for (int i = 0; i < ergebnis.length; i++) {
			endErgebnis += ergebnis[i];
		}

		return endErgebnis;
	};

	@Override
	public String entschluesseln(String key, String cypherText)
			//throws IllegalKeyException, IllegalMessageException 
	{
		
		int stelle = 0;

		boolean gefunden = true;
		for (int i = 0; i < alpha.length && gefunden; i++) {
			if (key == alpha[i]) {
				stelle = i + 1;
				gefunden = false;
			}
		}
		
		char[] ergebnis = cypherText.toCharArray();
		
		for (int i = 0; i < ergebnis.length; i++) {
			if (ergebnis[i] - stelle - 'A' < 0) {
				int diff = ergebnis[i] - stelle - 'A';
				ergebnis[i] = alpha2[diff];
			}else{
				ergebnis[i] = alpha2[ergebnis[i] - stelle - 'A'];
			}
		}
		
		String endErgebnis = "";
		for (int i = 0; i < ergebnis.length; i++) {
			endErgebnis += ergebnis[i];
		}

		return endErgebnis;
	};

}
