package deep.dive

import groovy.util.logging.Slf4j
import org.grails.datastore.mapping.engine.event.PostInsertEvent

@Slf4j
class SubscriberEntityListenerService {

    SimpleEmailService simpleEmailService

    @grails.events.annotation.Subscriber
    void afterInsert(PostInsertEvent event) {
        if (event.entityAccess.getEntity() instanceof SubscriberEntity) {
            String email = event.entityAccess.getPropertyValue("email")
            log.info("Received asynchronous subscription with email: ${email}")

            simpleEmailService.sendEmail(email, EmailType.WELCOME)
        }
    }

}
