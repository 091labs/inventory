package inventory;

public class ItemType {
	String type
	
	static constraints = {
		type( blank: false, maxSize: 64 )
	}
	
	@Override
	public String toString() {
		return type
	}
}
