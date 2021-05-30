import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            Automata afd = Reader.readAutomata();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}