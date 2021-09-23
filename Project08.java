/**
 * Project08.java
 *
 *   A program that converts decimal numbers into binary numbers.
 *   Used to practice breaking code up into methods.
 *
 *   @author Zhenli Min
 */

package osu.cse1223;
import java.util.Scanner;

public class Project08{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
      
        int x =  promptForDecimal(in); 
        while(x>=0)
        {
            String binary=decimalToBinary(x);
            System.out.println("The decimal value "+x+" is "+binary+" in binary.");
            x =  promptForDecimal(in);
        }
        if (x<0) {
        	System.out.println("Goodbye");
        }
    }

    /**
     * Given a Scanner as input, prompt the user to enter an integer value. Use
     * the function checkForValidDecimal below to make sure that the value
     * entered is actually a decimal value and not junk. Then return the value
     * entered by the user as an integer to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a valid integer value read from the user
     */
    public static int promptForDecimal(Scanner input) {
        System.out.print("Enter an integer value (negative value to quit): ");
        String val = input.nextLine();
       while (!checkForValidDecimal(val)) {
            System.out.println(
                    "ERROR - value must contain only digits");
            System.out.print(
                    "Enter an integer value (negative value to quite): ");
            val = input.nextLine();
        }
        return Integer.parseInt(val);
    }

    /**
     * Given a String as input, return true if the String represents a valid
     * integer value (i.e. contains only digits, with possibly a '-' character
     * in the first position indicating a negative value). Returns false if the
     * String does not represent an integer value.
     *
     * Note that you must NOT use Exception Handling to implement this. If you
     * search on the net for solutions, that is what you will find but you
     * should not use it here - you can solve this using only what we have
     * discussed in class.
     *
     * Note too that your code does not need to worry about the number
     * represented being too large or too small (more than Integer.MAX_VALUE or
     * less than Integer.MIN_VALUE. Just worry about the constraints given above
     * for now (but for a challenge, try to figure out how to do it using only
     * what you have learned so far in class - it is not a simple problem to
     * solve.)
     *
     * @param value
     *            A String value that may contain an integer input
     * @return true if the String value contains an integer input, false
     *         otherwise
     */
    public static boolean checkForValidDecimal(String value) {
    	int i = 0;
    	boolean check = true;
    	if(value.charAt(0) == '-')
    	{
    		check = true;
    		i = value.length();
    	}
    	while (i<value.length()) {
    		if (!Character.isDigit(value.charAt(i))) {
    			check = false;
    		}
    		i++;
    	}
    	return check;
    }

    /**
     * Given an integer value, return a String that is the binary representation
     * of that value. Your implementation must use the algorithm described in
     * the Project 8 write-up. Other algorithms will receive no credit.
     *
     * @param value
     *            An integer value to convert to binary
     * @return A String containing the binary representation of value
     */
    public static String decimalToBinary(int value) {
        String binary="";
        while(value!=0) {
        	int x=value%2;
        	binary=x+binary;
        	value=value/2;
        }
        return binary;
    }

}
