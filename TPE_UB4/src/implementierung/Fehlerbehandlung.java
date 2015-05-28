package implementierung;
/**
 * Klasse, zur behandlung der Fehler, welche in den Verschluesselungsverfahren
 * auftreten können.
 * 
 * Die Klasse überprüft zum einen, ob der eingegebene Schluessel den Normen entspricht,
 * die festegelt wurden, zum anderen ob der Text, der verschluesselt werden soll,
 * nicht definierte Zeichen aufweist. 
 * 
 * Entsprechend der falschen Eingabe bekommt man die passende Fehlermeldung zuruek.
 * 
 * Eine Objekterzeugung dieser Klasse ist nicht sinnvoll, somit ist sie abstrakt.
 * 
 * @author Buesra Yildiz, Ilker Turan, Taib Demirci
 */
import ausnahmen.IllegalKeyException;
import ausnahmen.IllegalMessageException;

	abstract class Fehlerbehandlung {
	
		
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

			boolean gefunden = false;
			boolean fehler = true;
			
			for (int i = 0; i < alpha.length && !gefunden; i++) {
				if (key == alpha[i]) {
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
	 * Kontrolliert, ob die eingegebene Nachricht nicht leer und nicht festgelegte Buchstaben oder
	 * Zeichen enthält. Bei einem Fehler bekommmt man eine Fehlermeldung zurueck.
	 * 
	 * @param message die Nachricht, die ver- oder entschluesselt wird.
	 * @param klartext das festgelegte Alphabet
	 * @throws IllegalMessageException die Fehlermeldung, die bei einem Fehler ausgeworfen wird
	 * 
	 */
	public void fehlerkontrolleMessage(String message, String klartext) throws IllegalMessageException {

		boolean gefunden = false;
		boolean fehler = false;
		
		if(message.length() == 0){
			throw new IllegalMessageException("Sie haben keine Nachricht eingegeben!");
		}
		
		for (int i = 0; i < message.length() && !fehler; i++) {
			for (int j = 0; j < klartext.length() && !gefunden; j++) {
				if(message.charAt(i) == klartext.charAt(j)){
					gefunden = true;
					fehler = false;
				}else{
					fehler = true;
				}
			}
			gefunden = false;
		}

		if (fehler) {
			throw new IllegalMessageException("Der Inhalt Ihrer Nachricht ist nicht "
					+ "im angegebenen Alphabet enthalten!");
		}

	}

}
