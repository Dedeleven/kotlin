package com.example.listandloop

fun main(){

    // Immutable list
    val shoppingList = listOf("Processor", "RAM", "Graphic Card", "SSD")

    // Mutable list
    val shoppingList2 = mutableListOf("Processor", "RAM", "Graphic Card", "SSD")
    /*
    // adding item
    shoppingList2.add("Cooling system")

    // remove item
    shoppingList2.remove("Graphic Card")

    //
    shoppingList2.add("RTX 4070")

    // remove at index
    shoppingList2.removeAt(1)

    // add at specific position
    shoppingList2.add(3,"RAM")

    println(shoppingList2)

    // acceess specific element
    println(shoppingList2[3])

    // change specific element
    shoppingList2[4] = "RX 7800XT"
    // or
    shoppingList2.set(4, "RTX 4070")

    println(shoppingList2)
    */
    // for loop
    // through items
    for (item in shoppingList2){
        println(item)
        if (item=="RAM"){
            break
        }
    }

    // through index
    for (item in 0 until shoppingList2.size){
        println(shoppingList2[item])
    }

    for (index in 0 until 10){
        println(index)
    }
}