import java.util.*;
import java.io.*;

public class BusinessCardParser {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        //an arraylist for managing strings such as names
        ArrayList<String> list = new ArrayList<String>();
        //allows the program to access new objects found in the ContactInfo class for get/set methods
        ContactInfo document = new ContactInfo();
        String inFileName;
        File inFile;
        //Welcome message for users to input desired text files by name
        System.out.println("\n---------- Business Card OCR ----------\n");
        System.out.print("Please enter the name of your file: ");
        int done = 0;

        //this do-while statement allows user to choose their own file
        do {
          //try/catch statements ensures successful file IO
            try {
                inFileName = input.nextLine();
                inFile = new File(inFileName);
                //Scanner reads the file contents
                Scanner fileIn = new Scanner(inFile);
                try {
                  //while statement for analyzing a file line-by-line and match with
                    while (fileIn.hasNextLine()) {
                        String line = fileIn.nextLine();
                        findName(line, list, document);
                        findPhoneNumber(line, document);
                        findEmailAddress(line, document);
                    }
                    //Returns the correct information of a specific text file
                    System.out.println("Name: " + document.getName());
                    System.out.println("Phone: " + document.getPhoneNumber());
                    System.out.println("Email: " + document.getEmailAddress());
                    input.close();
                  //find exceptions and errors with user input
                } catch (Exception e) {
                   e.printStackTrace();
                }
                //closes the scanner and exits
                done = 1;
                fileIn.close();
              //detects and alerts the user of an error
            } catch (FileNotFoundException e) {
                System.out.println("Error. File not found. Please try again. ");
            }
        } while (done != 1);
    }

/*_______________________________________________________________________________________________________________________________________
In order to find the name on a business card, it is inferred that the name begin and end with letters
as well as contain special characters such as ".", " ", and "''". It is also inferred that a name on
a business card is the shortest string in length however, this is not always the case. In the future,
implementing a more effective and efficient method will prove to increase the accuracy of this program
in terms of retrieving names.
__________________________________________________________________________________________________________________________________________*/
    public static void findName(String line, ArrayList<String> list, ContactInfo document) {
      //a line in the given file must begin with letters and end with letters
        if (line.matches("^[a-zA-Z\\ \\.\\']*[a-zA-Z]$")) {
          //strings that meet this condition are added to an array list in order to determine the shortest length
            list.add(line);
        }
        String shortest = "";
        //the for loop evaluates the length of each line in the list until the shortest length is returned
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                //calculating length
                shortest = list.get(i);
            }
            if (list.get(i).length() < shortest.length()) {
                shortest = list.get(i);
            }
        }
        //the shortest string containing letters are returned
        String nameOut = shortest;
        document.setName(nameOut);
    }
/*_______________________________________________________________________________________________________________________________________
In order to find the phone number in a business card, regex was implemented where a line must match certain qualifications.
To avoid retrieving fax numbers, this regex requires string's to begin with the letter "P" for Phone or "T" for telephone.
Additionally, this regex also requires that a string begins with any digit (zero to nine), a period, addition sign, or open
parenthesis in order to accomodate for a variety of phone number formats. It also requires that a line must end with any digit
(zero to nine). After matching the correct pattern, teh "if" statement will replace all characters excluding deigits and the
following output will return only digits.
__________________________________________________________________________________________________________________________________________*/
    public static void findPhoneNumber(String line, ContactInfo document) {
        //if the line in the list match then add it to the list
        String phoneType = "^[P|T|(|(\\d)](.)+([\\d]$)";
        String phoneNumberOut = "";
        if (line.matches(phoneType)) {
          //lines that the regex for correct phone format will have all nondigit characters replaced with ""
          //to retrieve digits only
            phoneNumberOut = line.replaceAll("[\\D]+", "");
            document.setPhoneNumber(phoneNumberOut);
        }
    }
/*_______________________________________________________________________________________________________________________________________
The function of this method is to return an email address. Through the use of matching the document's lines with regex, the "@"
symbol is required in order to match email addresses; assuming all emails contain the "@" symbol. This regex also includes other
optional characters that may or may not be present emails such as a period, underscore, or hyphen and the line must end with a letter.
__________________________________________________________________________________________________________________________________________*/
    public static void findEmailAddress(String line, ContactInfo document) {
        if (line.matches("^[\\w]*([\\.\\_\\-]+)?[\\w]*[@][\\w\\.]*")) {
            String emailAddressOut = line;
            //detects and returns lines containing "@" as the email address
            document.setEmailAddress(emailAddressOut);
        }
    }
}
