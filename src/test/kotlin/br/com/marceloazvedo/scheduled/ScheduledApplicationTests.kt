package br.com.marceloazvedo.scheduled

import br.com.marceloazvedo.scheduled.repository.ClientRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScheduledApplicationTests {

    @Autowired
    private lateinit var clientRepository: ClientRepository
    @Autowired
    private var passwordEncoder: BCryptPasswordEncoder? = null

    @Test
    fun contextLoads() {
        println(passwordEncoder?.encode("123senha123"))
    }

}
