package deep.dive

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Slf4j

@Slf4j
class NewsletterController {

    NewsletterSubscriberService newsletterSubscriberService
    SubscriberEntityDataService subscriberEntityDataService

    static allowedMethods = [index: "GET", subscribe: "POST"]

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index() {

        [message: "Welcome to our Newsletter!"]
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def subscribe(Subscriber subscriber) {

        newsletterSubscriberService.save(subscriber)

        [subscriber: subscriber]
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def confirm(String token) {
        String email = newsletterSubscriberService.verifyByEmail(token)

        [email: email]
    }

    @Secured("ROLE_ADMIN")
    def dashboard() {
        List<SubscriberEntity> subscribers = subscriberEntityDataService.list([:])
        List<SubscriberEntity> verifiedSubscribers = subscriberEntityDataService.findAllByVerified(true, [:])

        [subscribers: subscribers, verifiedSubscribers: verifiedSubscribers]
    }



}
