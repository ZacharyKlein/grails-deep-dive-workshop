package deep.dive

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class ApiControllerSpec extends Specification implements ControllerUnitTest<ApiController> {


    @Unroll("/api/subscribers does not respond to #httpVerb")
    void "/api/subscribers only responds to GET"() {

        when:
        request.method = httpVerb
        controller.subscribers()

        then:
        response.status == 405

        where:
        httpVerb << ['POST', 'PUT', 'PATCH', 'DELETE']

    }

    void "/api/subscribers responds to GET"() {
        when:
        request.method = 'GET'
        controller.newsletterSubscriberService = Mock(NewsletterSubscriberService)
        controller.subscribers()

        then:
        response.status == 200
    }





}

