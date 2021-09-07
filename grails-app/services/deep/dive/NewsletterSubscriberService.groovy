package deep.dive

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value

@Slf4j
class NewsletterSubscriberService {


    @Value('${demo}')
    String demo


    void save(Subscriber subscriber) {
        log.info "Saving subscriber: [${subscriber.email}]"

        log.info("Value of demo: ${demo}")

        //TODO

    }

}
