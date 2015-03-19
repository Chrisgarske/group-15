
public class Vector {
	
	private double x;
	private double y;
	private double z;

	public Vector(){
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	
	public Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z; 
	}
	
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}
	
	public double betrag(){
		return Math.sqrt((x*x) + (y*y) + (z*z));
	}

	public Vector addiere(Vector vector){
		double x = getX() + vector.getX();
		double y = getY() + vector.getY();
		double z = getZ() + vector.getZ();
	
		return new Vector(x, y, z);
	}
	
	public Vector multipliziere(double skalar){
		return new Vector((getX() * skalar), (getY() * skalar), (getZ() * skalar));
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

	public double multipliziere(Vector vector){
		double x = getX() * vector.getX();
		double y = getY() * vector.getY();
		double z = getZ() * vector.getZ();
		
		double ergebnis = x + y + z;
		
		return ergebnis;
	}

	public Vector einheitsvektor() {
		
		double x = getX() / betrag();
		double y = getY() / betrag();
		double z = getZ() / betrag();
		
		return new Vector(x, y, z);
	}
	
	public Vector kreuzprodukt(Vector vector){
		int x = (int)(getY() * vector.getZ() - getZ() * vector.getY());
		int y = (int)(getZ() * vector.getX() - getX() * vector.getZ());
		int z = (int)(getX() * vector.getY() - getY() * vector.getX());
		
		return new Vector(x, y, z);
	}
	public double winkel(Vector vector) { 
		 		double winkel = Math.acos(((x * vector.x) + (y * vector.y) + (z * vector.z)) / (betrag() * vector.betrag())); 
		 		return Math.toDegrees(winkel); 
			} 

	@Override
	public String toString() {
		return "[ " + String.format("%.2f", x) + "  " + String.format("%.2f", y) + "  " + String.format("%.2f", z) + " ]";
	}
}
