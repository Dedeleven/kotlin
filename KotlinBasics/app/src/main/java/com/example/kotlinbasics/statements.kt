package com.example.kotlinbasics

fun main(){
    print("Enter your age: ")
    val age = readln().toInt()
    if (age in 18..40){
        println("Let's drink!")
    }
    else if(age < 16){
      println("No alcohol")
    }
    else{
        println("you can have a beer")
    }
}