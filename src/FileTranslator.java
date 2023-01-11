import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileTranslator class is for reading the text file. 
 * 
 * It is again specifically meant to read the UserData.txt file.
 * 
 * @author Patrick Palmroos
 */
public class FileTranslator {
    static File userData = new File("UserData.txt");

/**
 * fileToList reads the text file and turns the users on it into an ArrayList.
 * 
 * @return the saved users from the txt file in an ArrayList.
 */
    public static ArrayList<UserInfo> fileToList() {
        ArrayList<UserInfo> tempList = new ArrayList<UserInfo>();
        int loopCount = contactCount();
        int lineCounter = 0;
        
            try {
                Scanner sc = new Scanner(userData);
                for (int i = 0; i < loopCount; i++) {
                    boolean scanned = false;
                    while (sc.hasNextLine() && !scanned) {
                        try {
                            int num = Integer.parseInt(sc.next());
                            if (num == (i + 1)) {
                                tempList = setUserInfo(sc, lineCounter, tempList);
                                lineCounter = 0;
                                scanned = true;
                            } else {
                                skipLines(sc, lineCounter += 6);
                            }
                        } catch (NumberFormatException e) {}
                    }
                }
            } catch (IOException e) {
                System.out.print(e);
            }

        return tempList;
    }
/**
 * Used to count the amount of users within the txt file.
 * 
 * @return the amount of users on the file.
 */
    public static int contactCount() {
        int count = 0;

        try {
            Scanner sc = new Scanner(userData);
            while (sc.hasNextLine()) {
                try {
                    int temp = Integer.parseInt(sc.next());
                    count++;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("CONTACT COUNT COUNTER" + 
                           " BOUNDS ERROR");
                }
                for (int i = 0; i < 6; i++) {
                    sc.next();
                }
            }
        } catch (IOException e) {
            System.out.print(e);
        }
        return count;
    }
/**
 * Used to skip lines in the text file.
 * @param s is the scanner class
 * @param desiredLine is the line we want to move to.
 */
    public static void skipLines(Scanner s, int desiredLine) {
        for (int i = 0; i < desiredLine; i++) {
            if (s.hasNextLine()) {
                s.nextLine();
            }
        }
    }
/**
 * Sets the info from the file into an UserInfo object and sends it back.
 * @param sc is the passed scanner class
 * @param skipToLine is the line we want to skip to
 * @param list is the ArrayList which this object is added to
 * @return the changed ArrayList
 */
    public static ArrayList<UserInfo> setUserInfo(Scanner sc, int skipToLine, ArrayList<UserInfo> list) {
        UserInfo tempUser = new UserInfo();
        skipLines(sc, skipToLine);

        tempUser.setFirstName(sc.next());
        tempUser.setLastName(sc.next());
        tempUser.setPersonalId(sc.next());
        tempUser.setPhoneNumber(Integer.parseInt(sc.next()));
        tempUser.setAddress(sc.next());
        tempUser.setEMail(sc.next());

        list.add(tempUser);

        return list;
    }
/**
 * Turns the ArrayList into text format. 
 * 
 * this is used for saving the info onto the new file in DataWriter class.
 * 
 * @param userList is the ArrayList with UserInfo objects in it
 * @return the list turned into text format readable by this app.
 */
    public static String listToString(ArrayList<UserInfo> userList) {
        String strngList = "";
        for (int i = 0; i < userList.size(); i++) {
            strngList += Integer.toString((i + 1)) + "\n";
            strngList += userList.get(i).getFirstName() + "\n" +
                userList.get(i).getLastName() + "\n" +
                userList.get(i).getPersonalId() + "\n" +
                userList.get(i).getPhoneNumber() + "\n" +
                userList.get(i).getAddress() + "\n" +
                userList.get(i).getEMail();

            if (i != userList.size() - 1) {
                strngList += "\n";
            }
        }

        return strngList;
    }
}
