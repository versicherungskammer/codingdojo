import java.util.ArrayList
import java.util.Collections

object Caveman {

    internal enum class Action {
        BLOCK, POKE, SHARPEN;


        companion object {

            fun parse(string: String): List<Action> {
                val result = ArrayList()
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

    fun main(args: Array<String>) {
        val result: String

        if (args.size > 0) {
            result = run(args[0])
        } else {
            result = run(null)
        }

        System.out.println(result)
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
            action = run(Collections.emptyList(), Collections.emptyList())
        } else {
            val actions = input.split(",")
            action = run(Action.parse(actions[0]), Action.parse(actions[1]))
        }

        return String.valueOf(action.name().charAt(0))
    }

    fun run(myActions: List<Action>, opponentsActions: List<Action>): Action {
        // TODO implement this
        return Action.SHARPEN
    }

}