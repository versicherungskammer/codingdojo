import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cavemen {


    enum Action {
        BLOCK, POKE, SHARPEN;

        public static List<Action> parse(String string) {
            List<Action> result = new ArrayList<>();
            for (char c : string.toCharArray()) {
                switch (c) {
                    case 'B':
                        result.add(BLOCK);
                        break;
                    case 'P':
                        result.add(POKE);
                        break;
                    case 'S':
                        result.add(SHARPEN);
                        break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String result;

        if (args.length > 0) {
            result = run(args[0]);
        } else {
            result = run(null);
        }

        System.out.println(result);
    }

    public static int getSharpness(List<Action> actions) {
        int sharpness = 0;
        for (Action action : actions) {
            if (action == Action.SHARPEN) {
                sharpness++;
            } else if (action == Action.POKE && sharpness > 0) {
                sharpness--;
            }
        }
        return sharpness;
    }

    public static String run(String input) {
        Action action;
        if (input == null) {
            action = run(Collections.emptyList(), Collections.emptyList());
        } else {
            String[] actions = input.split(",");
            action = run(Action.parse(actions[0]), Action.parse(actions[1]));
        }

        return String.valueOf(action.name().charAt(0));
    }

    public static Action run(List<Action> myActions, List<Action> opponentsActions) {

        if (getSharpness(myActions) == 0 && getSharpness(opponentsActions) ==0) {
            return Action.SHARPEN;
        }
        if (getSharpness(myActions)==5){
            return Action.POKE;
        }
        if ((opponentsActions.get(opponentsActions.size() - 1) == Action.POKE) && (opponentsActions.get(opponentsActions.size() - 2) == Action.SHARPEN && getSharpness(myActions)>0)) {
            return Action.POKE;
        }
        if (getSharpness(myActions) > getSharpness(opponentsActions) && (getSharpness(opponentsActions) == 0)) {
                return Action.SHARPEN;
        }
        if ((opponentsActions.get(opponentsActions.size() - 1) == Action.BLOCK) && (opponentsActions.get(opponentsActions.size() - 2) == Action.BLOCK)) {
                return Action.SHARPEN;
        }
        if (getSharpness(myActions) > getSharpness(opponentsActions) + 1) {
            return Action.POKE;
        }
        return Action.BLOCK;
        }
    }







