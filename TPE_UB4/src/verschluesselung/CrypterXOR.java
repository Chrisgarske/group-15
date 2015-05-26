package verschluesselung;

public class CrypterXOR implements Crypter {
	// Methode für verschlüsselung

	private String klartext = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[/]^_";

	public int keyNr(String key, int x){
		int schluesselnr = -1;
		for (int i = 0; i < klartext.length(); i++) {
			if(key.charAt(x) == klartext.charAt(i)){
				schluesselnr=i;
			}
			
		}
		
		return schluesselnr;
	}
	
	public String verschluesseln(String key, String message) {
		// throws IllegalKeyException, IllegalMessageException

		int ergebnis = -2;
		int x = 0; 
		String endErgebnis = "";
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if (message.charAt(i) == klartext.charAt(j)) {
					ergebnis= j ^ keyNr(key, x);
					if(x >= key.length()-1){
						x = 0;
					}else{
						x += 1;
					}
					endErgebnis += klartext.charAt(ergebnis);
					
				}
			}
		}

		return endErgebnis;
	}

	public String entschluesseln(String key, String cypherText) {
		// throws IllegalKeyException, IllegalMessageException
		int ergebnis = -2;
		int b = 0; 
		String entschluesselt = "";
		for (int i = 0; i < cypherText.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if (cypherText.charAt(i) == klartext.charAt(j)) {
					ergebnis= j ^ keyNr(key, b);
					if(b >= key.length()-1){
						b = 0;
					}else{
						b += 1;
					}
					entschluesselt += klartext.charAt(ergebnis);
					
				}
			}
		}

		return entschluesselt;
	}
}
