package deep.dive

class BootStrap {

    UserDataService userDataService
    RoleDataService roleDataService
    UserRoleDataService userRoleDataService


    def init = { servletContext ->

        if (userDataService.count() == 0) {
            Role roleAdmin = roleDataService.save("ROLE_ADMIN")
            User admin = userDataService.save("admin", "admin")

            userRoleDataService.save(admin, roleAdmin)
        }

    }
    def destroy = {
    }
}
