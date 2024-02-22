package com.nicosandoval.junit.controllers

import com.nicosandoval.junit.services.Operaciones
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controllers {


    lateinit var operaciones: Operaciones

    @Autowired
    constructor(operaciones: Operaciones){
        this.operaciones = operaciones
    }

    @GetMapping("/")
    fun home(): Map<String,String>{

        val hashMap : HashMap<String, String>
                = HashMap<String, String>()

        hashMap.put("Message" , "hola Junit")
        return hashMap

    }



    @GetMapping("/factorial")
    fun factorial(@RequestParam numero: Long): Map<String,String>{
        val hashMap : HashMap<String, String>
                = HashMap<String, String>()

        //adding elements to the hashMap using put() function
        hashMap.put("Message" , "Result: " + operaciones.factorial(numero))
        return hashMap
    }
}