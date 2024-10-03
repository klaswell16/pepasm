import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader {

    public void getFileData(String filePath) {
        try {
            File assemblyCode = new File(filePath);
            Scanner scanner = new Scanner(assemblyCode);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("An error");
            e.printStackTrace();
        }
    }

}
