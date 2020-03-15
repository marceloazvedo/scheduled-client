package br.com.marceloazvedo.scheduled.repository

import br.com.marceloazvedo.scheduled.model.ClientUser
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientUser, Long> {
}