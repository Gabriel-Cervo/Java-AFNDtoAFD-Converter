import java.io.*;

public class Reader {
    public static Automata readAutomata() throws IOException {
        Automata automata = new Automata();
        BufferedReader reader = new BufferedReader(new FileReader("gameShooterAFD.txt"));
        
        String line = reader.readLine();
        line = line.replace("{", "").replace("}", "").replace("(", "").replace(")", "");
     
        String[] titleAndContent = line.split("="); // [0] -> title || [1] -> content
        automata.name = titleAndContent[0];

        String[] content = titleAndContent[1].split(",");

        int endIndex = 0;
        
        // Add states to the AFD
        // States name must start with Q
        for (int i = 0; i < content.length; i++) {
            if(!content[i].toUpperCase().startsWith("Q")) {
                endIndex = i;
                break;
            }

            automata.states.add(content[i]);
        }

        // Add acceptable words to the AFD
        // Stops on initial state
        for (int i = endIndex; i < content.length; i++) {
            if(content[i].toUpperCase().startsWith("Q")) {
                endIndex = i;
                break;
            }

            automata.knownLanguages.add(content[i]);
        }

        automata.initialState = content[endIndex++];

        for (int i = endIndex; i < content.length; i++) {
            automata.finalStates.add(content[i]);
        }

        // Read transitions
        while ((line = reader.readLine()) != null) {
            if(line.toLowerCase().contains("prog")) {
                continue;
            }
            String[] transition = line.replace("(", "").replace(")", "").split("=");
            String[] fromAndWord = transition[0].split(",");
            Transition newTransition = new Transition(fromAndWord[0].trim(), transition[1].trim(), fromAndWord[1].trim());

            automata.transitions.add(newTransition);
        }
        reader.close();
        return automata;
    }
}
