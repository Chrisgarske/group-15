//Gruppe - 15
package einwohner;

import finanzamt.Einkommenssteuer;

public class Schurke extends Mutant implements Einkommenssteuer {
	private int steuerabgaben = 0;
	
	public Schurke(String name, int einkommen, String mutation) {
		super(name, einkommen, mutation);

	}
	
	public void steuerGesamt(){
		if(getEinkommen() >= 60000){
			e1Steuerberechen();
			e2Steuerberechen();
			e3Steuerberechen();
			e4Steuerberechen();
		}else if(getEinkommen() >= 40000){
			e1Steuerberechen();
			e2Steuerberechen();
			e3Steuerberechen();
		}else if(getEinkommen() >= 20000){
			e1Steuerberechen();
			e2Steuerberechen();
		}else{
			e1Steuerberechen();
		}
	}
	
	
	@Override
	public void e1Steuerberechen(){
		if(getEinkommen()<= 20000){
		int abgabe = (20000 * E1)/100;
		steuerabgaben += abgabe;
		}
	}
	
	@Override
	public void e2Steuerberechen(){
		int sEinkommen = getEinkommen() -20000;
		int abgabe = 0;
		if(sEinkommen > 0)
			if(sEinkommen < 40000)
			abgabe = (sEinkommen * E2)/100;
			else{
				abgabe = (40000 * E2)/100;
			}
		steuerabgaben += abgabe;
		}
	
		
	
	@Override
	public void e3Steuerberechen(){
		int sEinkommen = getEinkommen() -40000;
		int abgabe = 0;
		if(sEinkommen > 0)
			if(sEinkommen < 60000)
			abgabe = (sEinkommen * E3)/100;
			else{
				abgabe = (60000 * E3)/100;
			}
		steuerabgaben += abgabe;
	}
	
	@Override
	public void e4Steuerberechen(){
		int sEinkommen = getEinkommen() -60000;
		int abgabe = 0;
		if(sEinkommen > 0){
			abgabe = (sEinkommen * E4)/100;
		}
		steuerabgaben += abgabe;
	}

	public int getSteuerabgaben() {
		return steuerabgaben;
	}
	
}

