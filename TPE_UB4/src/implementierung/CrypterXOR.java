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
	 * Kontrolliert, ob der eingegebene Schluessel nicht festgelegte Buchstaben oder
	 * Zeichen enthält. Bei einem Fehler bekommmt man eine Fehlermeldung zurueck.
	 * 
	 * @param key der Schluessel mit der ver- oder entschluesselt wird.
	 * @param alpha das festgelegte Alphabet
	 * @throws IllegalKeyException die Fehlermeldung, die bei einem Fehler ausgeworfen wird
	 * 
	 */
	public void fehlerkontrolleKey(String key, String[] alpha) throws IllegalKeyException{
		for (int i = 0; i < key.length(); i++) {
			boolean gefunden = false;
			for (int j = 0; j < alpha.length && !gefunden; j++) {
				if(key.substring(i, i+1).equals(alpha[j])){
					gefunden = true;
				}

			}
			
			if(!gefunden){
				throw new IllegalKeyException("Ihr Schluessel enthält nicht zulässige Zeichen!");
			}
		}
	}
	
	/**
	 * see implementierung.Crypter.verschluesseln
	 */
	public String verschluesseln(String key, String message)throws IllegalKeyException, IllegalMessageException {
		
		fehlerkontrolleKey(key, alpha);
		fehlerkontrolleMessage(message, this.klartext);
				
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
		
		fehlerkontrolleKey(key, alpha);
		fehlerkontrolleMessage(cypherText, this.klartext);
		
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
