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

        int endIndex = 0;
        
        // Add states to the AFD
        // States name must start with Q
        for (int i = 0; i < content.length; i++) {
            if(!content[i].toUpperCase().startsWith("Q")) {
                endIndex = i;
                break;
            }

            afd.states.add(content[i]);
        }

        // Add acceptable words to the AFD
        // Stops on initial state
        for (int i = endIndex; i < content.length; i++) {
            if(content[i].toUpperCase().startsWith("Q")) {
                endIndex = i;
                break;
            }

            afd.knownLanguages.add(content[i]);
        }

        afd.initialState = content[endIndex];

        System.out.println(afd.initialState);
        reader.close();
    }
}
