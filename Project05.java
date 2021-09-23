/*
 * Project05.java
 * 
 * A program that plays a game about guessing number.
 * @author Zhenli Min
 * @version 20180926
 */

package osu.cse1223;

import java.util.Scanner;

public class Project05 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a guess between 1 and 200: ");
		int input = keyboard.nextInt();
		int random = (int)(200*Math.random())+1;
		int tries=1;
		
		while (input!=random) {
		
		if (input<random && input>=1) {
			System.out.println("Your guess was too low. Try again.");}
		else if (input>random && input<=200) {
			System.out.println("Your guess was too high. Try again.");}
		else {
			System.out.println("Your guess is out of range. Pick a number between 1 and 200.");}
		tries++;
		System.out.println();
		System.out.print("Enter a guess between 1 and 200: ");
	    input = keyboard.nextInt();}
		
		System.out.println("Congratulations! Your guess was correct!");
		System.out.println();
		System.out.println("I had chosen "+random+" as the target number.");
		System.out.println("You guessed it in "+tries+" tries.");
		
		if (tries==1) {
			System.out.println("That was astounding!");}
		else if (tries>=2&&tries<=4) {
			System.out.println("That was lucky!");}
		else if (tries>=5&&tries<=6) {
			System.out.println("That was pretty good.");}
		else if (tries==7) {
			System.out.println("That was not that inpressive.");}
		else if (tries>=8&&tries<=9) {
			System.out.println("Are you sure this is the right game for you?");}
		else if (tries>=10) {
			System.out.println("This just isn't your game, is it?");}
	}
		
}

