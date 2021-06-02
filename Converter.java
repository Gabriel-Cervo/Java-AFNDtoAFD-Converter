import java.util.HashMap;

public class Converter {
    public static Automata convertAFDtoAFND(Automata afnd) {
        HashMap<Integer, String> rowContent = new HashMap<Integer, String>();
        HashMap<Integer, Transition> columnContent = new HashMap<Integer, Transition>();

        int rows = (int) Math.pow(2, afnd.states.size());
        int columns = afnd.transitions.size();
        String[][] convertedTransition = new String[rows][columns];
        int rowPointer = 0;
        int columnPointer = 0;

        for (String state : afnd.states) {
            rowContent.put(rowPointer, state);
            for (Transition transition : afnd.transitions) {
                columnContent.put(columnPointer, transition);
                convertedTransition[rowPointer][columnPointer] = transition.to.trim().equalsIgnoreCase(state.trim())
                        ? transition.withState
                        : null;

                columnPointer++;
            }
            rowPointer++;
            columnPointer = 0;
        }
        rowPointer = 0;
        columnPointer = 0;

        Automata afd = new Automata();
        afd.name = afnd.name;
        afd.knownLanguages = afnd.knownLanguages;
        afd.finalStates = afnd.finalStates;

        // for (int i = 0; i < rows; i++) { // states
        // for (int j = 0; j < columns; j++) { // transitions
        // if (afd.initialState == null) {
        // afd.initialState = rowContent.get(rowPointer);
        // }
        // System.out.println(rowPointer);

        // Transition newTransition = new
        // Transition(rowContent.get(rowPointer).toLowerCase(),
        // columnContent.get(columnPointer).withState.toLowerCase(),
        // convertedTransition[rowPointer][columnPointer]);
        // afd.transitions.add(newTransition);

        // if (!afd.states.contains(rowContent.get(rowPointer).toLowerCase())) {
        // afd.states.add(rowContent.get(rowPointer).toLowerCase());
        // }
        // if
        // (!afd.states.contains(columnContent.get(columnPointer).withState.toLowerCase()))
        // {
        // afd.states.add(columnContent.get(columnPointer).withState.toLowerCase());
        // }
        // columnPointer++;
        // }
        // rowPointer++;
        // columnPointer = 0;
        // }

        for (String state : afnd.states) {
            for (Transition transition : afnd.transitions) {
                if (convertedTransition[rowPointer][columnPointer] == null) {
                    columnPointer++;
                    continue;
                }
                if (afd.initialState.equals("")) {
                    afd.initialState = rowContent.get(rowPointer);
                }
                Transition newTransition = new Transition(columnContent.get(columnPointer).from.toLowerCase(),
                        rowContent.get(rowPointer).toLowerCase(), convertedTransition[rowPointer][columnPointer]);
                afd.transitions.add(newTransition);

                if (!afd.states.contains(rowContent.get(rowPointer).toLowerCase())) {
                    afd.states.add(rowContent.get(rowPointer).toLowerCase());
                }
                columnPointer++;
            }
            rowPointer++;
            columnPointer = 0;
        }

        return afd;
    }
}
