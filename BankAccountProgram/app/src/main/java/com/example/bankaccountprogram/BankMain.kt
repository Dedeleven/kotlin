package com.example.bankaccountprogram

fun main(){
    val juliensBankAccount = BankAccount("Julien Dedelley", 1600.45)

    juliensBankAccount.deposit(200.0)
    juliensBankAccount.withdraw(300.0)
    juliensBankAccount.withdraw(500.0)
    juliensBankAccount.deposit(3000.0)
    juliensBankAccount.withdraw(10000.15)

    juliensBankAccount.displayTransactionHistory()
    println("${juliensBankAccount.accountHolder} balance is $${juliensBankAccount.acctBalance()}")
}