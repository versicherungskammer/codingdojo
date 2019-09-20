import java.util.ArrayList
import java.util.Collections

object Caveman3 {


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

    @JvmStatic
    fun main(args: Array<String>) {
        val result: String

        if (args.size > 0) {
            result = run(args[0])
        } else {
            result = run(null)
        }

        println(result)
    }

    fun getSharpness(actions: List<Action>): Int {
        var sharpness = 0
        for (action in actions) {
            if (action == Action.SHARPEN) {
                sharpness++
            } else if (action == Action.POKE && sharpness > 0) {
                sharpness--
            }
        }
        return sharpness
    }

    fun run(input: String?): String {
        val action: Action
        if (input == null) {
            action = run(emptyList(), emptyList())
        } else {
            val actions = input.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            action = run(Action.parse(actions[0]), Action.parse(actions[1]))
        }

        return action.name[0].toString()
    }

    fun run(myActions: List<Action>, opponentsActions: List<Action>): Action {

        if (getSharpness(myActions) == 0 && getSharpness(opponentsActions) == 0) {
            return Action.SHARPEN
        }
        if (getSharpness(myActions) == 5) {
            return Action.POKE
        }
        if (opponentsActions[opponentsActions.size - 1] == Action.POKE && opponentsActions[opponentsActions.size - 2] == Action.SHARPEN && getSharpness(
                myActions
            ) > 0
        ) {
            return Action.POKE
        }
        if (getSharpness(myActions) > getSharpness(opponentsActions) && getSharpness(opponentsActions) == 0) {
            return Action.SHARPEN
        }
        if (opponentsActions[opponentsActions.size - 1] == Action.BLOCK && opponentsActions[opponentsActions.size - 2] == Action.BLOCK) {
            return Action.SHARPEN
        }
        return if (getSharpness(myActions) > getSharpness(opponentsActions) + 1) {
            Action.POKE
        } else Action.BLOCK
    }
}







