package com.example.bankapplication

class BankAccount(var accountHolder:String, var balance: Double) {
    private val transactionHistory= mutableListOf<String>(

    )


    fun deposite(amount:Double){
        balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }

    fun widthdraw(amount:Double){
        if(amount <= balance){
            balance -= amount
            transactionHistory.add("$accountHolder withdrew $$amount")
        }else{
            //we cannot withdraw money
            println("You don't have the funds to withdraw $$amount")
        }
    }

    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")
        for(transaction in transactionHistory){
            println(transaction)
        }
    }

    fun acctBalance(){
        println("Your account balance is: $balance")
    }

}