package br.com.marceloazvedo.scheduled.controller

import br.com.marceloazvedo.scheduled.dto.CreateUserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @PostMapping
    fun create(@RequestBody @Valid user: CreateUserDTO) {
        user.password = passwordEncoder.encode(user.password)
    }

}