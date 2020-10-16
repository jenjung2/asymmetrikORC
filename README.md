# asymmetrikORC
## Asymmetrik Programming Challenge 1 - Business Card OCR

The objective of this programming challenge was to create a command line tool to parse information from business cards.
More specifically, parsing results of a optical character recognition component find the name, phone number, and email address in the card.
Furthermore, implementing a specific interface was required as well as testing the program with three example cases.

This program was created using Mac OS and written in Java. In order to build and run this program, a compatible system is required as well as installing Java Developer Kit and Java Runtime Environment.
Any text editor may be used to create this program however, to minimize errors it is highly recommended to use a source code editor software.
For this challenge, Atom editor was used on a Mac OS.

# Building Solution 
Building this solution involves three major components; retrieving the name, phone number, and email address from given text files.
The program will be able to read external files through the input output package.
Using regular expressions to match a certain line in a given file is used to find the name, phone number, and email address.
In addition to using regular expressions for finding a name in a file, an if statement is implemented to find the shortest length of a line of text that also includes only letters.
This is to return the name of the contact assuming that the name will always be the shortest length.
The name, email, and phone number found in each method are then set as new objects found in the ContactInfo class to implement get and set methods.
The program then prints the name, phone number, and email address found in the file.

The ContactInfo.java class is a public class used for getting and setting objects and methods into the BusinessCardParser.java class.
The BusinessCardParser.java class is a public class used for parsing information from a text file that is inserted by the user. This class returns the name, phone number, and email address found in the file.

# Running Solution 
To compile the program

To start the program

# Testing Solution
Running the examples
