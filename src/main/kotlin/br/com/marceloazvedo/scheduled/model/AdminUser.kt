package br.com.marceloazvedo.scheduled.model

import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "id")
class AdminUser: User()