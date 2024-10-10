import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Assembler {

    public void assembleFile(String filePath) {
        HashMap<String, String> commands = new HashMap<>();
        HashMap<String, String> address = new HashMap<>();
        commands.put("STBA", "F");
        commands.put("LDBA", "D");
        commands.put("STWA", "E");
        commands.put("LDWA", "C");
        commands.put("ANDA", "8");
        commands.put("ASLA", "0A");
        commands.put("ASRA", "0C");
        commands.put("STOP", "00");
        commands.put("CPBA", "B");
        commands.put("BRNE", "1A");
        commands.put("ADDA", "60");

        address.put("i", "0");
        address.put("d", "1");

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            StringBuilder machineCodeOutput = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty() || line.startsWith(";") || line.equalsIgnoreCase(".END")) {
                    continue;
                }
                if (line.equalsIgnoreCase("STOP")) {
                    machineCodeOutput.append(commands.get("STOP"));
                    continue;
                }

                String[] parts = line.split("[ ,]+");

                String command = parts[0].toUpperCase();
                if (parts.length >1) {
                    String operand = parts[1].replace("0x", "");
                    String mode = parts[2].toLowerCase();
                    if (commands.containsKey(command) && address.containsKey(mode)) {
                        String machineCode = commands.get(command) + address.get(mode);
                        machineCodeOutput.append(machineCode).append(operand);
                    } else {
                        System.out.println("Unknown: " + line);
                    }
                }
            }
            scanner.close();

            String formattedCode = formatCode(machineCodeOutput.toString());
            System.out.println(formattedCode);

        } catch (FileNotFoundException e) {
            System.out.println("An error");
        }
    }
    public static String formatCode(String machineCode){
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < machineCode.length(); i += 2){
            if(i > 0){
                formatted.append(" ");
            }
            formatted.append(machineCode, i, i + 2);

        }
        return formatted.toString();
    }
}


