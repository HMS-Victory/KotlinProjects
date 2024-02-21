

fun main(){
    val list= mutableListOf<Int>(1,2,3,4,5)


    for(index in 0 until list.size){
        list[index]=list[index]*2
    }

    println(list)
}