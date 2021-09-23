/*
 * Project07.java
 * 
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods. 
 * 
 * @author Zhenli Min
 * @version 20181010
 */
package osu.cse1223;
import java.util.Scanner;

public class Project07 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int pool=100;
		int bet = getBet(in,pool);
	
		while(bet!=0&&pool>0) {
			char hls = getHighLow(in);
			int roll1 = getRoll();
			int roll2 = getRoll();
			int total = roll1+roll2;
			System.out.println("Die 1 rolls: "+roll1);
			System.out.println("Die 2 rolls: "+roll2);
			
			int win = determineWinnings(hls,bet,total);
		if (win>0) {
			System.out.println("You won "+win+" dollars!");}
		else {System.out.println("You lost!");}
		System.out.println();
		pool=pool+win;
		if (pool>0) {
			bet = getBet(in,pool);
		}
		}
		if (bet==0||pool<=0) {
			if (pool<=0) {
				pool=0;}
			System.out.println();
			System.out.println("You have "+pool+" dollars left");
			System.out.println("Goodbye!");
		}
	}
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	private static int getBet(Scanner inScanner, int currentPool) {
		System.out.println("You have "+currentPool+" dollars.");
		System.out.print("Enter an amount to bet (0 to quit): ");
		int bet = inScanner.nextInt();
		while (bet<0 ||bet>currentPool) {
				System.out.println("Your bet MUST be between 0 and "+currentPool+" dollars");
				System.out.println("You have "+currentPool+" dollars.");
				System.out.print("Enter an amount to bet (0 to quit): ");
				bet = inScanner.nextInt();
		}
		return bet;
	}
	
	// Given a Scanner, prompt the user for a single character indicating whether they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	private static char getHighLow(Scanner inScanner) {
		System.out.print("High, low or sevens (H/L/S): ");
		char hls = inScanner.next().charAt(0);
		
		while (hls!='h'&&hls!='H'&&hls!='l'&&hls!='L'&&hls!='s'&&hls!='S') {
			System.out.println("ERROR! Input should be one of H/L/S");
			System.out.print("High, low or sevens (H/L/S): ");
			hls = inScanner.next().charAt(0);
		}
		return hls;
	}
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	private static int getRoll() {
		int roll = (int)(6*Math.random())+1;
		return(roll);
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	private static int determineWinnings(char highLow, int bet, int roll) {
		int win = 0;
		if (highLow=='H'&&roll>=8||highLow=='h'&&roll>=8) {
			win=bet;}
		else if (highLow=='L'&&roll<=6||highLow=='l'&&roll<=6) {
			win=bet;}
		else if (highLow=='S'&&roll==7||highLow=='s'&&roll==7) {
			win=bet*4;}
		else {win=-bet;}
		return win;
	}

}
