//Gruppe - 15
package einwohner;

public abstract class Mutant extends Einwohner {
	protected String mutation;
	
	public Mutant(String name, int einkommen, String mutation){
		super(name, einkommen);
		this.mutation=mutation;
	}

	public String getMutation() {
		return mutation;
	}

	public void setMutation(String mutation) {
		this.mutation = mutation;
	}
	
}
