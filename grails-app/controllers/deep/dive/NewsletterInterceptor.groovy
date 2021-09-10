package deep.dive

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
@CompileStatic
class NewsletterInterceptor {

    @Autowired
    AnalyticsClient analyticsClient

    NewsletterInterceptor() {
        match controller: 'newsletter', action: 'confirm'
    }

    boolean after() {
        log.info "After the request!"

        String email = (String) model.email

        analyticsClient.pushAnalytics(email)
        true
    }

}