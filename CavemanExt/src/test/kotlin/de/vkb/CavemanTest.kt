package de.vkb

import org.junit.jupiter.api.Test

class CavemanTest {

  @Test
  fun main() = test("PPSPPS")

  fun test(opponent: String) {
    var myActions = ""
    var opponentsActions = ""

    opponent.toCharArray().forEach {
      myActions += call(if (myActions.isEmpty()) null else "$myActions,$opponentsActions")
      opponentsActions += it

      val result = battle(
        parseActions(myActions),
        parseActions(opponentsActions)
      )
      if (result != null) {
        print("$myActions,$opponentsActions")
        println(" - $result")
        return
      }
    }

    print("$myActions,$opponentsActions")
    println(" - Stalemate")
  }

  fun call(input: String?): String = Caveman().run(input)

  fun battle(actions1: List<Action>, actions2: List<Action>): String? = when {
    actions1[actions1.size - 1] == Action.POKE && actions2[actions1.size - 1] == Action.POKE ->
      if (Caveman.getSharpness(actions1) == 0 && Caveman.getSharpness(actions2) > 0) "Opponent wins"
      else if (Caveman.getSharpness(actions2) == 0 && Caveman.getSharpness(actions1) > 0) "Player wins"
      else null
    actions1[actions1.size - 1] == Action.POKE && actions2[actions1.size - 1] == Action.SHARPEN ->
      if (Caveman.getSharpness(actions1) > 0) "Player wins"
      else null
    actions2[actions1.size - 1] == Action.POKE && actions1[actions1.size - 1] == Action.SHARPEN ->
      if (Caveman.getSharpness(actions2) > 0) "Opponent wins"
      else null
    actions1[actions1.size - 1] == Action.POKE && actions2[actions1.size - 1] == Action.BLOCK ->
      if (Caveman.getSharpness(actions1) >= 5) "Player wins"
      else null
    actions2[actions1.size - 1] == Action.POKE && actions1[actions1.size - 1] == Action.BLOCK ->
      if (Caveman.getSharpness(actions2) >= 5) "Opponent wins"
      else null
    else -> null
  }

}
