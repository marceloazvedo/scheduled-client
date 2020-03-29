package br.com.marceloazvedo.scheduled.service

import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.security.core.userdetails.User as SpringUser

@Component
class UserDetailsServiceImpl(private val userService: UserService) : UserDetailsService {

    companion object {
        private lateinit var passwordEncoder: BCryptPasswordEncoder
    }

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userService.findByEmail(email)
        println("User: ${user.email} with id: ${user.id}")
        if (user.id == null)
            throw UsernameNotFoundException(email)
        return SpringUser(user.email, user.password, emptyList())
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder? {
        passwordEncoder = BCryptPasswordEncoder()
        return passwordEncoder
    }

}