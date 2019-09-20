package caveman


import java.util.ArrayList

object CavemanTest3 {


    private var counter = 0
    private var countero = 0

    enum class Action {
        BLOCK, POKE, SHARPEN;


        companion object {

            fun parse(string: String): List<Action> {
                val result = ArrayList<Action>()
                for (c in string.toCharArray()) {
                    when (c) {
                        'B' -> result.add(BLOCK)
                        'P' -> result.add(POKE)
                        'S' -> result.add(SHARPEN)
                    }
                }
                return result
            }
        }
    }

    fun getSharpness(actions: List<Action>): Int {
        var sharpness = 0
        for (i in 0 until actions.size - 1) {
            val action = actions[i]
            if (action == Action.SHARPEN) {
                sharpness++
            } else if (action == Action.POKE && sharpness > 0) {
                sharpness--
            }
        }
        // System.out.println(actions + " " + sharpness);
        return sharpness
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //test("PP");
        for (p in 0..99) {
            test()
        }

    }

    fun test() {
        var myActions = ""
        var opponentsActions = ""

        for (i in 0..99) {
            val input = if (myActions.isEmpty()) null else "$myActions,$opponentsActions"
            val inputz = if (opponentsActions.isEmpty()) null else "$opponentsActions,$myActions"

            myActions += call(input)
            opponentsActions += call2(inputz)

            val result = battle(Action.parse(myActions), Action.parse(opponentsActions))
            if (result != null) {
                print("$myActions,$opponentsActions")
                println(" - $result")
                println(counter)
                println(countero)
                return
            }
        }

        print("$myActions,$opponentsActions")
        println(" - Stalemate")
    }

    fun call2(inputz: String?): String {
        val caveman2= Caveman2()
        return caveman2.run(inputz)
    }

    fun call(input: String?): String {
        return Caveman3.run(input)
    }

    fun battle(actions1: List<Action>, actions2: List<Action>): String? {
        val sharpness1 = getSharpness(actions1)
        val sharpness2 = getSharpness(actions2)
        val current1 = actions1[actions1.size - 1]
        val current2 = actions2[actions1.size - 1]
        val cave2 = "Niko"
        val cave3 = "Azubi"

        if (current1 == Action.POKE && current2 == Action.POKE) {
            if (sharpness1 == 0 && sharpness2 > 0) {
                countero++
                return "$cave3 wins"
            } else if (sharpness2 == 0 && sharpness1 > 0) {
                counter++
                return "$cave2 wins"
            } else {
                return null
            }
        } else if (current1 == Action.POKE && current2 == Action.SHARPEN) {
            if (sharpness1 > 0) {
                counter++
                return "$cave2 wins"
            } else {
                return null
            }
        } else if (current2 == Action.POKE && current1 == Action.SHARPEN) {
            if (sharpness2 > 0) {
                countero++
                return "$cave3 wins"
            } else {
                return null
            }
        } else if (current1 == Action.POKE && current2 == Action.BLOCK) {
            if (sharpness1 >= 5) {
                counter++
                return "$cave2 wins"
            } else {
                return null
            }
        } else if (current2 == Action.POKE && current1 == Action.BLOCK) {
            if (sharpness2 >= 5) {
                countero++
                return "$cave3 wins"
            } else {
                return null
            }
        }

        return null
    }

}