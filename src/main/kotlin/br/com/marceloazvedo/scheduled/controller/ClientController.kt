package br.com.marceloazvedo.scheduled.controller

import br.com.marceloazvedo.scheduled.dto.CreateClientDTO
import br.com.marceloazvedo.scheduled.model.ClientUser
import br.com.marceloazvedo.scheduled.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/clients")
class ClientController {

    @Autowired
    private lateinit var clientService: ClientService

    @PostMapping
    fun create(@RequestBody @Valid clientDTO: CreateClientDTO) {
        val client: ClientUser = ClientUser()
        client.name = clientDTO.name
        client.email = clientDTO.email
        client.password = clientDTO.password
        clientService.create(client)
    }

}