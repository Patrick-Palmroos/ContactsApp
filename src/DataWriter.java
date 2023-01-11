import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 * DataWriter class is used to write or modify the text file. 
 * 
 * DataWriter is specifically for modifying. Its designed to only work
 * with the UserData.txt attached to this project. Its not meant for
 * other usage.
 * 
 * @author Patrick Palmroos
 */
public class DataWriter {

    static File userData = new File("UserData.txt");

/**
 * updateContacts is to rewrite the save file. 
 * 
 * It works by deleting the original file. creating a new one and writing 
 * the updated info on it.
 * 
 * @param userList is the ArrayList that has all user Objects saved
 */
    public static void updateContacts(ArrayList<UserInfo> userList) {
        userData.delete();

        try {
            FileWriter file = new FileWriter("UserData.txt");
            file.write(FileTranslator.listToString(userList));
            file.close();
        } catch (IOException e) {
            System.out.println(e);
        } 
    }

/**
 * changeInfo changes the information of a specific object on the ArrayList. 
 * 
 * it takes in the list itself, which object on it we will change and what 
 * specific info we want changed. Then it gives the user the ability to change 
 * that info.
 * 
 * @param userList is the ArrayList which contains all UserInfo objects.
 * @param userNum is the object we want changed
 * @param infoToChange is the specifi info we want changed
 */

    public static void changeInfo(ArrayList<UserInfo> userList, int userNum, 
                int infoToChange) {

            switch (infoToChange) {
                case 1:
                    UI.printCustomText("Give your first name:");
                    userList.get(userNum).setFirstName(UserInput.txtInput(
                        1, 50, false));
                    break;
                case 2:
                    UI.printCustomText("Give your last name:");
                    userList.get(userNum).setLastName(UserInput.txtInput(
                        1, 50, false));        
                    break;
                case 3:
                    UI.printCustomText("Give your personal id:");
                    userList.get(userNum).setPersonalId(UserInput.txtInput(
                        11, 11, false));
                    break;
                case 4:
                    UI.printCustomText("Give your phone number:");
                    userList.get(userNum).setPhoneNumber(UserInput.numInputByCount(
                        4, 20));
                    break;
                case 5:
                    UI.printCustomText("Give your address");
                    userList.get(userNum).setAddress(UserInput.txtInput(
                        1, 50, false));        
                    break;
                case 6:
                    UI.printCustomText("Give your email");
                    userList.get(userNum).setEMail(UserInput.txtInput(1,
                    50, false));
                    break;
            }
    }
}
