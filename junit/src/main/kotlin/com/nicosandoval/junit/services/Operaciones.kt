package com.nicosandoval.junit.services

import org.springframework.stereotype.Service

@Service
interface Operaciones {
    fun factorial(num: Long): Long
}