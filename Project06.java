/*
 * project06.java
 * 
 * A program that checks the last digit of your credit card.
 * 
 * @author Zhenli Min
 * @version 20181003
 */

package osu.cse1223;

import java.util.Scanner;

public class Project06 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a credit card number (enter a blank line to quit): ");
		String input = keyboard.nextLine();
		int checkDigit=0;
		
		while (input.length()!=0) {
			if (input.length()!=16) {
			System.out.println("ERROR! Number MUST have exactly 16 digits");}
			else if(input.length()==16) {
				int i=0;
				
				int sum = 0;
				while (i<15) {
					int cardNumber = Character.getNumericValue(input.charAt(i));
					if (i%2==0&&cardNumber<5) {
						cardNumber=cardNumber*2;}
					else if(i%2==0&&cardNumber>=5) {
								cardNumber=cardNumber*2-9;}
				sum=sum+cardNumber;
				i++;
				}
				if (sum%10==0) {
					checkDigit=0;}
				else {
				     checkDigit=10-(sum%10);}
				
				System.out.println("Check digit should be: "+checkDigit);
				System.out.println("Check digit is: "+ input.charAt(15));
			    
			    if(Character.getNumericValue(input.charAt(15))==checkDigit) {
			    	System.out.println("Number is valid");}
			    else {
			    System.out.println("Number is not valid");}
			}
			System.out.print("Enter a credit card number (enter a blank line to quit): ");
		    input = keyboard.nextLine();
		}
		System.out.println("Goodbye!");
	
	}
	}


