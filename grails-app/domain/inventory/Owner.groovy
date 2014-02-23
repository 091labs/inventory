package inventory;

public class Owner {
	String name
	
	static constraints = {
		name( blank: false, maxSize: 128 )
	}
	
	@Override
	public String toString() {
		return name;
	}
}
