import java.io.*;

public class Reader {
    public static void readAFD() throws IOException {
        AFD afd = new AFD();
        BufferedReader reader = new BufferedReader(new FileReader("gameShooterAFD.txt"));
        
        String line = reader.readLine();
        line = line.replace("{", "").replace("}", "").replace("(", "").replace(")", "");
     
        String[] titleAndContent = line.split("="); // [0] -> title || [1] -> content
        afd.name = titleAndContent[0];

        String[] content = titleAndContent[1].split(",");

        int endStateIndex = 0;
        
        // Add states to the AFD
        // States name must start with Q
        for (int i = 0; i < content.length; i++) {
            if(!content[i].toUpperCase().startsWith("Q")) {
                endStateIndex = i;
                break;
            }

            afd.states.add(content[i]);
        }

        System.out.println(afd.states.toString());
        reader.close();
    }
}
