package deep.dive

interface EmailService {

    void sendEmail(String recipient, EmailType emailType)

    String verifyToken(String token)

}