/*
 * Project02.java
 * A program that allows me to make use of a variety of String methods. 
 * 
 * @author Zhenli Min
 * @version 20180904
 */

/*EXTRA CREDIT
 * When I input a substring that does not exist in the long string, I cannot run the whole program. 
 * It only shows up to the length of my substring. 
 * I think the error appears because of the 32nd line of my code.
 * I would fixed it by using the "if/else" structure which allows the program to show a sentence states that substring does not appear in the string if it happens.
 */

package osu.cse1223;

import java.util.Scanner;

public class Project02 {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a long string: ");
		String str = keyboard.nextLine();
		System.out.print("Enter a substring: ");
		String sub = keyboard.nextLine();
		
		System.out.println("Length of your string: " + str.length());
		System.out.println("Length of your substring: " + sub.length());
		
		String before = str.substring(0, str.indexOf(sub));
		String after = str.substring((str.indexOf(sub)+sub.length()), str.length());
		
		System.out.println("Starting position of your substring in string: " + str.indexOf(sub));
		System.out.println("String before your substring: " + before);
		System.out.println("String after your substring: " + after);
		
		System.out.print("Enter a position between 0 and " + (str.length() - 1) + ": ");
		int x = keyboard.nextInt();
		System.out.println("The Character at position " + x + " is " + str.charAt(x));
		keyboard.nextLine();
		System.out.print("Enter a replacement string: ");
		String replacement = keyboard.nextLine();
		
		System.out.println("Your new string is: " + before + replacement + after);
		
	}

}
