package de.vkb

import org.junit.jupiter.api.Test

class CavemanTest {

    enum class Action {
        BLOCK, POKE, SHARPEN;

        companion object {
            fun parse(string: String) =
                string.toCharArray().map {
                    when (it) {
                        'P' -> POKE
                        'S' -> SHARPEN
                        'B' -> BLOCK
                        else -> throw Exception("unknown action")
                    }
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

    @Test
    fun main() {
        test("PP")
    }

    fun test(opponent: String) {
        var myActions = ""
        var opponentsActions = ""

        for (c in opponent.toCharArray()) {
            val input = if (myActions.isEmpty()) null else "$myActions,$opponentsActions"

            myActions += call(input)
            opponentsActions += c

            val result = battle(
                Action.parse(myActions),
                Action.parse(opponentsActions)
            )
            if (result != null) {
                System.out.print("$myActions,$opponentsActions")
                System.out.println(" - $result")
                return
            }
        }

        System.out.print("$myActions,$opponentsActions")
        System.out.println(" - Stalemate")
    }

    fun call(input: String?): String {
        return Caveman().run(input)
    }

    fun battle(actions1: List<Action>, actions2: List<Action>): String? {
        val sharpness1 = getSharpness(actions1)
        val sharpness2 = getSharpness(actions2)
        val current1 = actions1[actions1.size - 1]
        val current2 = actions2[actions1.size - 1]

        if (current1 == CavemanTest.Action.POKE && current2 == CavemanTest.Action.POKE) {
            return if (sharpness1 == 0 && sharpness2 > 0) {
                "Opponent wins"
            } else if (sharpness2 == 0 && sharpness1 > 0) {
                "Player wins"
            } else {
                null
            }
        } else if (current1 == CavemanTest.Action.POKE && current2 == CavemanTest.Action.SHARPEN) {
            return if (sharpness1 > 0) {
                "Player wins"
            } else {
                null
            }
        } else if (current2 == CavemanTest.Action.POKE && current1 == CavemanTest.Action.SHARPEN) {
            return if (sharpness2 > 0) {
                "Opponent wins"
            } else {
                null
            }
        } else if (current1 == CavemanTest.Action.POKE && current2 == CavemanTest.Action.BLOCK) {
            return if (sharpness1 >= 5) {
                "Player wins"
            } else {
                null
            }
        } else if (current2 == CavemanTest.Action.POKE && current1 == CavemanTest.Action.BLOCK) {
            return if (sharpness2 >= 5) {
                "Opponent wins"
            } else {
                null
            }
        }

        return null
    }

}