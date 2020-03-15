package br.com.marceloazvedo.scheduled.service

import br.com.marceloazvedo.scheduled.model.User
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
        val user = User()
        user.email = "user@email.com"
        user.password = "123123123"
        user.id = 1L
        if (user.id == null)
            throw UsernameNotFoundException(email)
        return SpringUser(user.email, passwordEncoder.encode(user.password), emptyList())
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder? {
        passwordEncoder = BCryptPasswordEncoder()
        return passwordEncoder
    }

}