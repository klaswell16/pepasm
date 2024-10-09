public class Main {
    public static void main(String[] args) {
       FileReader fileReader = new FileReader();
       String fileData = fileReader.getFileData("C:/Users/kccla/CS 230/pepasm/src/file.pep");
       System.out.println(fileData);

    }
}
