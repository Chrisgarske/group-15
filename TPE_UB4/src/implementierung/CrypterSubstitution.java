package implementierung;

import ausnahmen.IllegalKeyException;
import ausnahmen.IllegalMessageException;
import schnittstelle.Crypter;

	class CrypterSubstitution extends Fehlerbehandlung implements Crypter {
	// Methode f�r verschl�sselung

	private String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };	
	
	private String klartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public void keyLaenge(String key) throws IllegalKeyException{
		if (key.length() != 26) {
			throw new IllegalKeyException("Schlüssel darf und muss genau 26 "
					+ "Buchstaben enthalten!");
		}
		
	}
	
	/**
	 * Kontrolliert, ob der Schluessel doppelte Buchstaben enthält.
	 * 
	 * @param key der Schluessel mit der ver- oder entschluesselt wird.
	 * @throws IllegalKeyException die Fehlermeldung, die bei einem Fehler ausgeworfen wird
	 * 
	 */
	public void fehlerkontrolleKeyDuplikate(String key) throws IllegalKeyException{
		keyLaenge(key);
		for (int i = 0; i < key.length(); i++) {
			int anzahl = 1;
			boolean gefunden = false;
			for (int j = 0; j < key.length() && !gefunden; j++) {
				if(key.charAt(i) == key.charAt(j)){
					anzahl++;
					gefunden = true;
				}
			}
			if(anzahl >= 2){
				throw new IllegalKeyException("Im Schluessel duerfen Buchstaben nur jeweils einaml vorkommen!");
			}
		}
	}

	/**
	 * see implementierung.Crypter.verschluesseln
	 */
	@Override
	public String verschluesseln(String key, String message) throws IllegalKeyException, IllegalMessageException{
		
		fehlerkontrolleKeyDuplikate(key);
		fehlerkontrolleMessage(message, this.klartext);
		
		String geheimeBotschaft = "";
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if (message.charAt(i) == klartext.charAt(j)) {
					geheimeBotschaft += key.substring(j, j + 1);
				}

			}

		}

		return geheimeBotschaft;

	}

	/**
	 * see implementierung.Crypter.entschluesseln
	 */
	@Override
	public String entschluesseln(String key, String cypherText) throws IllegalKeyException, IllegalMessageException{
		
		fehlerkontrolleKeyDuplikate(key);
		fehlerkontrolleMessage(cypherText, this.klartext);
		
			String decodierung = "";
			for (int i = 0; i < cypherText.length(); i++) {
				for (int j = 0; j < key.length(); j++) {
					if (cypherText.charAt(i) == key.charAt(j)) {
						decodierung += klartext.substring(j, j + 1);
					}

				}

			}

			return decodierung;

		}

}
