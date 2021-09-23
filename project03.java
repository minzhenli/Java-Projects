/*
 * Project03.java
 * 
 * A program that will run a simple math quiz. 
 * @author Zhenli Min
 * @version 20180912
 */

package osu.cse1223;

import java.util.Scanner;

public class Project03 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = keyboard.nextLine();
		System.out.println("Welcome " + name + "! Please answer the following questions:");
		System.out.println();
		
		int x = (int)(20 * Math.random()) + 1;
		int y = (int)(20 * Math.random()) + 1;
		int CorrectAnswer = 0;
		
		System.out.print(x + " + " + y + " = ");
		int a = keyboard.nextInt();
		if (a==(x+y)) {
			 System.out.println("Correct!");
			 CorrectAnswer++;}
		else {System.out.println("Wrong!");
		      System.out.println("The correct answer is " + (x+y));}
		System.out.println();
		
		System.out.print(x + " * " + y + " = ");
		int b = keyboard.nextInt();
		if (b==(x*y)) {
			System.out.println("Corrrect!");
			CorrectAnswer++;}
		else {System.out.println("Wrong!");
		      System.out.println("The correct answer is " + (x*y));}
		System.out.println();
		
		System.out.print(x + " / " + y + " = ");
		int c = keyboard.nextInt();
		if (c==(x/y)) {
			System.out.println("Correct!");
			CorrectAnswer++;}
		else {System.out.println("Wrong!");
		      System.out.println("The correct answer is " + (x/y));}
		System.out.println();
		
		System.out.print(x + " % " + y + " = ");
		int d = keyboard.nextInt();
		if (d==(x%y)) {
			System.out.println("Corrrect!");
			CorrectAnswer++;}
		else {System.out.println("Wrong!");
		      System.out.println("The correct answer is " + (x%y));}
		System.out.println();
		
		int numerator = CorrectAnswer;
		double demoninator = 4.0;
		double quotient = (numerator/demoninator)*100;
		System.out.println("You got " + numerator + " correct answers");
	    System.out.println("That's " + quotient + "%!");
	}

}
