//Gruppe - 15
package finanzamt;

public interface Einkommenssteuer {
	public static final int E1 = 8;
	public static final int E2 = 15;
	public static final int E3 = 25;
	public static final int E4 = 40;

	public abstract void e1Steuerberechen();
	public abstract void e2Steuerberechen();
	public abstract void e3Steuerberechen();
	public abstract void e4Steuerberechen();
}

