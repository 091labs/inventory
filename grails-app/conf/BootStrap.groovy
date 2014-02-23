import inventory.Owner;
import inventory.Role
import inventory.User
import inventory.UserRole

class BootStrap {

    def init = { servletContext ->		
	  def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
	  def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

	  def testUser = new User(username: 'admin', password: 'admin')
	  testUser.save(flush: true)

	  UserRole.create testUser, adminRole, true

	  assert User.count() == 1
	  assert Role.count() == 2
	  assert UserRole.count() == 1			   
	  
	  (new Owner( name: '091labs' )).save( flush: true );
	  
	  assert Owner.count == 1;
    }
	
    def destroy = {
    }
}
