package com.example.bankapplication

fun main(){

    val denisesBankAccount=BankAccount(accountHolder = "Denis Panjuta", balance=12.33)

    denisesBankAccount.deposite(amount=200.00)
    denisesBankAccount.widthdraw(amount=13.20)
    denisesBankAccount.deposite(amount=3000.00)
    denisesBankAccount.deposite(amount=2000.00)
    denisesBankAccount.widthdraw(amount=3333.15)

    denisesBankAccount.displayTransactionHistory()
    denisesBankAccount.acctBalance()
}