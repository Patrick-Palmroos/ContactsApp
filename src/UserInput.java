import java.io.Console;

/**
 * The class used for taking user input.
 * 
 * @author Patrick Palmroos
 */
public class UserInput {

/**
 * Takes number input and validates it
 * @param min is the minimum the num can be
 * @param max is the max the num can be
 * @return the number from the user
 */
    public static int numInput(int min, int max) {
        Console c = System.console();
        int returnableInt = 0;
        boolean correctInput = false;

        while (!correctInput) {
            try {
                returnableInt = Integer.parseInt(c.readLine());
                if (returnableInt >= min && returnableInt <= max) {
                    correctInput = true;
                } else {
                    System.out.println("Number must be from the range of " + 
                        min + " - " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("input must be a number");
            }
        }

        return returnableInt;
    }
/**
 * Same as numInput but counts the amount of numbers instead
 * @param min is the minimum the num can be
 * @param max is the max the num can be
 * @return the numbers from the user
 */
    public static int numInputByCount(int min, int max) {
        Console c = System.console();
        int returnableInt = 0;
        boolean correctInput = false;

        while (!correctInput) {
            try {
                String temp = c.readLine();
                returnableInt = Integer.parseInt(temp);
                if (temp.length() <= max && temp.length() >= min) {
                    correctInput = true;
                } else {
                    System.out.println("Number must be the lenght between " + 
                    min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("input must be a number");
            }
        }

        return returnableInt;
    }
/**
 * allows user to give text input.
 * 
 * @param minLength is the minimum the text can be
 * @param maxLength is the max the text can be
 * @param allowWhiteSpace if spaces are allowed or not
 * @return the users text
 */
    public static String txtInput(int minLength, int maxLength, 
            boolean allowWhiteSpace) {
        Console c = System.console();
        boolean correctInput = false;
        String input = "";

        while (!correctInput) {
            input = c.readLine();
            if (input.length() >= minLength && input.length() <= maxLength && 
                    allowWhiteSpace) {
                correctInput = true;
            } else if (input.length() >= minLength && input.length() <= 
                    maxLength && !allowWhiteSpace) {
                String temp = "";
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == ' ') {
                        temp += "_";
                    } else {
                        temp += input.charAt(i);
                    }
                }
                input = temp;
                correctInput = true;
            } else {
                System.out.println("lentgth must be between " + minLength + "-" 
                + maxLength);
            }
        }
        return input;
    }
/**
 * asks the user info for a new contact from the user
 * @return new UserInfo object.
 */
    public static UserInfo askUserInfo() {
        UserInfo createdUser = new UserInfo();

        UI.printCustomText("Give your first name:");
        createdUser.setFirstName(UserInput.txtInput(1, 
        50, false));

        UI.printCustomText("Give your last name:");
        createdUser.setLastName(UserInput.txtInput(1, 50, 
            false));

        UI.printCustomText("Give your personal id:");
        createdUser.setPersonalId(UserInput.txtInput(11,  
            11, false));

        UI.printCustomText("Give your phone number:");
        createdUser.setPhoneNumber(UserInput.numInputByCount(4, 20));

        UI.printCustomText("Give your address");
        createdUser.setAddress(UserInput.txtInput(1, 50,  
            false));

        UI.printCustomText("Give your email");
        createdUser.setEMail(UserInput.txtInput(1, 50, 
            false));

        return createdUser;
    }
}
