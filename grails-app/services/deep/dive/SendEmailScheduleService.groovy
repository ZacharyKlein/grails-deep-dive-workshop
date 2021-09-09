package deep.dive

import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled

@Slf4j
class SendEmailScheduleService {

    static lazyInit = false

    SubscriberEntityDataService subscriberEntityDataService
    EmailService emailService

    @Scheduled(cron = "0 0/1 * * * ?")
    void sendEmailNewsletters() {
        List<SubscriberEntity> subscribers = subscriberEntityDataService.findAllByVerified(true, [:])

        log.info("Sending newsletter to {} verified subscribers", subscribers.size())

        subscribers.each { subscriber ->
            emailService.sendEmail(subscriber.email, EmailType.NEWSLETTER)
        }

    }
}
