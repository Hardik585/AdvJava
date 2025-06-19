/**
 * @author Hardik
 */
public class User {
	int id;
	String name;

	/**
	 * variable constructor
	 */
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Get method to get the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Get method to get the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * print method
	 */
	public void print() {
		System.out.println("Hi my name is : " + name);
	}
}
