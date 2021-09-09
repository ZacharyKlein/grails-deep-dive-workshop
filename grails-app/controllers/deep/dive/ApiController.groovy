package deep.dive

import grails.converters.JSON

class ApiController {

    NewsletterSubscriberService newsletterSubscriberService

    static allowedMethods = [
            subscribers: ['GET']
    ]

    def subscribers() {
        [subscribers: newsletterSubscriberService.subscribers()]
    }

    def verifiedSubscribers() {
        [subscribers: newsletterSubscriberService.verifiedSubscribers()]
    }

}