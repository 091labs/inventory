package inventory



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OwnerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Owner.list(params), model:[ownerInstanceCount: Owner.count()]
    }

    def show(Owner ownerInstance) {
        respond ownerInstance
    }

    def create() {
        respond new Owner(params)
    }

    @Transactional
    def save(Owner ownerInstance) {
        if (ownerInstance == null) {
            notFound()
            return
        }

        if (ownerInstance.hasErrors()) {
            respond ownerInstance.errors, view:'create'
            return
        }

        ownerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ownerInstance.label', default: 'Owner'), ownerInstance.id])
                redirect ownerInstance
            }
            '*' { respond ownerInstance, [status: CREATED] }
        }
    }

    def edit(Owner ownerInstance) {
        respond ownerInstance
    }

    @Transactional
    def update(Owner ownerInstance) {
        if (ownerInstance == null) {
            notFound()
            return
        }

        if (ownerInstance.hasErrors()) {
            respond ownerInstance.errors, view:'edit'
            return
        }

        ownerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Owner.label', default: 'Owner'), ownerInstance.id])
                redirect ownerInstance
            }
            '*'{ respond ownerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Owner ownerInstance) {

        if (ownerInstance == null) {
            notFound()
            return
        }

        ownerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Owner.label', default: 'Owner'), ownerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ownerInstance.label', default: 'Owner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
