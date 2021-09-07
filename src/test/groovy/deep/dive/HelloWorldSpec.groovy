package deep.dive

import spock.lang.Specification

class HelloWorldSpec extends Specification {

    void "test hello world"() {

        given:
        def groovy = new HelloGroovy(name: "Grails Deep Dive")

        when:
        groovy.playWithCollections()

        then:
        true


    }
}
