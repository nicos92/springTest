package com.nicosandoval.junit.controllers_test

import com.nicosandoval.junit.services.MisOperaciones
import com.nicosandoval.junit.services.Operaciones
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatcher
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient

/*@EnableAutoConfiguration(
    exclude = [
        DataSourceAutoConfiguration::class,
        DataSourceTransactionManagerAutoConfiguration::class,
        HibernateJpaAutoConfiguration::class
    ]
)*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ControllersTest() {

   /*@MockBean
     val operacionesMock = MisOperaciones()



    @BeforeEach
    fun setup(){
        //Mockito.`when`(operacionesMock.factorial(ArgumentMatchers.anyLong())).thenReturn(0)
        BDDMockito.given(operacionesMock.factorial(ArgumentMatchers.anyLong())).willReturn(0);
    }*/



    @Test
    fun factorialControllerTest(@Autowired
                                 webTestClient: WebTestClient){

        webTestClient.get()
            .uri("/factorial?numero=10")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.Message")
            .isEqualTo("Result: 3628800")
    }




}