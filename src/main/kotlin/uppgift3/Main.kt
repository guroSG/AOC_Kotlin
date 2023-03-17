package uppgift3

import java.io.File

//Dag 5 2022

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

fun executeProcedures9000(procedures: List<Procedure>, stacks: List<ArrayList<Char>>): List<ArrayList<Char>>{
    for (p in procedures) {
        for (i in 0 until p.amount) {
            val box = stacks[p.location - 1].removeAt(0)
            stacks[p.destination - 1].add(0, box)
        }
    }
    return stacks
}

fun executeProcedures9001(procedures: List<Procedure>, stacks: List<ArrayList<Char>>): List<ArrayList<Char>>{
    for (p in procedures) {
        val boxList = ArrayList<Char>()
        for (i in 0 until p.amount) {
            val box = stacks[p.location - 1].removeAt(0)
            boxList.add(box)
        }
        boxList.reverse()
        for ((index) in boxList.withIndex()) {
            stacks[p.destination - 1].add(0, boxList[index])
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

fun getRearrangementProcedure (file: String):List<Procedure> {
    val lines = file.lines()
    val procedures = ArrayList<Procedure>()
    for (l in lines) {
        if (l.contains("move")){
            val  amount = l.substring(l.indexOf('e')+1, l.indexOf('f')).trim().toInt()
            val location = l.substring(l.indexOf("om")+2, l.indexOf('t')).trim().toInt()
            val destination = l.substring(l.indexOf("to")+2).trim().toInt()
            val procedure = Procedure(amount, location, destination)
            procedures.add(procedure)
        }
    }
    return procedures
}

class Procedure(val amount: Int, val location: Int, val destination: Int)

fun readInput(path: String) :String {
    return File(path).readText()
}

