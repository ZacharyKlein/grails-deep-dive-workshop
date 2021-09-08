package deep.dive

import grails.converters.JSON
import groovy.util.logging.Slf4j

@Slf4j
class NewsletterController {

    NewsletterSubscriberService newsletterSubscriberService

    static allowedMethods = [index: "GET", subscribe: "POST"]

    def index() {

        [message: "Welcome to our Newsletter!"]
    }


    def subscribe(Subscriber subscriber) {

        newsletterSubscriberService.save(subscriber)

        [subscriber: subscriber]
    }
}
