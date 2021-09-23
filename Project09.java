/**
 * Project09.java
 *
 *   A program that converts binary numbers into decimal numbers.
 *   Used to practice breaking code up into methods.
 *
 *   @author Zhenli Min
 */
package osu.cse1223;
import java.util.Scanner;

public class Project09 {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String binary=promptForBinary(in);
       while (binary.length()!=0) {
        	int decimal= binaryToDecimal(binary);
        	System.out.println("The binary value "+binary+" is "+decimal+" in decimal (base 10).");
        	binary=promptForBinary(in);
        }
       if (binary.length()==0) 
       	System.out.println("Goodbye");
       }

    /**
     * Given a Scanner as input, prompt the user to enter a binary value. Use
     * the function checkForBinaryValue below to make sure that the value
     * entered is actually a binary value and not junk. Then return the value
     * entered by the user as an String to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a String representing a binary value read from the user
     */
    public static String promptForBinary(Scanner input) {
        System.out.print("Enter a binary value (empty line to quit): ");
        String binary = input.nextLine();
        while(!checkForBinaryValue(binary) && binary.length()>0) {
        	 System.out.println(
                     "ERROR - invalid binary value");
             System.out.print(
                     "Enter an binary value (empty line to quit): ");
             binary = input.nextLine();
         }
         return binary;
        }
  

    /**
     * Given a String as input, return true if the String represents a valid
     * binary value (i.e. contains only the digits 1 and 0). Returns false if
     * the String does not represent a binary value.
     *
     * @param value
     *            A String value that may contain a binary value
     * @return true if the String value contains a binary value, false otherwise
     */
    public static boolean checkForBinaryValue(String value) {
        
        boolean check = true;
        
        for (int i = 0;i<value.length();i++) {
        	if (value.charAt(i)!='1'&& value.charAt(i)!='0') {
        		check = false;
        	}
        }
        return check;
    }

    /**
     * Given a binary value, return an int value that is the base 10
     * representation of that value. Your implementation must use the algorithm
     * described in the Project 9 write-up. Other algorithms will receive no
     * credit.
     *
     * @param value
     *            A String containing a binary value to convert to integer
     * @return The base 10 integer value of that binary in the String
     */
    public static int binaryToDecimal(String value) {
    	int result=0;
    	int index=0;
    	int n=value.length()-1;
    	while (index<value.length()) {
    		int a =Character.getNumericValue((value.charAt(index)));
    		result=result+(int)(a*Math.pow(2, n));
    		index++;
    		n--;
    	}
        return result;
    }
}