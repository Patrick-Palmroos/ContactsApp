import java.util.ArrayList;

/**
 * Class ContactsApp is the class where from the app is ran.
 * 
 * Contacts app first creates and integer to remember where the user is 
 * navigating at the moment. Then the list for UserInfo objects is created. 
 * The app will be ran as long as the appOff boolean is false.
 * 
 * @author Patrick Palmroos
 */
class ContactsApp {
    public static int currentWindow = 0;
    public static ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
    public static void main(String [] args) {
        userList = FileTranslator.fileToList();
        boolean appOff = false;

        while (!appOff) {
            switch (currentWindow) {
                case 0:     //0 corresponds to the start menu
                    UI.startMenuDisplay();
                    currentWindow = UserInput.numInput(1, 3);
                    break;
                case 1:     //the number 1 corresponds to contacts window
                    contactsWindow();
                    int tempWindow = UserInput.numInput(0, 
                        FileTranslator.contactCount());
                    if (tempWindow == 0) {
                        currentWindow = 0;
                    } else {
                        inspectInfo(tempWindow);
                    }
                    break;
                case 2:     //2 corresponds to the add contact window
                    userList.add(UserInput.askUserInfo());
                    DataWriter.updateContacts(userList);
                    userList = FileTranslator.fileToList();
                    UI.contactsDisplay(userList);
                    currentWindow = 1;
                    break;
                case 3:     //3 corresponds to closing the app
                    appOff = true;
                    break;
                default:    //shouldnt be possible to enter here
                    System.out.println("WINDOW POSITION ERROR");
                    break;
            }
        }
    }
/**
 * Opens the contact window. Is 2 times so more efficient to put it seperately
 */
    public static void contactsWindow() {
        userList = FileTranslator.fileToList();
        UI.contactsDisplay(userList);
    }

/**
 * used to inspect a specific users info. 
 * 
 * Displays the users sepcified contact and allows options for deleting and 
 * editing the contact in question.
 * 
 * @param input is the users input that corresponds to a specific user.
 */

    public static void inspectInfo(int input) {
        if (input <= FileTranslator.contactCount() && input > 0) {
            UI.inspectUser(userList, input - 1);
            int tempPosition = UserInput.numInput(0, 7);
            if (tempPosition == 0) {
                currentWindow = 1;
            } else if (tempPosition == 7) {
                userList.remove(input - 1);
                DataWriter.updateContacts(userList);
            } else {
                DataWriter.changeInfo(userList, input - 1, tempPosition);
                DataWriter.updateContacts(userList);
            }
        } else {
            System.out.println("Incorrect input");
        }
    }
}

/**
 * UserInfo object is an object used to store user information. 
 * 
 * Each UserInfo object is stored in a list that is saved in a text file. 
 * When the app is opened the file is read and the information is put into 
 * UserInfo objects.
 */
class UserInfo {
    private String firstName;
    private String lastName;
    private String personalId;
    private int phoneNum;
    private String address;
    private String eMail;

    public UserInfo() {

    }

    public void setFirstName(String fName) {
        if (fName.length() > 0) {
            firstName = fName;
        } else {
            System.out.println("First name is too short");
        }
    }

    public void setLastName(String lName) {
        if (lName.length() > 0) {
            lastName = lName;
        } else {
            System.out.println("Last name is too short");
        }
    }

    public void setPersonalId(String persId) {
        if (persId.length() == 11) {
            personalId = persId;
        } else {
            System.out.println("personal id is the wrong length");
        }
    }

    public void setPhoneNumber(int num) {
        if (num > 4) {
            phoneNum = num;
        } else {
            System.out.println("Incorrect phone number");
        }
    }

    public void setAddress(String address) {
        if (address.length() > 1) {
            this.address = address;
        } else {
            System.out.println("address too short");
        }
    }

    public void setEMail(String eMail) {
        if (eMail.length() >= 5) {
            for (int i = 0; i < eMail.length(); i++) {
                if (eMail.charAt(i) == '@') {
                    this.eMail = eMail;
                    break;
                }
            }
        } else {
            System.out.println("email length too short");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public int getPhoneNumber() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public String getEMail() {
        return eMail;
    }

}