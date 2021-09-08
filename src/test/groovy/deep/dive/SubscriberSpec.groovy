package deep.dive

import spock.lang.Specification

class SubscriberSpec extends Specification{

    void "test subscriber"() {
        given: "a subscriber"
        def subscriber = new Subscriber()

        when: "firstName property is set"
        subscriber.firstName = "John"

        then: "the toString() method includes 'John'"
        subscriber.toString().contains("John")

    }

    void "Subscriber firstName is optional"() {

        when:
        def subscribe = new Subscriber(firstName: null)

        then:
        subscribe.validate(['firstName'])
    }

    void "Subscriber email must be a valid email address"() {

        when:
        def subscribe = new Subscriber(email: "joesmith")

        then:
        !subscribe.validate(['email'])

        when:
        subscribe = new Subscriber(email: "joe@smith.com")

        then:
        subscribe.validate(['email'])
    }






}
