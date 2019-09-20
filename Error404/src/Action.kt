package caveman

import kotlin.random.Random

enum class Action {
    BLOCK, POKE, SHARPEN;
}

fun parseActions(string: String) =
    string.toCharArray().map {
        when (it) {
            'P' -> Action.POKE
            'S' -> Action.SHARPEN
            'B' -> Action.BLOCK
            else -> throw Exception("unknown action")
        }
    }

fun getRandomAction() = when (Random.nextInt(0, 2)) {
    0 -> Action.POKE
    1 -> Action.BLOCK
    2 -> Action.SHARPEN
    else -> Action.BLOCK
}

private fun getRandomOfTwo(action1: Action, action2: Action) = when (Random.nextInt(0, 1)) {
    0 -> action1
    1 -> action2
    else -> Action.BLOCK
}

fun getBlockOrPoke() = getRandomOfTwo(Action.BLOCK, Action.POKE)

fun getSharpenOrPoke() = getRandomOfTwo(Action.SHARPEN, Action.POKE)

fun getSharpenOrBlock() = getRandomOfTwo(Action.SHARPEN, Action.BLOCK)