import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            AFD afd = Reader.readAFD();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}