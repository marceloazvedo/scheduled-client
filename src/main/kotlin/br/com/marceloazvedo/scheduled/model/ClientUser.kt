package br.com.marceloazvedo.scheduled.model

import br.com.marceloazvedo.scheduled.enum.UserType
import javax.persistence.*

@Entity
@PrimaryKeyJoinColumn(name = "id")
class ClientUser: User() {
    @OneToMany(cascade = [CascadeType.ALL])
    var phoneNumbers: List<PhoneNumber>? = null

    init {
        this.userType = UserType.CLIENT
    }

}