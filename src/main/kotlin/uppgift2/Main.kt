package uppgift2

import java.io.File

//Dag 3 2022

fun main()  {
    val input = readInput("src/main/kotlin/uppgift2/input2.txt")
    println(findTypePriority(findDuplicates(input)))
    println(findTypePriority(findRepeatInElfGroup(findElfGroups(input))))
}

fun findRepeatInElfGroup(groups: ArrayList<ElfGroup>) :ArrayList<Char> {
    val itemTypeDuplicates = ArrayList<Char>()
    for (g in groups){
            for (t in g.rucksacks[0]){
                if (g.rucksacks[1].contains(t) && g.rucksacks[2].contains(t)){
                    itemTypeDuplicates.add(t)
                    break
                }
            }
        }
    return itemTypeDuplicates
}


fun findElfGroups(file: String) :ArrayList<ElfGroup>{
    var i = 0
    val lines = file.lines()
    val elfGroups = ArrayList<ElfGroup>()
    var elfGroupRucksacks: ArrayList<String>? = null
    for (n in lines){
        if (elfGroupRucksacks == null) {
            elfGroupRucksacks = arrayListOf()
        }
        elfGroupRucksacks.add(n)
        i++
        if(i % 3 == 0) {
            val elfGroup = ElfGroup(elfGroupRucksacks)
            elfGroups.add(elfGroup)
            elfGroupRucksacks = null
        }
    }
    return elfGroups
}

class ElfGroup(val rucksacks: MutableList<String>)


fun findDuplicates(file: String) :ArrayList<Char>{
    val lines = file.lines()
    val itemTypeDuplicates = ArrayList<Char>()
    for (n in lines) {
        val compartment1 = n.substring(0, n.length/2)
        val compartment2 = n.substring(n.length/2)
        for (i in compartment1) {
            if (compartment2.contains(i)) {
                itemTypeDuplicates.add(i)
                break
            }
        }
    }
        return itemTypeDuplicates
}

fun findTypePriority(itemTypeList: ArrayList<Char>) :Int{
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    var totalValue = 0
    for (c in itemTypeList){
        val value = alphabet.indexOf(c.lowercaseChar())+1
        if (c.isUpperCase()){
            totalValue += value + alphabet.length
        }
        else {
            totalValue += value
            }
    }
    return totalValue
}

fun readInput(path: String) :String {
    return File(path).readText()
}