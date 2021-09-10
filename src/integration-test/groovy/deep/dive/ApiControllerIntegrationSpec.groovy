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

    @Shared
    SubscriberEntityDataService subscriberEntityDataService

    @OnceBefore
    void init() {
        this.httpClient = HttpClient.create(new URL("http://localhost:$serverPort"))
    }

    void "/api/subscribers returns the expected number of subscribers"() {

        given:
        def subscriber = [firstName: "John", lastName: "Smith", email: "john@smith.com"]
        String user = "admin"
        String password = "admin"

        when: "call /api/subscribers endpoint and assert there are 0 subscribers"
        HttpRequest<?> request = HttpRequest.GET('/api/subscribers')
                .basicAuth(user, password)
                .contentType(MediaType.APPLICATION_JSON)

        def response = httpClient.toBlocking().exchange(request, Map)
        def responseBody = response.body()
        then:
        println responseBody
        response.status() == HttpStatus.OK
        responseBody['subscribers'].size() == 0

        when: "POST a new subscriber to /newsletter/subscribe"
        request = HttpRequest.POST('/newsletter/subscribe', subscriber)
                .basicAuth(user, password)
        response = httpClient.toBlocking().exchange(request, String)

        then:
        response.status() == HttpStatus.OK
        response.body().contains("<h1>John Smith, thanks for subscribing. Please check your email</h1>")

        when: "call /api/subscribers endpoint and assert there is 1 subscriber"
        request = HttpRequest.GET('/api/subscribers')
                .basicAuth(user, password)
                .contentType(MediaType.APPLICATION_JSON)

        response = httpClient.toBlocking().exchange(request, Map)
        responseBody = response.body()

        then:
        response.status() == HttpStatus.OK
        responseBody['subscribers'].size() == 1


        cleanup:
        subscriberEntityDataService.deleteByEmail(subscriber['email'])

    }

}
