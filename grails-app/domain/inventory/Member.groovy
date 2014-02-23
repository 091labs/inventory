package inventory

class Member extends Owner {
	
	String telephone
	String email

    static constraints = {				
		telephone( blank: false, maxSize: 32, matches: /[[0-9 \-()\+]*]*/ ) 
		email( blank: false, maxSize: 254, unique: true, email: true )
		///[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\.)+[A-Za-z]{2,4}/
    }
	
	@Override
	public String toString() {
		return String.format("%s %s %s", name, telephone, email );
	}
}
