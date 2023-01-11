import java.util.ArrayList;
/**
 * The UI class is meant for displaying different information via the terminal.
 */
public class UI {
/**
 * Displays the start menu and its options.
 */
    public static void startMenuDisplay() {
        System.out.println("\n1. Display current contacts\n2. Add a contact" +
                    "\n3. Exit application");
    }
/**
 * Displays the contacts window. If its empty displays it has no info
 * 
 * @param contactsInfo the ArrayList containing all the info
 */
    public static void contactsDisplay(ArrayList<UserInfo> contactsInfo) {
        if (contactsInfo.size() != 0) {
            System.out.println("\nCurrent contacts: ");
            for (int i = 0; i < FileTranslator.contactCount(); i++) {
                System.out.println((i + 1) + ". " + 
                    contactsInfo.get(i).getFirstName() + " " + 
                        contactsInfo.get(i).getLastName()); 
            }
            System.out.println("\nType the number of the contact to inspect" + 
                " or \"0\" to exit");
        } else {
            System.out.println("\nNo current contacts: ");
            System.out.println("Type \"0\" to exit");
        }
    }
/**
 * InspectUser is used to display specific user information
 * 
 * @param contactsInfo is the ArrayList
 * @param userToInspect is the user from the list we want to see
 */
    public static void inspectUser(ArrayList<UserInfo> contactsInfo, 
        int userToInspect) {

        System.out.println("\n1. First name: " + 
            contactsInfo.get(userToInspect).getFirstName());
        System.out.println("2. Last name: " + 
            contactsInfo.get(userToInspect).getLastName());
        System.out.println("3. Personal Id: " + 
            contactsInfo.get(userToInspect).getPersonalId());
        System.out.println("4. Phone number: " + 
            contactsInfo.get(userToInspect).getPhoneNumber());
        System.out.println("5. Email: " + 
            contactsInfo.get(userToInspect).getEMail());
        System.out.println("6. Address: " + 
            contactsInfo.get(userToInspect).getAddress());

        System.out.println ("\nType corresponding number to edit contact and " + 
        "type \"7\" to delete\ntype \"0\" to exit");
    }
/**
 * Used to print text
 * @param txt the text we want to see.
 */
    public static void printCustomText(String txt) {
        System.out.println(txt);
    }
}
