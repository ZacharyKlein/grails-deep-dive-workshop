package deep.dive

import grails.converters.JSON
import groovy.util.logging.Slf4j

@Slf4j
class NewsletterController {

    NewsletterSubscriberService newsletterSubscriberService

    static allowedMethods = [index: "GET", subscribe: "POST"]

    def index() {
        [:]
    }


    def subscribe(Subscriber subscriber) {

        newsletterSubscriberService.save(subscriber)

        [firstName: subscriber.firstName]
    }
}
