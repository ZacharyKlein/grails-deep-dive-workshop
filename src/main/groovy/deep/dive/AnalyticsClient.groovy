package deep.dive

import io.micronaut.configuration.rabbitmq.annotation.Binding
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient

@RabbitClient("micronaut")
interface AnalyticsClient {

    @Binding("analytics")
    void pushAnalytics(String email)

}