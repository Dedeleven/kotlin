package com.example.inheritance

class Offspring: SecondaryClass(), Archer, Singer {
    override fun archer() {
        println("Archery skills enhance by Offspring")
    }

    override fun sing() {
        println("Singing skills enhance by Offspring")
    }
}