package efter3

import java.io.File

/*2022 Dag 5
// använt repo: https://github.com/aormsby/advent-of-code-2022/blob/main/src/main/kotlin/solutions/Day5SupplyStacks.kt
 */

fun main (){
    val input = readInput("src/main/kotlin/uppgift3/input3.txt")
    val sortedStacks1 = executeProcedures9000(getRearrangementProcedure(input), createStacks(input))
    val sortedStacks2 = executeProcedures9001(getRearrangementProcedure(input), createStacks(input))
    println(findTopBoxes(sortedStacks1))
    println(findTopBoxes(sortedStacks2))
}

fun findTopBoxes(stacks: List<ArrayList<Char>>): String{
    var topBoxes = ""
    for (s in stacks) {
        topBoxes += s[0]
    }
    return topBoxes
}

fun executeProcedures9000(procedures: List<List<Int>>, stacks: List<ArrayList<Char>>): List<ArrayList<Char>>{
    for (p in procedures) {
        for (i in 0 until p[0]) {
            val box = stacks[p[1]- 1].removeAt(0)
            stacks[p[2] - 1].add(0, box)
        }
    }
    return stacks
}

fun executeProcedures9001(procedures: List<List<Int>>, stacks: List<ArrayList<Char>>): List<ArrayList<Char>>{
    for (p in procedures) {
        val boxList = ArrayList<Char>()
        for (i in 0 until p[0]) {
            val box = stacks[p[1] - 1].removeAt(0)
            boxList.add(box)
        }
        boxList.reverse()
        for ((index) in boxList.withIndex()) {
            stacks[p[2] - 1].add(0, boxList[index])
        }
    }
    return stacks
}


fun createStacks(file: String): List<ArrayList<Char>> {
    val lines = file.lines()
    val stacks = List(9) { ArrayList<Char>() }

    for (l in lines) {
        if (!l.contains('[')) break
        for ((stackIndex, i) in (1..l.lastIndex step 4).withIndex()) {
            if (l[i] != ' ') {
                stacks[stackIndex].add(l[i])
            }
        }
    }
    return stacks
}

fun getRearrangementProcedure(file: String): ArrayList<ArrayList<Int>> {
    val lines = file.lines()
    val procedures = ArrayList<ArrayList<Int>>()
    for (l in lines) {
        if (l.contains("move")) {
            val list = listOf (l.split(' '))
            val amount = list[0][1].toInt()
            val location = list[0][3].toInt()
            val destination = list[0][5].toInt()
            val procedure = ArrayList<Int>()
            procedure.addAll(listOf(amount, location, destination))
            procedures.add(procedure)
        }
    }
    return procedures
}

fun readInput(path: String) :String {
    return File(path).readText()
}