/**
 * 
 */
package comparer;

import java.util.ArrayList;
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
		String string;
		
		//array for AD holding person data types
		ArrayList AD = new ArrayList<person>();
		
		//array for atcts holding person data types
		ArrayList ATCTS = new ArrayList<person>();
		
		//hardcoded csv file loaded into AD array
		//TODO add file location 
		FileReader ADFILE = null;
		try {
			ADFILE = new FileReader("20200709180724_9188.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getLocalizedMessage();
		}
		BufferedReader ADF=new BufferedReader(ADFILE);
		
		
		//hardcoded csv file loaded into ATCTS array
		try {
			FileReader ATFILE = new FileReader("20200709180724_9188.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//while not eof load last, first into person object
		
			
			
			//grab both last name first name using loop
			
			AD.add(ADF.readLine().split("\\r?\\n"));		
			
				//person.last = ADFILE
				
			
			
		
	
		
			

	}
	private static void inputfiles(){}
}
