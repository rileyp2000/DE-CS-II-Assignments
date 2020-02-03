/**
 * 
 * @author Patrick Riley
 */

/**
 * <p>This program takes a text file, creates an index (by line numbers)
 *  for all the words in the file and writes the index
 *  into the output file.  The program takes input and output file names
 *  from the command-line args or prompts the user for the file names.
 *  This file was based upon the chapter 11 indexmaker class from that lab</p>
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:

    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }
    
    BufferedReader inputFile = null;
    
    try{
    	inputFile = new BufferedReader(new FileReader(fileName), 1024);
    }
    catch(FileNotFoundException ex) {
    	System.out.println("This file does not exist!");
    	System.exit(1);
    	
    }

    String readInFile = fileName;
    
    // Create output file:

    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }
    
    //if an output filename is not provided, this creates one based off the input file name
    if(fileName.equals("")) {
    	if(!readInFile.contains("."))
    		fileName = readInFile + "Index.txt";
    	else
    		fileName = readInFile.substring(0, readInFile.lastIndexOf(".")) + "Index" + readInFile.substring(readInFile.lastIndexOf("."));
    	
    }
    
    PrintWriter outputFile =
                 new PrintWriter(new FileWriter(fileName));

    
    
    outputFile.println("***Tests for IndexMaker***\n\n");
    
    IndexEntry n1 = new IndexEntry("hello");
	n1.add(0);
	n1.add(1);
	n1.add(2);
	n1.add(3);
	outputFile.println("New IndexEntry for word 'hello' on lines 0,1,2, and 3: " + n1);
	
    IndexEntry n2 = new IndexEntry("test", 4);
    outputFile.println("New IndexEntry for word 'test' on line 4: " + n2);
    
    IndexEntry n3 = new IndexEntry(n2);
    outputFile.println("Copy of the previous IndexEntry: " + n3);
    
    outputFile.println("Compare n1 and n2: " + n1.compareTo(n2));
    
    outputFile.println("\n\n**Tests for DocumentIndex***\n\n");
    
    
    
    // Create index:

    DocumentIndex index = new DocumentIndex();

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    // Save index:
    outputFile.println("Index for " + readInFile + ": ");
    outputFile.println(index);
    

    // Finish:

    inputFile.close();
    outputFile.close();

    keyboard.close();
    System.out.println("Done.");
  }
}

