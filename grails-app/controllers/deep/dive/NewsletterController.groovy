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


    def confirm(String token) {
        String email = token //decode email from token

        newsletterSubscriberService.verifyByEmail(email)

        [email: email]
    }

}
