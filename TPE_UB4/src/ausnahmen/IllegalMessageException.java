package ausnahmen;

public class IllegalMessageException extends Exception {
	
	
	public IllegalMessageException(){
		
	}
	
	/**
	 * Beim Auftreten eines Fehlers in der Nachricht wird der Konstruktor aufgerufen.
	 * Dabei wird erklärt worin der Fehler liegt.
	 * @param message ausgabe des Fehlers
	 */
	
	public IllegalMessageException(String message){
		super(message);
	}
}
