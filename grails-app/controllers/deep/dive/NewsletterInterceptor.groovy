package deep.dive

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
class NewsletterInterceptor {

    NewsletterInterceptor() {
        match controller: 'newsletter', action: 'confirm'
    }

    boolean after() {
        log.info "After the request!"

        true
    }

}