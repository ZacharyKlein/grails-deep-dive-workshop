package deep.dive

import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import spock.lang.Shared
import spock.lang.Specification

@Integration
class ApiControllerIntegrationSpec extends Specification {

    @Shared
    HttpClient httpClient

    @OnceBefore
    void init() {
        this.httpClient = HttpClient.create(new URL("http://localhost:$serverPort"))
    }

    void "/api/subscribers returns the expected number of subscribers"() {

        given:
        def subscriber = [firstName: "John", lastName: "Smith", email: "john@smith.com"]

        when: "call /api/subscribers endpoint and assert there are 0 subscribers"
        HttpRequest<?> request = HttpRequest.GET('/api/subscribers')
        .contentType(MediaType.APPLICATION_JSON)

        def response = httpClient.toBlocking().exchange(request, Map)
        def responseBody = response.body()
        then:
        println responseBody
        response.status() == HttpStatus.OK
        responseBody['subscribers'].size() == 0

        when: "POST a new subscriber to /newsletter/subscribe"
        request = HttpRequest.POST('/newsletter/subscribe', subscriber)
        response = httpClient.toBlocking().exchange(request, Map)

        then:
        response.status() == HttpStatus.OK

        when: "call /api/subscribers endpoint and assert there is 1 subscriber"
        request = HttpRequest.GET('/api/subscribers')
                .contentType(MediaType.APPLICATION_JSON)

        response = httpClient.toBlocking().exchange(request, Map)
        responseBody = response.body()

        then:
        response.status() == HttpStatus.OK
        responseBody['subscribers'].size() == 1
    }

}