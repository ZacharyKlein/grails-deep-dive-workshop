package deep.dive

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.util.logging.Slf4j

@Slf4j
class EmailComposer implements GrailsConfigurationAware {

    String serverUrl

    String composeWelcomeEmail(String email) {

        String token = Base64.getEncoder().encodeToString(email.getBytes())

        String body = """
Thank you for subscribing. 
Please confirm your email address by clicking this link: ${serverUrl}/newsletter/confirm?token=${token}
      """

        log.info("Email body: [${body}]")

        body
    }


    String composeNewsletterEmail(String recipient) {
        "Hello ${recipient}! We hope you enjoy the newsletter"
    }


    @Override
    void setConfiguration(Config co) {
        serverUrl = co.getProperty("grails.serverUrl")
    }
}
