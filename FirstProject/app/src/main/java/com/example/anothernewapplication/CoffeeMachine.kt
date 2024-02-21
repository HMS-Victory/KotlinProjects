package com.example.anothernewapplication

fun main(){
//    Immutable list
//    val shoppingList=listOf("Processor", "RAM", "Graphics Card", "SSD")

    val shoppingList=mutableListOf("Processor", "RAM", "Graphics Card", "SSD")

    // adding items to lists
    shoppingList.add("Cooling System")
    shoppingList.remove("Cooling System")
    shoppingList.add("Graphics Card RTX 4090")

    println(shoppingList)
    // arrays are still zero indexed in kotlin
    shoppingList.removeAt(index=1)
    shoppingList.add(index= 2,element="RAM" )
    println(shoppingList)

    shoppingList[3]="Graphics Card RX 7800XT"
    println(shoppingList)
    shoppingList.set(1, "Water Cooling")
    println(shoppingList)

    val hasRam=shoppingList.contains("RAM")
    if(hasRam){
        println("Has RAM in the list")
    }else{
        println("Has no RAM in the list")
    }

    //basically a foreach
    //but a for in loop is more versatile because
    //you can technically repeat  until ANY variable is complete
    //not just until you are through an array, and it also gives you
    // a variable to use for array items automatically
    for(index in 0 until shoppingList.size){
        println("item ${shoppingList[index]} is at index $index")
//        if(item=="RAM"){
//            shoppingList.removeLast()
//            break
//        }
    }

//    val coffeeForDenis=CoffeeDetails(sugarCount=0, name="denis", size= "xxl", creamAmount=0)
//    makeCoffee(coffeeForDenis)
}







//data class CoffeeDetails(
//    val sugarCount: Int,
//    val name: String,
//    val size:String,
//    val creamAmount: Int
//)
//
//fun askCoffeeDetails(){
//    println("Please enter your name: ")
//    val name: String=readln()
//    println("Please enter how many spoons of sugar you want in your coffee: ")
//    val spoonCount: Int=readln().toInt()
//}
//
//fun makeCoffee(coffeeDetails: CoffeeDetails){
//    if(coffeeDetails.sugarCount==1){
//        return println("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}.")
//    }else if(coffeeDetails.sugarCount > 1){
//        println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}.")
//    }else{
//        println("Coffee with no sugar for ${coffeeDetails.name}.")
//    }
//}