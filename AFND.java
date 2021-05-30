import java.util.ArrayList;

public class AFND {
    public String nome;
    public String initialState;
    public ArrayList<String> states;
    public ArrayList<String> finalStates;
    public ArrayList<String> knownLanguages;
    public ArrayList<Transition> transitions;

    public AFND() {
        this.nome = "";
        this.initialState = "";
        this.states = new ArrayList<String>();
        this.finalStates = new ArrayList<String>();
        this.knownLanguages = new ArrayList<String>();
        this.transitions = new ArrayList<Transition>();
    }
}
