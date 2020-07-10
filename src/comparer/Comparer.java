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
 * @author Robin
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
		// TODO compare two csv/excel name lists 
		 List<String> s1;
		 List<String> s2;
		 int counter=0;
		 
		 
		 ListIterator<List<String>> ADlitr = null;
		 ListIterator<List<String>> ATlitr2 = null;
		 
	//	System.out.println("test test1");
			
		
		ArrayList<List<String>> AD = new ArrayList<>();
		//20200709180724_9188
		//book4
	//	try (Scanner scanner = new Scanner(new File("20200709180724_9188.csv"));) {
		try (Scanner scanner = new Scanner(new File("AD.csv"));) {
		    while (scanner.hasNextLine()) {
		    	AD.add(getRecordFromLine(scanner.nextLine()));
		    }
		}
		
		ArrayList<List<String>> ATCTS = new ArrayList<>();
		//20200709180724_9188b
		//book3
	//	try (Scanner scanner = new Scanner(new File("20200709180724_9188b.csv"));) {
		try (Scanner scanner = new Scanner(new File("AT.csv"));) {
		    while (scanner.hasNextLine()) {
		        ATCTS.add(getRecordFromLine(scanner.nextLine()));
		    }
		}
							
	System.out.println(AD.size());
	
		
		//iterator thru Active directory list looking for matches in ATCTS list
			//if not found export to new list
		ADlitr=AD.listIterator();
		
		
		while(ADlitr.hasNext()) {
			
			s1=ADlitr.next();
						
					
	//System.out.println(s1+ " - AD");
			ATlitr2=ATCTS.listIterator();
			while(ATlitr2.hasNext()) {
				
				//System.out.println(litr2.next());
				s2=ATlitr2.next();
								
			//	System.out.println(s2 + " - AT");
					
				if(s1.equals(s2)) {
					counter++;
					
				System.out.println(s1 + " is " +  s2);
			
				break;
					}
			 
			
				}
	
		}
			
		
		System.out.println(counter + " matches");	
		
	 
			
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
	
}
