public class Transition {
    public String from;
    public String to;
    public String withState;

    public Transition(String from, String to, String withState) {
        this.from = from;
        this.to = to;
        this.withState = withState;
    }

    @Override
    public String toString() {
        return "from " + from + " to " + to + " with word " + withState;
    }
}
