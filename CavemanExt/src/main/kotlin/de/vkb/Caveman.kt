package de.vkb

class Caveman {

  fun main(args: Array<String>) =
    if (args.isNotEmpty()) {
      println(run(args[0]))
    } else {
      println(run(null))
    }

  companion object {
    fun getSharpness(actions: List<Action>): Int = getSharpnessRecursive(actions, 0)

    private fun getSharpnessRecursive(actions: List<Action>, originalSharpness: Int): Int =
      when {
        actions.isEmpty() -> originalSharpness
        actions.last() == Action.SHARPEN -> getSharpnessRecursive(actions.subList(0, actions.size - 1), originalSharpness + 1)
        actions.last() == Action.POKE && originalSharpness > 0 -> getSharpnessRecursive(actions.subList(0, actions.size - 1), originalSharpness - 1)
        else -> getSharpnessRecursive(actions.subList(0, actions.size - 1), originalSharpness)
      }
  }

  fun run(input: String?): String =
    if (input == null) {
      run(emptyList(), emptyList()).name.slice(0..0)
    } else {
      val actions = input.split(",")
      run(parseActions(actions[0]), parseActions(actions[1])).name.slice(0..0)
    }

  private fun run(myActions: List<Action>, opponentsActions: List<Action>): Action =
    when (Pair(getSharpness(myActions), getSharpness(opponentsActions))) {
      Pair(0, 0) -> Action.SHARPEN
      Pair(5, 0), Pair(5,1), Pair(5,2), Pair(5,3), Pair(5,4) -> Action.POKE
      Pair(0, 1) -> Action.BLOCK
      Pair(0, 2), Pair(0, 3), Pair(0, 4), Pair(0, 5) -> getSharpenOrBlock()
      Pair(1, 0) -> Action.SHARPEN
      Pair(2, 0), Pair(3, 0), Pair(4, 0) -> getSharpenOrPoke()
      Pair(1, 1) -> Action.BLOCK
      Pair(1, 2) -> getBlockOrPoke()
      else -> getRandomAction()
    }
}
