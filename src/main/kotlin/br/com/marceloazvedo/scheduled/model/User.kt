package br.com.marceloazvedo.scheduled.model

import br.com.marceloazvedo.scheduled.enum.UserType
import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class User {
    @Id @GeneratedValue
    var id: Long? = null
    var name: String? = null
    @Column(unique = true, nullable = false)
    var email: String? = null
    var password: String? = null
    var changePasswordNextAccess: Boolean? = null
    @ManyToOne
    var roleGroup: RoleGroup? = null
    @Enumerated(EnumType.STRING)
    var userType: UserType? = null
    var status: Boolean? = null
    @Temporal(TemporalType.TIMESTAMP)
    var createAt: Date? = null
    @Temporal(TemporalType.TIMESTAMP)
    var updateAt: Date? = null
}