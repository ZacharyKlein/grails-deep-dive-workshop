package deep.dive

import grails.config.Config
import grails.core.GrailsApplication
import grails.core.support.GrailsConfigurationAware
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value

@Slf4j
class NewsletterSubscriberService { //implements GrailsConfigurationAware {

// Implement setConfiguration when using GrailsConfigurationAware trait
//    @Override
//    void setConfiguration(Config co) {
//        demo = co.getProperty('demo')
//    }

    @Value('${demo}')
    String demo

    //TODO: Replace this with persistence!
    private List<Subscriber> subscriberStore = []

    //Injecting Grails Application context
    //GrailsApplication grailsApplication

    List<Subscriber> subscribers() {
        subscriberStore
    }

    void save(Subscriber subscriber) {
        log.info "Saving subscriber: [${subscriber.email}]"

        subscriberStore << subscriber

        //Inject config via grailsApplication.config
        //grailsApplication.config.getProperty("demo", Integer)

        log.info("Value of demo: ${demo}")

        //TODO: Implement subscriber saving

    }

}
