package deep.dive

import grails.gorm.services.Service

@Service(User)
interface UserDataService {
    User save(String username, String password)
}