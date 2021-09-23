/*
 * Project01.java
 * A simple program that can do some calculations. 
 * 
 * @author Zhenli Min
 * @version 20180829
 * 
 */

package osu.cse1223;

import java.util.Scanner;

public class project01 {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the first number: ");
	    int number1 = keyboard.nextInt();
	    System.out.print("Enter the second number: ");
	    int number2 = keyboard.nextInt();
	    int sum= number1 + number2;
	    System.out.println(number1 + " + " + number2 + "= " + sum);
	    System.out.println(number1 + " - " + number2 + "= " + (number1 - number2));
	    System.out.println(number1 + " * " + number2 + "= " + (number1 * number2));
	    System.out.println(number1 + " / " + number2 + "= " + (number1 / number2));
	    System.out.println(number1 + " % " + number2 + "= " + (number1 % number2));
	    int average= (number1 + number2)/2; 
	    System.out.println("The average of your two numbers is: " + average);
	    		
	    
	}

}
