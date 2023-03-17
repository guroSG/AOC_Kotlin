package uppgift1

import java.io.File


//Dag 1 2022

fun main(){
    val elvesFood = divide((readInput("src/main/kotlin/uppgift1/input.txt")))
    println(countTopCalories(addCalories(elvesFood)))
    println(countTopThreeCalories(addCalories(elvesFood)))

}

fun readInput(path: String) :String {
    return File(path).readText()
}

fun divide(file: String) :ArrayList<Elf>{
    val lines = file.lines()
    val elves = ArrayList<Elf>()
    var food: ArrayList<Int>? = null
    for (n in lines) {
        if (n.isNotBlank()) {
            val cal = n.toInt()
            if (food == null) {
                food = arrayListOf()
            }
            food.add(cal)
        } else if (n.isBlank() && food != null) {
            val elf = Elf(food)
            elves.add(elf)
            food = null
        }
    }
    return elves
}

fun addCalories(elfList: ArrayList<Elf>): ArrayList<Int> {
    val elfTotalCalories = ArrayList<Int>()
    for (e in elfList){
        elfTotalCalories.add(e.foodCalories.sum())
    }
    return elfTotalCalories
}

fun countTopCalories(calorieList: ArrayList<Int>): Int{
calorieList.sortDescending()
    return calorieList[0]
}

fun countTopThreeCalories(calorieList: ArrayList<Int>): Int{
    calorieList.sortDescending()
    return calorieList[0]+calorieList[1]+calorieList[2]
}


class Elf(val foodCalories: MutableList<Int>)


