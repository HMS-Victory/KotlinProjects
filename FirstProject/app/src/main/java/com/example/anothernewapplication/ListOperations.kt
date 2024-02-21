package com.example.anothernewapplication

fun main(){


    val fruitsList= mutableListOf<String>("Apple", "Pear", "Orange", "Peach", "Cherry")

    fruitsList.add("Pineapple")
    fruitsList.remove("Cherry")


    if(fruitsList.contains("Pineapple")){
        println("The list contains Pineapple")
    }
}