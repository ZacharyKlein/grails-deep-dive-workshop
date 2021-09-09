package deep.dive

import grails.gorm.services.Query
import grails.gorm.services.Service
import grails.gorm.transactions.ReadOnly

@Service(SubscriberEntity)
interface SubscriberEntityDataService {

    @ReadOnly
    List<SubscriberEntity> list(Map args)


    @ReadOnly
    List<SubscriberEntity> findAllByVerified(Boolean verified, Map args)

    @ReadOnly
    SubscriberEntity findByEmail(String email)

    SubscriberEntity save(SubscriberEntity entity)

    void delete(Serializable id)

    void deleteByEmail(String email)

    @Query("update ${SubscriberEntity subscriber} set ${subscriber.verified} = $verified where subscriber.email = $email")
    void updateVerifiedByEmail(String email, Boolean verified)
}