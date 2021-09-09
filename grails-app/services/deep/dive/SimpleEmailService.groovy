package deep.dive

import groovy.util.logging.Slf4j

@Slf4j
class SimpleEmailService implements EmailService {

    EmailComposer emailComposer

    void sendEmail(String recipient, EmailType emailType) {

        log.info("Sending email to recipient ${recipient}: [${emailType}]")
        String emailBody
        switch (emailType) {
            case EmailType.WELCOME:
                emailBody = emailComposer.composeWelcomeEmail(recipient)
                break
            default:
                emailBody = null
        }

        log.info("Body: [${emailBody}]")
    }

    String verifyToken(String token) {
        return new String(Base64.getDecoder().decode(token))
    }
}
