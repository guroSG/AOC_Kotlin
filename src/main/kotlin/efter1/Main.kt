package efter1

import java.io.File


//Dag 1 2022

fun main() {
    println(countTopCalories(addCalories((divide((readInput("src/main/kotlin/efter1/inputefter1")))))))
    println(countTopThreeCalories(addCalories((divide((readInput("src/main/kotlin/efter1/inputefter1")))))))
}

fun readInput(path: String) :String {
    return File(path).readText()
}

fun divide(file: String) :ArrayList<ArrayList<Int>>{
    val lines = file.lines()
    val elves = ArrayList<ArrayList<Int>>()
    var food: ArrayList<Int>? = null
    for (n in lines) {
        if (n.isNotBlank()) {
            val cal = n.toInt()
            if (food == null) {
                food = arrayListOf()
            }
            food.add(cal)
        } else if (n.isBlank() && food != null) {
            elves.add(food)
            food = null
        }
    }
    return elves
}


    fun addCalories(elfList: ArrayList<ArrayList<Int>>): ArrayList<Int> {
        val elfTotalCalories = ArrayList<Int>()
        for (e in elfList){
            elfTotalCalories.add(e.sum())
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



