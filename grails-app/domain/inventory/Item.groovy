package inventory

class Item {
	
	String name
	ItemType type
	String description
	Owner owner
	String serial
	String status
	String picture
				
    static constraints = {
		name( blank: false, maxSize: 254 )
		description( blank: false, maxSize: 1024 )
		status( inList: ['useable','repairable','spare parts','junk','sold','dumped','recycled'] )
		picture( blank: true )
    }
}
