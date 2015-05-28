package implementierung;

import ausnahmen.IllegalKeyException;
import ausnahmen.IllegalMessageException;
import schnittstelle.Crypter;


 	class CrypterXOR extends Fehlerbehandlung implements Crypter {
	// Methode f�r verschl�sselung

 	private String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
 				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
 				"W", "X", "Y", "Z"};
 	
	private String klartext = "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_";

	public int keyNr(String key, int x){
		int schluesselnr = -1; 
		for (int i = 0; i < klartext.length(); i++) {
			if(key.charAt(x) == klartext.charAt(i)){
				schluesselnr=i;
			}
			
		}
		
		return schluesselnr;
	}
	
	/**
	 * see implementierung.Crypter.verschluesseln
	 */
	public String verschluesseln(String key, String message)throws IllegalKeyException, IllegalMessageException {

		fehlerkontrolleMessage(message, this.klartext);
		fehlerkontrolleKey(key, alpha);
		
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

	/**
	 * see implementierung.Crypter.entschluesseln
	 */
	public String entschluesseln(String key, String cypherText) throws IllegalKeyException, IllegalMessageException{
		
		fehlerkontrolleMessage(cypherText, this.klartext);
		fehlerkontrolleKey(key, alpha);
		
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
