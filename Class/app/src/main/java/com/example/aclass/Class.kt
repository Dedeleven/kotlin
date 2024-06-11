package com.example.aclass

// data class is a database that holds data information
data class CoffeeDetails(val sugarCount:UInt, val name:String, val size:String, val creamAmount:UInt)

fun main(){

    // creating an object/instance of the class Dog
    var pluto = Dog("Pluto", "labrador", 4)
    println("${pluto.name} is a ${pluto.breed} and is ${pluto.age} years old")

    var myBook = Book()
    println("MyBook author is ${myBook.author} who wrote ${myBook.title} published in ${myBook.yearPublished}")

    val coffeeJulien = CoffeeDetails(0u, "Julien", "small", 0u)

    makeCoffee(coffeeJulien)
}

// define function
fun makeCoffee(coffeeDetails: CoffeeDetails){
    when (coffeeDetails.sugarCount) {
        1u -> {
            println("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}")
        }
        0u -> {
            println("Coffee with no sugar for ${coffeeDetails.name}")
        }
        else -> {
            println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
        }
    }
}