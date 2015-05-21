//Gruppe - 15
package institution;

import java.util.ArrayList;

import einwohner.Schurke;
import finanzamt.Koerperschaftssteuer;

public class Syndikat implements Koerperschaftssteuer{
	
	private String name;
	private int steuerAbgaben=0;
	private ArrayList<Schurke> liste = new ArrayList<Schurke>();
	private int gesamtEinkommen;
	
	public Syndikat(String name) {
		this.name=name;
	}
	
	public void setMitglied(Schurke schurke){
		liste.add(schurke);
	}
	
	public void gesamtBerechnen(){
		int summe = 0;
		for(Schurke stelle: liste){
			summe += stelle.getEinkommen();
		}
		
		gesamtEinkommen = summe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSteuerAbgaben() {
		return steuerAbgaben;
	}

	public int getGesamtEinkommen() {
		return gesamtEinkommen;
	}

	public void setGesamtEinkommen(int gesamtEinkommen) {
		this.gesamtEinkommen = gesamtEinkommen;
	}
	
	//Methode
	@Override
	public void kSteuerBerechnen() {
		int steuer = (getGesamtEinkommen()*KSTEUER)/100;
		steuerAbgaben = steuer;
	}
}
