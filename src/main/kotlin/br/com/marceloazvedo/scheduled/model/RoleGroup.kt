package br.com.marceloazvedo.scheduled.model

import br.com.marceloazvedo.scheduled.enum.UserType
import javax.persistence.*

@Entity
class RoleGroup {
    @Id @GeneratedValue
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    @Transient
    var permittedResources: List<ApplicationModule>? = null
    @Enumerated(EnumType.STRING)
    var userType: UserType? = null
}