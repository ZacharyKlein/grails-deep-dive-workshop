package deep.dive

import grails.converters.JSON
import groovy.util.logging.Slf4j

@Slf4j
class NewsletterController {

    static allowedMethods = [index: "GET", subscribe: "POST"]

    def index() {
        [:]
    }


    def subscribe(Subscriber subscriber) {

        log.info(subscriber.toString())

        render subscriber as JSON
    }
}
