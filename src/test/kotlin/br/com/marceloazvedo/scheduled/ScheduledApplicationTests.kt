package br.com.marceloazvedo.scheduled

import br.com.marceloazvedo.scheduled.repository.ClientRepository
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScheduledApplicationTests {

    @Mock
    private lateinit var clientRepository: ClientRepository
    @Autowired
    private var passwordEncoder: BCryptPasswordEncoder? = null

    @BeforeAll
    fun setUp() {

    }

    @Test
    fun countUsers() {
        Mockito.`when`(clientRepository.count()).thenReturn(122L)

        val usersCount: Long = clientRepository.count()

        Assertions.assertEquals(123L, usersCount)
        Mockito.verify(clientRepository).count()
    }

}
