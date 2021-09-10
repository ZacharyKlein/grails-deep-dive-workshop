package deep.dive

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

import javax.annotation.Nullable

@Slf4j
@CompileStatic
class NewsletterInterceptor {

    @Autowired
    @Nullable
    AnalyticsClient analyticsClient

    NewsletterInterceptor() {
        match controller: 'newsletter', action: 'confirm'
    }

    boolean after() {
        log.info "After the request!"

        if(analyticsClient) {
            String email = (String) model.email

            analyticsClient.pushAnalytics(email)
        } else {
            log.warn "Analytics not available"
        }

        true
    }

}