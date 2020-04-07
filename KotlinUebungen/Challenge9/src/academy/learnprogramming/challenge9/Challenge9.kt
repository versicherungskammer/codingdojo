package academy.learnprogramming.challenge9

import academy.learnprogramming.javacode.Employee

fun main(args: Array<String>) {
    val employee = Employee("Jane", "Smith", 2000)
    //Make this code compile
    employee.lastName = "Jones"
    //employee.salaryLast3Years = arrayOf(50000.25, 54000.60, 56800.42)
    employee.salaryLast3Years = arrayOf(50000.25f, 54000.60f, 56800.42f).toFloatArray()
    //or
    //employee.salaryLast3Years = floatArrayOf(50000.25f, 54000.60f, 56800.42f)
}