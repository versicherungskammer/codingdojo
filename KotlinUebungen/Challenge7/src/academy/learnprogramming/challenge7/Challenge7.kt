package academy.learnprogramming.challenge7

fun main(args: Array<String>) {
    val joe = Person("Joe", "Jones", 45)
    //make the following possible
    val (fName, lName, age) = joe
    println("fName = $fName, lName = $lName, age = $age")
    /*or
    val jane = Person2("Jane", "Smithes", 45)
    val (f2Name, l2Name, age2) = jane
    println("fName = $f2Name, lName = $l2Name, age = $age2")*/
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 67)

    val immutablePeopleMap = mapOf("Jones" to joe, "Smith" to jane,
        "Wilson" to mary, "Adams" to john, "Smithson" to jean)

    //count the number of Persons whose last name begins with S
    println(immutablePeopleMap.count { it.key.startsWith('S') })
    //or
    println(immutablePeopleMap.filter { it.value.lastName.startsWith('S') }.count())

    //create a list of pairs with first and last name of each Person
    val namesPairs
            = immutablePeopleMap.map { Pair(it.value.firstName, it.value.lastName) }
    println(namesPairs)
    //or
    val firstNames = immutablePeopleMap.map { it.value.firstName }
    val lastName = immutablePeopleMap.map { it.value.lastName }
    val namesPair2 = firstNames.zip(lastName)
    println(namesPair2)

    //Using the function also() print out for each person
    //Joe is 45 years old, Jane is 12 years old etc.
    immutablePeopleMap.also { it.map {
        println("${it.value.firstName} is ${it.value.age} years old.")
    }
    }
    //also is almost the same as apply, only you use it instead of this

    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, 15, -83, 22, 10)
    //create a third list that contains items which
    //are found in both list1 and list2
    val list3 = list1.intersect(list2)
    println(list3)
    //or
    val list3b = list1.filter { it in list2 }
    println(list3b)
    //or
    val list3c = list1.filter { list2.contains(it) }
    println(list3c)

    //make the following code compile or make
    //the acceptance of subclasses in Box possible
    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper //solution covarance: class Box<out T>


}
class Person(val firstName: String, val lastName: String, val age: Int) {
    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age
}
//for first task
//or
data class Person2(val firstName: String, val lastName: String, val age: Int) {

}

class Box<out T> {

}

open class Paper {

}

class Regular: Paper() {}

class Premium: Paper() {}
