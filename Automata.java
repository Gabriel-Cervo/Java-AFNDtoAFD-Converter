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
}
