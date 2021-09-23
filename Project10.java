/*
 * Project10.java
 * 
 *   A program that plays and scores a round of the game Poker Dice.  In this game,
 *   five dice are rolled.  The player is allowed to select a number of those five dice
 *   to re-roll.  The dice are re-rolled and then scored as if they were a poker hand.  
 *   The following hands MUST be scored in this assignment:
 *   	* High card
 *   	* One Pair
 *   	* Two Pair
 *   	* Three of a Kind
 *   	* Full House
 *   	* Four of a Kind
 *   	* Five of a Kind
 *   For extra credit, you may also implement:
 *   	* Straight
 * 
 * @author Zhenli Min
 * 
 */
package osu.cse1223;
import java.util.Scanner;
import java.util.Arrays;

public class Project10 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		boolean replay=true;
		int[]dices=new int[5];
		while(replay) {
			resetDice(dices);
			rollDice(dices);
			System.out.println("Your current dice: "+diceToString(dices));
			promptForReroll(dices,in);
			System.out.println("Your final dice: "+diceToString(dices));
			System.out.println(getResult(dices));
			in.nextLine();
			replay=promptForPlayAgain(in);
		}
	}
	
	// Given an array of integers as input, sets every element of the array to zero.
	private static void resetDice(int[] dice) {
		for(int i=0;i<dice.length;i++) {
			dice[i]=0;
		}
	}
	
	// Given an array of integers as input, checks each element of the array.  If the value
	// of that element is zero, generate a number between 1 and 10 and replace the zero with
	// it.  Otherwise, leave it as is and move to the next element.
	private static void rollDice(int[] dice) {
		for(int i=0;i<dice.length;i++) {
			if(dice[i]==0) {
				dice[i]=(int)(Math.random()*6)+1;
			}
		}
	}
	
	// Given an array of integers as input, create a formatted String that contains the
	// values in the array in the order they appear in the array.  For example, if the 
	// array contains the values [0, 3, 7, 5, 2] then the String returned by this method
	// should be "0 3 7 5 2".
	private static String diceToString(int[] dice) {
		String input="";
		for(int i=0;i<dice.length;i++) {
			input=input+dice[i]+" ";
		}
		return input;
	}
	
	
	// Given an array of integers and a Scanner as input, prompt the user with a message
	// to indicate which dice should be re-rolled.  If the user enters a valid index (between
	// 0 and the total number of dice -1) then set the die at that index to zero.  If the 
	// user enters a -1, end the loop and return to the calling program.  If the user enters
	// any other invalid index, provide an error message and ask again for a valid index.
	private static void promptForReroll(int[] dice, Scanner inScanner) {
		System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
		int index=inScanner.nextInt();
		while(index<-1||index>4) {
			System.out.println("Error: Index must be between 0 and 4 (-1 to quit)!");
			System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
			index=inScanner.nextInt();
		}
		while (index!=-1) {
			dice[index]=(int)(Math.random()*7);
			System.out.println("Your current dice: "+diceToString(dice));
			System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
			index=inScanner.nextInt();
		}
		System.out.println("Keeping remaining dice...");
		System.out.println("Rerolling...");
		rollDice(dice);
	}
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	private static boolean promptForPlayAgain(Scanner inScanner) {
		System.out.print("Would you like to play again [Y/N]?: ");
		char input =inScanner.nextLine().charAt(0);
		boolean check = true;
		while(input!='y'&&input!='Y'&&input!='N'&&input!='n') {
			System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
			System.out.print("Would you like to play again [Y/N]?: ");
			input =inScanner.nextLine().charAt(0);
		}
		if (input=='y'||input=='Y') {
			check = true;
		}
		else {check=false;
		System.out.print("Goodbye!");
		}
		return check;
	}
	
	// Given an array of integers, determines the result as a hand of Poker Dice.  The
	// result is determined as:
	//	* Five of a kind - all five integers in the array have the same value
	//	* Four of a kind - four of the five integers in the array have the same value
	//	* Full House - three integers in the array have the same value, and the remaining two
	//					integers have the same value as well (Three of a kind and a pair)
	//	* Three of a kind - three integers in the array have the same value
	//	* Two pair - two integers in the array have the same value, and two other integers
	//					in the array have the same value
	//	* One pair - two integers in the array have the same value
	//	* Highest value - if none of the above hold true, the Highest Value in the array
	//						is used to determine the result
	//
	//	The method should evaluate the array and return back to the calling program a String
	//  containing the score from the array of dice.
	//
	//  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
	//		[1,2,3,4,5] or [2,3,4,5,6] or [3,4,5,6,7] etc..
	private static String getResult(int[] dice) {
		String result="";
		int[]count=getCounts(dice);
		Arrays.sort(count);
		Arrays.sort(dice);
		if(count[count.length-1]==5) {
			result="Five of a Kind!";
		}
		else if(count[count.length-1]==4) {
			result="Four of a kind!";
		}
		else if(count[count.length-1]==3) {
			if(count[count.length-2]==2) {
				result="Full House!";
			}
			else {result="Three of a Kind!";
			}
		}
		else if (count[count.length-1]==2) {
			if(count[count.length-2]==2) {
				result="Two Pair!";
			}
			else {result="One Pair!";
			}
		}
		else {
			if(dice[0]==dice[1]-1&&dice[1]==dice[2]-1&&dice[2]==dice[3]-1&&dice[3]==dice[4]-1) {
			result="Straight!";
		}
			else {result="Highest Card "+dice[4];
			}
		}
		return result;
	}
	
	// Given an array of integers as input, return back an array with the counts of the
	// individual values in it.  You may assume that all elements in the array will have 
	// a value between 1 and 10.  For example, if the array passed into the method were:
	//   [1, 2, 3, 3, 7]
	// Then the array of counts returned back by this method would be:
	// [1, 1, 2, 0, 0, 0, 1, 0, 0, 0]
	// (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
	//  2, index 2 holds the counts of the value 3, etc.)
	// HINT:  This method is very useful for determining the score of a particular hand
	//  of poker dice.  Use it as a helper method for the getResult() method above.
	private static int[] getCounts(int[] dice) {
		int[]count=new int[10];
		for(int i=0;i<dice.length;i++) {
			count[dice[i]-1]++;
		}
		return count;
	}

}