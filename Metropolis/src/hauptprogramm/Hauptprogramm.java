//Gruppe - 15
package hauptprogramm;

import institution.Syndikat;
import einwohner.Schurke;
import finanzamt.Finanzamt;

public class Hauptprogramm {

	public static void main(String[] args) {
		Schurke azog = new Schurke("Azog der Schänder", 27990, "Orkismus");
		Schurke hannibal = new Schurke("Hannibal Lecter", 19910, "Kannibalismus");
		Schurke onox= new Schurke("Onox", 270201, "Legendismus");
		
		Syndikat syndikat = new Syndikat("Syndikat der Superschurken");

		syndikat.setMitglied(azog);
		syndikat.setMitglied(hannibal);
		syndikat.gesamtBerechnen();
		syndikat.kSteuerBerechnen();
		
		onox.steuerGesamt();
		
		Finanzamt finanzamt = new Finanzamt();
		
		finanzamt.berechneGesamteSteuern(onox, syndikat);
		
		System.out.println(onox.getSteuerabgaben());
		
		System.out.println(finanzamt);
		
	}

}
