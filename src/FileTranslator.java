import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FileTranslator {
    static File userData = new File("UserData.txt");

    public static String fileToString() {
        String fileContaints = "";
        try {
            Scanner sc = new Scanner(userData).useDelimiter(":");
            while (sc.hasNextLine()) {
                System.out.println(sc.next());
             //   fileContaints += ":" + sc.next();
              //  fileContaints += sc.next();
            }
        } catch (IOException e) {
            System.out.print(e);
        }

        return fileContaints;
    } 
}
