package efter2

import java.io.File

/*2022 Dag 3
// använda repon: https://github.com/osipxd/advent-of-code-2022/blob/main/src/Day03.kt
https://github.com/peckb1/advent-of-code/blob/main/src/main/kotlin/me/peckb/aoc/_2022/calendar/day03/Day03.kt
 */

fun main(){
    val input2 = readInput2("src/main/kotlin/efter2/inputefter2")
    println(findTypePriority(findDuplicates(input2)))
    println(findTypePriority(findRepeatInElfGroup(findElfGroups(input2))))
}

fun readInput2(path: String) :String {
    return File(path).readText()
}

fun findRepeatInElfGroup(groups: List<List<String>>) :ArrayList<Char> {
    val itemTypeDuplicates = ArrayList<Char>()
    for (g in groups) {
        for (t in g[0]) {
             if (g[1].contains(t) && g[2].contains(t))
                    println(t)
                    itemTypeDuplicates.add(t)
                    break
            }
        }
    return itemTypeDuplicates
}

    fun findElfGroups(file: String): List<List<String>> {
        return file.lines().chunked(3)
    }


    fun findDuplicates(file: String): ArrayList<Char> {
        val lines = file.lines()
        val itemTypeDuplicates = ArrayList<Char>()
        for (n in lines) {
            val compartment1 = n.substring(0, n.length / 2)
            val compartment2 = n.substring(n.length / 2)
            for (i in compartment1) {
                if (compartment2.contains(i)) {
                    itemTypeDuplicates.add(i)
                    break
                }
            }
        }
        return itemTypeDuplicates
    }

    fun findTypePriority(itemTypeList: ArrayList<Char>): Int {
        return itemTypeList.sumOf { if (it in 'a'..'z') it - 'a' + 1 else it - 'A' + 27 }
    }



