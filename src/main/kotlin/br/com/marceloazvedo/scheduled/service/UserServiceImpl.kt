package br.com.marceloazvedo.scheduled.service

import br.com.marceloazvedo.scheduled.model.User
import br.com.marceloazvedo.scheduled.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl constructor(private val userRepository: UserRepository): UserService {

    override fun findByEmail(email: String): User = userRepository.findByEmail(email)
}