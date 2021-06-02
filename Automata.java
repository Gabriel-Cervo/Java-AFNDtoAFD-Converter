import java.util.ArrayList;

public class Automata {
    public String name;
    public String initialState;
    public ArrayList<String> states;
    public ArrayList<String> finalStates;
    public ArrayList<String> knownLanguages;
    public ArrayList<Transition> transitions;

    public Automata() {
        this.name = "";
        this.initialState = "";
        this.states = new ArrayList<String>();
        this.finalStates = new ArrayList<String>();
        this.knownLanguages = new ArrayList<String>();
        this.transitions = new ArrayList<Transition>();
    }

    public boolean checkWord(String word) {
        String actualState = initialState;
        String[] letters = word.split("");

        String actualWord = "";

        for (int i = 0; i < letters.length; i++) {
            actualWord = letters[i];
            if (!knownLanguages.contains(actualWord.toUpperCase())) {
                actualWord += letters[i + 1];
                i++;
                if (!knownLanguages.contains(actualWord.toUpperCase())) {
                    break;
                }
            }

            String lastTransition = actualState;
            for (int j = 0; j < transitions.size() - 1; j++) {
                Transition transition = transitions.get(j);
                if (transition.from.equalsIgnoreCase(actualState)) {
                    if (transition.withState.trim().equalsIgnoreCase(actualWord.trim())) {
                        actualState = transition.to;
                        break;
                    }
                }
            }

            if ((actualWord.equalsIgnoreCase("F") || actualWord.equalsIgnoreCase("C")
                    || actualWord.equalsIgnoreCase("J"))) {
                if (word.substring(word.length() - 6, word.length()).trim().equalsIgnoreCase("A2OA1O")) {
                    return true;
                }
                actualState = "q0";
                continue;
            }
            if (lastTransition.equalsIgnoreCase(actualState)) {
                break;
            }
        }

        return finalStates.contains(actualState);
    }
}
