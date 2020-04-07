package academy.learnprogramming.challenge2

fun main(args: Array<String>) {
    //1. Declare a non-nullable float variable two ways,
    //and assign it the value -3847.384
    val nnFloat: Float = -3847.384f
    val nnFloat2 = (-3847.384).toFloat()
    var nnFloat3: Float = -3847.384f

    //2. Now change both of those variable declarations into nullable variables
    val nullableFloat4: Float? = -3847.384f
    val nullableFloat5: Float? = (-3847.384).toFloat()

    //3. Now declare an array of type non-nullable Short. Make it size 5, and assign it the
    //value 1,2,3,4 and 5
    val nnArray = shortArrayOf(1,2,3,4,5)
    val nnArray2: Array<Short> = arrayOf(1,2,3,4,5)

    //4. Now declare an array of nullable Ints and intialize it with the values
    //5, 10, 15, 20, 25, 30, 35, 40, 45, 50 etc. all the wa up to 200.
    val nullableArray = Array<Int?>(40) {i -> (i + 1) * 5}

    //5. You have to call a Java method with the following signature from Kotlin:
    //public void method1 (char[] charArray). Declare an array that you could pass to
    //the method and intialize it with the values 'a', 'b', and 'c'
    val charArray = charArrayOf('a','b','c')

    //6. Given the following code:
    val x: String? = "I AM IN UPPERCASE"
    //Using one line of code, declare another string variable,
    // and assign it c.toLowerCase() when x isn't null;
    // and the string "I give up!" when x is null
    val anotherStr =  x?.toLowerCase()?: "I give up!"

    //7. Now use the let function to (a) lowercase the string, and then
    // (b) replace "am" with "am not" in the result
    x?.let { it.toLowerCase().replace("am", "am not") }

    //8. You're really, really confident that the variable myNonNullVariable can't
    // contain null.
    // Change the following code to assert that myNonNullVariable isn't null
    //val myNonNullVariable: Int? = null
    //myNonNullVariable?.toDouble()
    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()
}



