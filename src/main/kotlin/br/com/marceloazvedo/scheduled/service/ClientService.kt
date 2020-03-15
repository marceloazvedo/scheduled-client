package br.com.marceloazvedo.scheduled.service

import br.com.marceloazvedo.scheduled.model.ClientUser
import br.com.marceloazvedo.scheduled.model.User

interface ClientService {
    fun create(client: ClientUser): ClientUser
}