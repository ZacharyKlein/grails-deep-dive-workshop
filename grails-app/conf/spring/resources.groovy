import deep.dive.AmazonSimpleEmailService
import deep.dive.UserPasswordEncoderListener
import deep.dive.EmailComposer
import deep.dive.SimpleEmailService
import grails.util.Environment

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)

    emailComposer(EmailComposer)

    switch (Environment.current) {
        case Environment.PRODUCTION:
            emailService(AmazonSimpleEmailService)
            break
        default:
            emailService(SimpleEmailService)
    }

}
