public class Vector {

	private double x;
	private double y;
	private double z;

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector() {
		
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public String toString() {
		return "X" + x + "Y" + y + "Z" + z;
	}

	public Vector addiere(Vector v) {
		this.x = this.x + v.x;
		this.y += v.y;
		this.z += v.z;
		return v;
	}

	public double betrag() {
		Math.sqrt((x * x) + (y * y) + (z * z));
		return betrag();
	}

	public Vector multipliziereSkalar(double skalar) {
		this.x = skalar * getX();
		this.y = skalar * getY();
		this.z = skalar * getZ();

		return new Vector();
	}

	public Vector einheitsvektor() {

		multipliziereSkalar(1 / betrag());
		return new Vector();
	}

	public void kreuzprodukt(Vector vector) {
		double X2, Y2, Z2;
		X2 = this.y * vector.z - this.z * vector.y;
		Y2 = this.z * vector.x - this.x * vector.z;
		Z2 = this.x * vector.y - this.y * vector.x;
		this.x = X2;
		this.y = Y2;
		this.z = Z2;

	}

	public double multipliziere(Vector vektor) {

		return 0;
	}

	public double winkel(Vector vector) {
		return 0;
	}

}
