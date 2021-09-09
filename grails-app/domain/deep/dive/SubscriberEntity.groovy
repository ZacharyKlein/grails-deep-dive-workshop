package deep.dive

class SubscriberEntity {

    String email
    String firstName
    String lastName

    Boolean verified = false

    static constraints = {
        email nullable: false, blank: false, email: true
        firstName nullable: true
        lastName nullable: false, blank: false
    }

    static mapping = {
        table "subscriber"
    }
}
