stringerprinter()

fun stringer() :String {
    val s = "abcde"
    var bajs = "iopiop"
     for (i in 0..s.lastIndex) {
        print(s[i] + 2)
        var bajs = s[i]
    }
    return bajs
}

fun stringerprinter() = println(stringer())

