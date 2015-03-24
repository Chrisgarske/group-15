public class Vector {
	// Attribute
	private double x;
	private double y;
	private double z;

	// Konstruktor
	public Vector() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	// Erzeugt einen neuen Vektor mit den angebgebenen Elementen
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Liefert die X-Koordinate/Komponente des Vektors
	public double getX() {
		return x;
	}

	// Liefert die Y-Koordinate/Komponente des Vektors
	public double getY() {
		return y;
	}

	// Liefert die Z-Koordinate/Komponente des Vektors
	public double getZ() {
		return z;
	}

	// Bestimmt die Länge bzw. den Betrag des Vektors
	public double betrag() {
		return Math.sqrt((x * x) + (y * y) + (z * z));
	}

	// Addiert den gegebenen Vektor zu den aktuellen Vektor
	public Vector addiere(Vector vector) {
		double x = getX() + vector.getX();
		double y = getY() + vector.getY();
		double z = getZ() + vector.getZ();

		return new Vector(x, y, z);
	}

	// Multiplikation des Vektors mit einem Skalar
	public Vector multipliziere(double skalar) {
		return new Vector((getX() * skalar), (getY() * skalar),
				(getZ() * skalar));
	}

	// Multiplikation des Vektors mit einem anderen Vektor
	public double multipliziere(Vector vector) {
		double x = getX() * vector.getX();
		double y = getY() * vector.getY();
		double z = getZ() * vector.getZ();

		double ergebnis = x + y + z;

		return ergebnis;
	}

	// Der Einheitsvektor wird bestimmt (außer, wenn der Betrag 0 ist)
	public Vector einheitsvektor() {
		if (betrag() != 0) {
			double x = getX() / betrag();
			double y = getY() / betrag();
			double z = getZ() / betrag();

			return new Vector(x, y, z);
		} else {
			return null; // Einheitsvektor kann hier nicht bestimmt werden, da
							// der Betrag 0 ist
		}
	}

	// Bestimmt das Kreuzprodukt mit dem gegebenen Vektor
	public Vector kreuzprodukt(Vector vector) {
		int x = (int) (getY() * vector.getZ() - getZ() * vector.getY());
		int y = (int) (getZ() * vector.getX() - getX() * vector.getZ());
		int z = (int) (getX() * vector.getY() - getY() * vector.getX());

		return new Vector(x, y, z);
	}

	// Bestimmmt den eingeschlossenen Winkel der beiden
	public double winkel(Vector vector) {
		double winkel = Math
				.acos(((x * vector.x) + (y * vector.y) + (z * vector.z))
						/ (betrag() * vector.betrag()));
		return Math.toDegrees(winkel);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[ " + String.format("%.2f", x) + "  "
				+ String.format("%.2f", y) + "  " + String.format("%.2f", z)
				+ " ]";
	}
}
