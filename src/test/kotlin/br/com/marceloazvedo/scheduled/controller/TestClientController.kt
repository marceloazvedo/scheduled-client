package br.com.marceloazvedo.scheduled.controller

import br.com.marceloazvedo.scheduled.service.ClientService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(ClientController::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestClientController {

    @Autowired
    private lateinit var mvc: MockMvc
    @Autowired
    private lateinit var clientController: ClientController

    @MockBean
    private lateinit var clientService: ClientService

    @BeforeAll
    fun setUp() {
        // configure before all tests run
        // Mock clientService?
    }

    @Test
    fun testCreate() {
        mvc.perform(MockMvcRequestBuilders.post("").contentType(MediaType.APPLICATION_JSON))
                .andExpect(`status`().isOk)
                .andDo(print())
                .andReturn()

    }




}