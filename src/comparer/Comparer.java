/**
 * 
 */
package comparer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
/**
 * @author Justin
 *
 */
import java.lang.*;
import java.io.*;
import java.*;
 



public class Comparer {

	
	class person{
		
		public String last;
		public String first;
		
	};
	
	
	/**
	 * 
	 */
	public Comparer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//compares two csv files to find missing items 
		findMissingAT();
		
		//TODO create method to 
			
	}
	private static List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<String>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter("\\r?\\n");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    return values;
	}
	private static void findMissingAT() throws FileNotFoundException, UnsupportedEncodingException {
		List<String> s1;
		 List<String> s2;
		 int counter=0;
		 int counterNot=0;
		 boolean found;
		 
		 ListIterator<List<String>> ADlitr = null;
		 ListIterator<List<String>> ATlitr2 = null;
		 
	//	System.out.println("test test1");
			
		
		ArrayList<List<String>> AD = new ArrayList<>();
		
		
		//Need to create function that allows input of file name for Active Directory user set  so it isnt hardcoded
	//	try (Scanner scanner = new Scanner(new File("20200709180724_9188.csv"));) {
		try (Scanner scanner = new Scanner(new File("HQ_Users.csv"));) {
		    while (scanner.hasNextLine()) {
		    	AD.add(getRecordFromLine(scanner.nextLine()));
		    }
		}
		
		ArrayList<List<String>> AT = new ArrayList<>();
		//20200709180724_9188b
		//book3
		
		//Need to create function that allows input of file name for ATCTS user set
	//	try (Scanner scanner = new Scanner(new File("20200709180724_9188b.csv"));) {
		try (Scanner scanner = new Scanner(new File("ATCTS.csv"));) {
		    while (scanner.hasNextLine()) {
		        AT.add(getRecordFromLine(scanner.nextLine()));
		    }
		}
		
		//new csv for users not found in ATCTS
		PrintWriter writer = new PrintWriter("output.csv", "UTF-8");
							
	System.out.println("Users in Active Directory " +AD.size());
	//System.out.println("Users in ATCTS " +AT.size());
		//need to strip both strings to make sure its all lower with no extraneous characters
		//iterator thru Active directory list looking for matches in ATCTS list
			//if not found export to new list
		ADlitr=AD.listIterator();
		 
		//while not at the end of the AD users
		while(ADlitr.hasNext()) {
			
			//convert current person into string to check if on AT list
			s1=ADlitr.next();
			
				//recreate iterator to step thru the AT list
				ATlitr2=AT.listIterator();
				found=false;
			//search AT list
				while(ATlitr2.hasNext()) {
				
						//current item converted into string for comparison	
						s2=ATlitr2.next();
						
					//	System.out.println(s2);
							//logic	
							if(s1.toString().toLowerCase().equals(s2.toString().toLowerCase())) {
									counter++;
									found = true;
					
									//if person found will output on console	
									System.out.println(s1 + " is " +  s2);
															
										//when found break out of loop
											break;		
									}
										
					}	
				//user not found output to file 
				if(found == false) {
					writer.println(s1);
					counterNot++;
					System.out.println(s1 + " not found");
				}
	
		}
			
		
		System.out.println(counter + " matches");	
		System.out.println(counterNot + " missing");	
		
		//close file		
		writer.close();
		
		
	}
}
