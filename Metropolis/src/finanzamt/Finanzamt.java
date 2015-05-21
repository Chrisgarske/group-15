//Gruppe - 15
package finanzamt;
import einwohner.Schurke;
import institution.Syndikat;

public class Finanzamt {
	private int gesamteSteuern;
	Einkommenssteuer einkommenssteuer;
	Koerperschaftssteuer koerperschaftssteuer;
	
	public void berechneEinkommenssteuer(Schurke schurke){
		einkommenssteuer = schurke;
		gesamteSteuern += schurke.getSteuerabgaben();
	}
	
	public void berechneKoerperschaftssteuer(Syndikat syndikat){
		koerperschaftssteuer = syndikat;
		gesamteSteuern += syndikat.getSteuerAbgaben();
	}
	
	public void berechneGesamteSteuern(Schurke schurke, Syndikat syndikat){
		berechneEinkommenssteuer(schurke);
		berechneKoerperschaftssteuer(syndikat);
	}

	@Override
	public String toString() {
		return "Finanzamt [gesamteSteuern=" + gesamteSteuern + "]";
	}
	
}