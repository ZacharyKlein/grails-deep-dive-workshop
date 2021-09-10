package deep.dive

import grails.gorm.services.Service

@Service(Role)
interface RoleDataService {
    Role save(String authority)

    Integer count()
}