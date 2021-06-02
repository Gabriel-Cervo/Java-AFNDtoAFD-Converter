import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        try {
            Automata afnd = Reader.readAutomata();
            System.out.println("Automato lido com sucesso.");
            Automata afd = Converter.convertAFDtoAFND(afnd);
            System.out.println("Automato convertido com sucesso.");

            while (true) {
                System.out.println("\n");
                System.out.print("Digite aqui a palavra que deseja testar ou 0 para cancelar:");
                String word = reader.nextLine();
                if (word.equals("0")) {
                    break;
                }

                Boolean isValid = afd.checkWord(word);
                System.out.println("\n");
                System.out.println("A palavra digitada "
                        + (isValid ? "foi aceita pelo automato" : "não foi aceita pelo automato"));
            }

            reader.close();
            System.out.println("Programa encerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}