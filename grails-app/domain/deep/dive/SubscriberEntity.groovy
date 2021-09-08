package deep.dive

class SubscriberEntity {

    String email
    String firstName
    String lastName

    static constraints = {
        email nullable: false, blank: false, email: true
        firstName nullable: true
        lastName nullable: false, blank: false
    }

    static mapping = {
        table "subscriber"
    }
}
