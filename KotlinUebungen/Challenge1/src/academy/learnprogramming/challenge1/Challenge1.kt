package academy.learnprogramming.challenge1

fun main(args: Array<String>) {
    val hello1: String = "Hello"
    val hello2 = "Hello"

    println("hello1 & hello2 are referentially equal ${hello1 === hello2}")
    println("hello1 == hello2 are structural equal ${hello1 == hello2}")
    var int1 = 2988
    val any: Any = "The Any type is the root of the Kotlin class hierarchy"
    if (any is String) {
        println(any.toUpperCase())
    }

    println(
        """   1
              |  11 
              | 111
              |1111""".trimMargin()
    )
    println(
        """1   1
              1  11 
              1 111
              11111""".trimMargin("1")
    )

}