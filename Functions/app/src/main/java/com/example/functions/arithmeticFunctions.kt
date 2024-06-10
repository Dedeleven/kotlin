package com.example.functions

fun main(){
    println("What operation do you want to do? Divide or Addition")
    val ops = readln()
    println("Enter the first value you want to $ops")
    val num1 =  readln().toInt()
    println("Enter the second value")
    val num2 =  readln().toInt()
    when (ops){
        "Divide" -> println("The result is: "+divide(num1, num2))
        "Addition" -> println("The result is: "+add(num1, num2))
        else -> println("Wrong operation")
    }
}

fun add(num1: Int, num2: Int): Int{
    return num1+num2
}

fun divide(num1: Int, num2: Int): Double{
    return num1.toDouble()/num2.toDouble()
}