package com.example.functions

fun main(){
    // Call function
    makeCoffee(1)
    makeCoffee(2)
    makeCoffee(3)
    makeCoffee(4)
}

// define function
fun makeCoffee(sugarCount: Int){
    if (sugarCount==1) {
        println("Coffee with $sugarCount spoon of sugar")
    }
    else{
        println("Coffee with $sugarCount spoons of sugar")
    }
}