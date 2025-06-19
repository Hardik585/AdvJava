
public class User {
	int id;
	String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name ; 
	}
	public void print() {
		System.out.println("Hi my name is : "+ name );
	}
}
