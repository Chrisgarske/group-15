package implementierung;

import ausnahmen.*;
import schnittstelle.Crypter;

class CrypterCaesar extends Fehlerbehandlung implements Crypter {
	// Methode f�r verschl�sselung
	private String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	private String klartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	
	public void keyLaenge(String key) throws IllegalKeyException{
		if (key.length() != 1) {
			throw new IllegalKeyException("Schlüssel darf und muss genau einen "
					+ "Buchstaben enthalten!");
		}
		
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

		keyLaenge(key);
		
		boolean gefunden = false;
		boolean fehler = true;
		
		for (int i = 0; i < alpha.length && !gefunden; i++) {
			if (key.equals(alpha[i])) {
				gefunden = true;
				fehler = false;
			}
		}

		if (fehler) {
			throw new IllegalKeyException("Ihre Schlüsseleingabe ist nicht "
					+ "im angegebenen Alphabet enthalten!");
		}
}
	
	/**
	 * see implementierung.Crypter.verschluesseln
	 */
	@Override
	public String verschluesseln(String key, String message)throws IllegalKeyException, IllegalMessageException{

		fehlerkontrolleKey(key, this.alpha);
		fehlerkontrolleMessage(message, this.klartext);
		
		int stelle = 0;

		boolean gefunden = true;
		for (int i = 0; i < alpha.length && gefunden; i++) {
			if (key == alpha[i]) {
				stelle = i + 1;
				gefunden = false;
			}
		}

		int caesar = -1;
		String geheimText = "";
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if (klartext.charAt(j) == message.charAt(i)) {
					caesar = j + stelle;
					if (caesar > 25) {
						caesar = caesar - 26;
					}
					geheimText += klartext.substring(caesar, caesar + 1);
				}
			}

		}

		return geheimText;
	};

	/**
	 * see implementierung.Crypter.entschluesseln
	 */
	@Override
	public String entschluesseln(String key, String cypherText) throws IllegalKeyException, IllegalMessageException{

		keyLaenge(key);
		fehlerkontrolleKey(key, this.alpha);
		fehlerkontrolleMessage(cypherText, this.klartext);
		
		int stelle = 0;

		boolean gefunden = true;
		for (int i = 0; i < alpha.length && gefunden; i++) {
			if (key == alpha[i]) {
				stelle = i + 1;
				gefunden = false;
			}
		}
		int caesar = -1;
		String decodierung = "";
		for (int i = 0; i < cypherText.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if (klartext.charAt(j) == cypherText.charAt(i)) {
					caesar = j - stelle;
					if (caesar < 0) {
						caesar = 26 + caesar;
					}
					decodierung += klartext.substring(caesar, caesar + 1);
				}
			}

		}

		return decodierung;
	};

}
