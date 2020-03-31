package br.com.marceloazvedo.scheduled.service

import br.com.marceloazvedo.scheduled.model.ClientUser
import br.com.marceloazvedo.scheduled.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl : ClientService {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    private lateinit var clientRepository: ClientRepository

    override fun create(client: ClientUser): ClientUser {
        client.password = passwordEncoder.encode(client.password)
        return clientRepository.save(client)
    }

    override fun findAll(): List<ClientUser> {
        return clientRepository.findAll()
    }
}