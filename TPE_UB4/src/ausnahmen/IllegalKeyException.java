package ausnahmen;

public class IllegalKeyException extends Exception {
	
	public IllegalKeyException(){
		
	}
	
	public IllegalKeyException(String message){
		super(message);
	}
}
