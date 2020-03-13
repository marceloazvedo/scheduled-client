package br.com.marceloazvedo.scheduled.model

import javax.persistence.*

@Entity
@PrimaryKeyJoinColumn(name = "id")
class ClientUser: User() {
    @OneToMany(cascade = [CascadeType.ALL])
    var phoneNumbers: List<PhoneNumber>? = null
}