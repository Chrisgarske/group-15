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

	/**
	 * see implementierung.Crypter.verschluesseln
	 */
	@Override
	public String verschluesseln(String key, String message) throws IllegalKeyException, IllegalMessageException{
		
		fehlerkontrolleMessage(message, this.klartext);
		fehlerkontrolleKey(key, alpha);
		
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
		
		fehlerkontrolleMessage(cypherText, this.klartext);
		fehlerkontrolleKey(key, alpha);
		
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
