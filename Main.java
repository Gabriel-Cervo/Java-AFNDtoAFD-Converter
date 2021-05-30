import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        try {
            Reader.readAFD();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}