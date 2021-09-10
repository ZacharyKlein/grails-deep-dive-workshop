package deep.dive

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
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