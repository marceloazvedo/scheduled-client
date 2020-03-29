package br.com.marceloazvedo.scheduled

import br.com.marceloazvedo.scheduled.repository.ClientRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScheduledApplicationTests {

    @Autowired
    private lateinit var clientRepository: ClientRepository

    @Test
    fun contextLoads() {
    }

}
