package ausnahmen;

/**
 * Klasse, die zur Fehlerbehandlung von Falscheingaben von der Nachricht dient.
 * 
 * Instanzen werden mithilfe der beiden Konstruktoren, entweder
 * mit einer erklärenden Nachricht oder ohne erzeugt. 
 * 
 * @author Buesra Yildiz, Ilker Turan, Taib Demirci
 */

public class IllegalMessageException extends Exception {
	
	/**
	 * Erzeugung einer Instanz ohne Parameter
	 */
	public IllegalMessageException(){
		
	}
	
	/**
	 * Erzeugung einer Instanz mit einer Beschreibung des Fehlers
	 * 
	 * @param message ausgabe des Fehlers
	 */
	public IllegalMessageException(String message){
		super(message);
	}
}
