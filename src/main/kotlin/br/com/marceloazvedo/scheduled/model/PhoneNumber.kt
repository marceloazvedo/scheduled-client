package br.com.marceloazvedo.scheduled.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class PhoneNumber(
        @Id @GeneratedValue
        var id: Long? = null,
        var number: String,
        var description: String
)