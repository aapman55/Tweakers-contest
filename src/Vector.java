/**
 * Vector class.
 * Perform basic operations on a vector
 * 
 * @author ZL
 *
 */
public class Vector {
	private double x,y,z;
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Make the vector of length 1
	 */
	public Vector normalise(){
		double lengte = length();
		x = x/lengte;
		y = y/lengte;
		z = z/lengte;
		return this;
	}
	
	/**
	 * Calculate the length of the vector
	 * @return
	 */
	public double length(){
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));
	}
	
	/**
	 * Scale vector uniformly
	 * @param factor
	 */
	public Vector scale(double factor){
		scale(factor, factor, factor);
		return this;
	}
	
	/**
	 * Scale each component of the vector 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector scale(double x, double y, double z){
		this.x *=x;
		this.y *=y;
		this.z *=z;
		return this;
	}
	
	/**
	 * Add another vector to this vector
	 * @param other
	 */
	public Vector add(Vector other){
		add(other.x, other.y, other.z);
		return this;
	}
	
	/**
	 * Add scalars to this vector
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector add(double x, double y, double z){
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	/**
	 * Instantiate a new object with the same properties
	 * @return
	 */
	public Vector copy(){
		return new Vector(x, y, z);
	}
	
	/**
	 * print the vector
	 */
	public String toString(){
		return "x: "+x+", y: "+y+", z: "+z;
	}
}
