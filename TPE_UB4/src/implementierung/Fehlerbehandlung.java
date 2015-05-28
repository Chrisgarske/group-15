package implementierung;

import ausnahmen.IllegalKeyException;
import ausnahmen.IllegalMessageException;

	abstract class Fehlerbehandlung {
	
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
