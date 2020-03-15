package br.com.marceloazvedo.scheduled.service

import br.com.marceloazvedo.scheduled.model.User

interface UserService {
    fun findByEmail(email: String): User
}