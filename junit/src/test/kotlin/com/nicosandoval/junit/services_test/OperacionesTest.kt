package com.nicosandoval.junit.services_test

import com.nicosandoval.junit.services.MisOperaciones
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.springframework.beans.factory.annotation.Autowired

class OperacionesTest {


 private val operacionesTest = MisOperaciones()

    @BeforeEach
    fun setup(){
        operacionesTest
    }

    @Test
    fun factorialTest(){

        Assertions.assertEquals(operacionesTest.factorial(4), 24)
        Assertions.assertEquals(operacionesTest.factorial(1), 1)
        Assertions.assertEquals(operacionesTest.factorial(5), 120)
        Assertions.assertEquals(operacionesTest.factorial(0), 1)

    }

    @Test
    fun factorialFailTest(){

        val executable1 = Executable {operacionesTest.factorial(-1) }
        val executable2 = Executable {operacionesTest.factorial(-10) }
        val executable3 = Executable {operacionesTest.factorial(24) }

        Assertions.assertThrows(
            ArithmeticException::class.java,
             executable1, "No se pueden ingresar numeros negativos"
        )

        Assertions.assertThrows(
            ArithmeticException::class.java,
             executable2, "No se pueden ingresar numeros negativos"
        )

        Assertions.assertThrows(
            IllegalArgumentException::class.java,
             executable3, "No se pueden ingresar numeros mayores de 23"
        )


    }
}