package implementierung;

import schnittstelle.Crypter;

public class CrypterFactory {
//Enumeration (CrypterVerfahren) mit den Konstanten CAESAR, SUBSTITUTION und XOR
	public enum CrypterVerfahren {
		CAESAR, SUBSTITUTION, XOR;
	}
	
	public Crypter CrypterErzeugen(CrypterVerfahren konstante){
		if(konstante == CrypterVerfahren.CAESAR){
			return new CrypterCaesar();
		}else if(konstante == CrypterVerfahren.SUBSTITUTION){
			return new CrypterSubstitution();
		}else{
			return new CrypterXOR();
		}
	}
}
