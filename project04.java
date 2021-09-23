/*
 * Project04.java
 * 
 * A program that plays a simple game. 
 * 
 * @author Zhenli Min
 * @version 20180919
 */


package osu.cse1233;

import java.util.Scanner;

public class Project04 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
	
		System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");
		String input = keyboard.nextLine();
		String userinput = "";
		
		if (input.equals("F") || input.equals("f") || input.equals("Fire") || input.equals("FIRE") || input.equals("fire")) {
			userinput= "Fire";
			System.out.println("You chose: " + userinput + " dragon");}
		else if (input.equals("P") || input.equals("p") || input.equals("Plant") || input.equals("PLANT") || input.equals("plant")) {
			userinput= "Plant";
			System.out.println("You chose: " + userinput + " dragon");}
		else if (input.equals("W") || input.equals("w") || input.equals("Water") || input.equals("WATER") || input.equals("water")) {
			userinput= "Water";
			System.out.println("You chose: " + userinput + " dragon");}
		else {System.out.println("You don't have a " + input + " dragon, so you choose no dragons.");}

		int x = (int)(3 * Math.random()) + 1;
		
		String comInput="";
		if (x==1) {
			 comInput = "Fire";}
		else if (x==2) {
			comInput = "Plant";}
		else {comInput = "Water";}
		
		System.out.println("I chose: " + comInput + " dragon");
		
		if (userinput=="Fire" && comInput=="Fire") {
			System.out.println("A tie!");}
		else if (userinput=="Fire" && comInput=="Plant") {
			System.out.println("Fire defeats Plant - you win!");}
		else if (userinput=="Fire" && comInput=="Water") {
			System.out.println("Water defeats Fire - you lose!");}
		else if (userinput=="Water" && comInput=="Water") {
			System.out.println("A tie!");}
		else if (userinput=="Water" && comInput=="Fire") {
			System.out.println("Water defeats Fire - you win!");}
	    else if (userinput=="Water" && comInput=="Plant") {
		    System.out.println("Plant defeats Water - you lose!");}
	    else if (userinput=="Plant" && comInput=="Plant") {
		    System.out.println("A tie!");}
	    else if (userinput=="Plant" && comInput=="Fire") {
		    System.out.println("Fire defeats Plant - you lose!");}
	    else if (userinput=="Plant" && comInput=="Water") {
		    System.out.println("Plant defeats Water - you win!");}
	    else {System.out.println("You lose by default!");}
		
	}
	
}
