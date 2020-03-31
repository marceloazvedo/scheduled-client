package br.com.marceloazvedo.scheduled.controller

import br.com.marceloazvedo.scheduled.dto.CreateClientDTO
import br.com.marceloazvedo.scheduled.model.ClientUser
import br.com.marceloazvedo.scheduled.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/admin/clients")
class ClientController {

    @Autowired
    private lateinit var clientService: ClientService

    @Secured("ROLE_ADMIN")
    @PostMapping
    fun create(@RequestBody @Valid clientDTO: CreateClientDTO) {
        val client = ClientUser()
        client.name = clientDTO.name
        client.email = clientDTO.email
        client.password = clientDTO.password
        clientService.create(client)
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    fun list(): List<ClientUser> = clientService.findAll()

}