package com.nicosandoval.junit.services

import org.springframework.stereotype.Service

@Service
class MisOperaciones : Operaciones {
    override fun factorial(num: Long): Long {

        if (num < 0){
            throw ArithmeticException()
        }

        if (num > 23){
            throw IllegalArgumentException()
        }


        if ( num.toInt() == 1 || num.toInt() == 0) return 1
       return num * factorial(num-1)
    }
}