package deep.dive

import grails.validation.Validateable
import groovy.transform.ToString

@ToString
class Subscriber implements Validateable {

    String email
    String firstName
    String lastName

    static constraints = {
        email nullable: false, blank: false, email: true
        firstName nullable: true
        lastName nullable: false, blank: false
    }

}
