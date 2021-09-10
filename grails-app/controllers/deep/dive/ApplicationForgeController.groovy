package deep.dive

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.beans.factory.annotation.Autowired

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class ApplicationForgeController {

    @Autowired
    GrailsApplicationForgeClient grailsApplicationForgeClient

    def index() {
        render "Grails Versions: ${grailsApplicationForgeClient.versions()}"
    }
}
