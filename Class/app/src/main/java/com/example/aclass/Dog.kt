package com.example.aclass

import javax.crypto.KeyAgreement

// name is only variable
// class Dog (name: String)

// put val to variable make the name/breed a property
// kotlin can directly use the primary constructor to attribute the properties
// val keyword can only be assign at creation while var can be edit later
class Dog (val name: String, val breed: String, var age: Int=0) {

    // initialization
    init{
        bark()
    }

    fun bark(){
        println("$name says: Woof woof")
    }
}