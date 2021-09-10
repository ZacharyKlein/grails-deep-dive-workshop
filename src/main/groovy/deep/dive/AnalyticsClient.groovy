package deep.dive

import io.micronaut.configuration.rabbitmq.annotation.Binding
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient
import io.micronaut.context.annotation.Requires

@Requires(property = "analytics.enabled", value = 'true')
@RabbitClient("micronaut")
interface AnalyticsClient {

    @Binding("analytics")
    void pushAnalytics(String email)

}