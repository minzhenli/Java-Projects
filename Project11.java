/*
 * Project11.java
 * 
 *   A program that reads in a text file that uses a specific input format and uses it to
 *   produce a formatted report for output.
 *   
 *   See the write-up for Homework Lab 13 for more details.
 *   
 *   This skeleton is more "skeletal" than previous labs.  You MUST break your code up into
 *   more methods than what you see here.  Consider methods to display the formatted report
 *   as well as more methods to compute values for the report.
 * 
 * @author Zhenli Min
 * 
 */
package osu.cse1223;
import java.io.*;
import java.util.*;

public class Project11 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an input file name: ");
		String input = in.nextLine();
		System.out.print("Enter an output file name: ");
		String output = in.nextLine();
		
		try {
			File file = new File(input);
			Scanner inputFile=new Scanner(file);
			PrintWriter outputFile=new PrintWriter(output);
			outputFile.println("Name                    Mean  Median   Max   Min");
			outputFile.println("------------------    ------  ------  ----  ----");
			
			int countName=0;
			ArrayList<String>names=new ArrayList<String>();
			ArrayList<Integer> avg=new ArrayList<Integer>();
			while(inputFile.hasNextLine()) {
				String name=inputFile.nextLine();
				if(!Character.isDigit(name.charAt(0))) {
					names.add(name);
					countName++;
					ArrayList<Integer>list=readNextSeries(inputFile);
					int max=getMax(list);
					int min=getMax(list);
					int median=getMedian(list);
					int average=getAverage(list);
					avg.add(average);
					outputFile.printf("%-18s %6d %6d %4d %4d\n",name,average,median,max,min);
				}
			}
			int max=0, min=0,i=0;
			while(i<avg.size()) {
				if(avg.get(i)>avg.get(max)) {
					max=i;
				}
				else {
					min=i;
				}
				i++;
			}
			outputFile.println("Total number of participants: "+countName);
			outputFile.println("Highest average score: "+names.get(max)+" ("+ avg.get(max)+")");
			outputFile.println("Lowest average score: "+names.get(min)+" ("+ avg.get(min)+")");
			outputFile.close();
			inputFile.close();
		}
		catch(IOException e) {
			System.out.println("There is a problem reading from " +input+" or writing to "+output);
		}
	}
	
	// Given a Scanner as input read in a list of integers one at a time until a negative
	// value is read from the Scanner.  Store these integers in an ArrayList<Integer> and
	// return the ArrayList<Integer> to the calling program.
	private static ArrayList<Integer> readNextSeries(Scanner inScanner) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int input = inScanner.nextInt();
		while (input>=0) {
			list.add(input);
			input = inScanner.nextInt();
		}
		return list;
	}
	
	
	// Given a ArrayList<Integer> of integers, compute the median of the list and return it to
	// the calling program.
	private static int getMedian(ArrayList<Integer> inList) {
		Collections.sort(inList);
		int median=0;
		if(inList.size()%2==1) {
			median=inList.get(inList.size()/2+1);
			}
		else {
			median=(inList.get(inList.size()/2)+inList.get(inList.size()/2+1))/2;
		}
		return median;
	}
	
	// Given a ArrayList<Integer> of integers, compute the average of the list and return it to
	// the calling program.
	private static int getAverage(ArrayList<Integer> inList) {
		int sum=0;
		for(int i=0;i<inList.size();i++) {
			sum=sum+inList.get(i);
		}
		int avg=sum/inList.size();
		return avg;
	}
	
	private static int getMax(ArrayList<Integer> inList) {
		Collections.sort(inList);
		int max=inList.get(inList.size()-1);
		return max;
	}
	
    private static int getMin(ArrayList<Integer> inList) {
    	Collections.sort(inList);
		int min=inList.get(0);
		return min;
	}

}