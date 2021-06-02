import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            Automata afnd = Reader.readAutomata();
            Automata afd = Converter.convertAFDtoAFND(afnd);
            System.out.println(afd.checkWord("A1OA1OA1OA2OSOA1O"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}