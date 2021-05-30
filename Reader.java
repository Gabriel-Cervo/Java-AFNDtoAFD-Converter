import java.io.*;

public class Reader {
    public static void readAFD() throws IOException {
        AFD afd = new AFD();
        BufferedReader reader = new BufferedReader(new FileReader("gameShooterAFD.txt"));
        
        String line = "";
        line = reader.readLine();
        line = line.replace("{", "").replace("}", "").replace("(", "").replace(")", "");
        String[] titleAndContent = line.split("="); // [0] -> title || [1] -> content
        afd.name = titleAndContent[0];

        String[] content = titleAndContent[1].split(",");
        for (String state : content) {
            System.out.println(state);
        }


    }
}
