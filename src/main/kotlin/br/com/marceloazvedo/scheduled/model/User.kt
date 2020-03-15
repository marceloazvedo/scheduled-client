package br.com.marceloazvedo.scheduled.model

import br.com.marceloazvedo.scheduled.enum.UserType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
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
    var changePasswordNextAccess: Boolean? = false
    @ManyToOne
    var roleGroup: RoleGroup? = null
    @Enumerated(EnumType.STRING)
    var userType: UserType? = null
    var status: Boolean? = true
    @CreatedDate
    var createAt: Date? = null
    @LastModifiedDate
    var updateAt: Date? = null
}