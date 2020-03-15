package br.com.marceloazvedo.scheduled.repository

import br.com.marceloazvedo.scheduled.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User
}