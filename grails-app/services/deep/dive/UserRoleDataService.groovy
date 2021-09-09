package deep.dive

import grails.gorm.services.Service

@Service(UserRole)
interface UserRoleDataService {
    UserRole save(User user, Role role)
}