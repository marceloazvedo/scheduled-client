package br.com.marceloazvedo.scheduled.controller

import br.com.marceloazvedo.scheduled.dto.CreateClientDTO
import br.com.marceloazvedo.scheduled.mapper.dto.ClientMapper
import br.com.marceloazvedo.scheduled.model.ClientUser
import br.com.marceloazvedo.scheduled.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun create(@RequestBody @Valid createDTO: CreateClientDTO) : ResponseEntity<ClientUser> =
        ResponseEntity(clientService.create(ClientMapper.toEntity(createDTO)), HttpStatus.CREATED)


    @Secured("ROLE_ADMIN")
    @GetMapping
    fun list(): List<ClientUser> = clientService.findAll()

}