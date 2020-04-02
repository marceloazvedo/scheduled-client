package br.com.marceloazvedo.scheduled.mapper.dto

import br.com.marceloazvedo.scheduled.dto.CreateClientDTO
import br.com.marceloazvedo.scheduled.model.ClientUser

object ClientMapper {

    fun toEntity(createDTO: CreateClientDTO): ClientUser =
            createDTO.let {
                val client = ClientUser()
                client.email = it.email
                client.password = it.password
                client.name = it.name
                client
            }
}