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


}
