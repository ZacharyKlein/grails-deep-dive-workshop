package deep.dive


import grails.gorm.services.Service
import grails.gorm.transactions.ReadOnly

@Service(SubscriberEntity)
interface SubscriberEntityDataService {

    @ReadOnly
    List<SubscriberEntity> list(Map args)

    @ReadOnly
    SubscriberEntity findByEmail(String email)

    SubscriberEntity save(SubscriberEntity entity)

    void delete(Serializable id)

    void deleteByEmail(String email)
}