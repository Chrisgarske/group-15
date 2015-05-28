package ausnahmen;

/**
 * Klasse, die zur Fehlerbehandlung von Falscheingaben von dem Schluessel dient.
 * 
 * Instanzen werden mithilfe der beiden Konstruktoren, entweder
 * mit einer erklärenden Nachricht oder ohne erzeugt. 
 * 
 * @author Buesra Yildiz, Ilker Turan, Taib Demirci
 */
public class IllegalKeyException extends Exception {
	
	/**
	 * Erzeugung einer Instanz ohne Parameter
	 */
	public IllegalKeyException(){
		
	}
	
	/**
	 * Erzeugung einer Instanz mit einer Beschreibung des Fehlers
	 * 
	 * @param message Beschreibung des aufgetretenen Fehlers
	 */
	public IllegalKeyException(String message){
		super(message);
	}
}
