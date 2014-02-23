package inventory



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ItemType.list(params), model:[itemTypeInstanceCount: ItemType.count()]
    }

    def show(ItemType itemTypeInstance) {
        respond itemTypeInstance
    }

    def create() {
        respond new ItemType(params)
    }

    @Transactional
    def save(ItemType itemTypeInstance) {
        if (itemTypeInstance == null) {
            notFound()
            return
        }

        if (itemTypeInstance.hasErrors()) {
            respond itemTypeInstance.errors, view:'create'
            return
        }

        itemTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemTypeInstance.label', default: 'ItemType'), itemTypeInstance.id])
                redirect itemTypeInstance
            }
            '*' { respond itemTypeInstance, [status: CREATED] }
        }
    }

    def edit(ItemType itemTypeInstance) {
        respond itemTypeInstance
    }

    @Transactional
    def update(ItemType itemTypeInstance) {
        if (itemTypeInstance == null) {
            notFound()
            return
        }

        if (itemTypeInstance.hasErrors()) {
            respond itemTypeInstance.errors, view:'edit'
            return
        }

        itemTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ItemType.label', default: 'ItemType'), itemTypeInstance.id])
                redirect itemTypeInstance
            }
            '*'{ respond itemTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ItemType itemTypeInstance) {

        if (itemTypeInstance == null) {
            notFound()
            return
        }

        itemTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ItemType.label', default: 'ItemType'), itemTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemTypeInstance.label', default: 'ItemType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
