import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader {

    public String getFileData(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            File assemblyCode = new File(filePath);
            Scanner scanner = new Scanner(assemblyCode);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                fileContent.append(data).append("\n");
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("An error");
            e.printStackTrace();
        }
        return fileContent.toString();
    }

}
