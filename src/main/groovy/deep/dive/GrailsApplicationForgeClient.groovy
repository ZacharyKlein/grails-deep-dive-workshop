package deep.dive

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://start.grails.org")
interface GrailsApplicationForgeClient {

    @Get("/versions")
    List<String> versions()

}