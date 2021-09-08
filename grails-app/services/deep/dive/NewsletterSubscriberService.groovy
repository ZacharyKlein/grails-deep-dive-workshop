package deep.dive

import grails.config.Config
import grails.core.GrailsApplication
import grails.core.support.GrailsConfigurationAware
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.transaction.annotation.Propagation

@Slf4j
class NewsletterSubscriberService { //implements GrailsConfigurationAware {

// Implement setConfiguration when using GrailsConfigurationAware trait
//    @Override
//    void setConfiguration(Config co) {
//        demo = co.getProperty('demo')
//    }

    @Value('${demo}')
    String demo


    //Injecting Grails Application context
    //GrailsApplication grailsApplication

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    List<Subscriber> subscribers() {
        SubscriberEntity.list().collect {
            new Subscriber(firstName:
                    it.firstName, lastName:
                    it.lastName, email:
                    it.email)
        }
    }

    @Transactional
    void save(Subscriber subscriber) {
        log.info "Saving subscriber: [${subscriber.email}]"

        def entity = SubscriberEntity.findByEmail(subscriber.email)

        if (!entity) {
            entity = new SubscriberEntity()
        }

        entity.with {
            //email = subscriber.email
            firstName = subscriber.firstName
            lastName = subscriber.lastName
        }

        if (!entity.validate()) {
            entity.errors.allErrors.each {
                log.warn it.toString()
            }
        } else {
            entity.save()
        }

        //Inject config via grailsApplication.config
        //grailsApplication.config.getProperty("demo", Integer)

        log.info("Value of demo: ${demo}")

        log.info("Saved subscriber with id: ${entity.id}")

    }
}
