package br.com.marceloazvedo.scheduled.service

import br.com.marceloazvedo.scheduled.model.ClientUser

interface ClientService {
    fun create(client: ClientUser): ClientUser
    fun findAll(): List<ClientUser>
}