package com.example.functions

fun main(){
    // Call function
    println("What's your name")
    val name = readln()
    println("How much sugar do you want?")
    val numberOfSugar = readln().toUInt()
    makeCoffee(numberOfSugar, name)
}

// define function
fun makeCoffee(sugarCount: UInt, name: String){
    when (sugarCount) {
        1u -> {
            println("Coffee with $sugarCount spoon of sugar for $name")
        }
        0u -> {
            println("Coffee with no sugar for $name")
        }
        else -> {
            println("Coffee with $sugarCount spoons of sugar for $name")
        }
    }
}