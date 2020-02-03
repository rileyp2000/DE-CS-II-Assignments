/**
 * <p></p> 
 * Sep 19, 2017
 * @author Patrick Riley
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordChooser {

	/**
	 * 
	 * @return Scanner a scanner of the txt file
	 * @param fname is a file name
	 */
	public static Scanner fileRead(String fname) {

		File file = new File(fname);
		Scanner input = null;

		try {

			input = new Scanner(file);

		} catch (FileNotFoundException ex) {

			System.out.println("Cant open file: " + ex.getMessage() + " " + fname);
			return null;

		}

		return input;

	}

	/**
	 * @param fname a file name
	 * @return
	 *
	 * 		PrintWriter of the file
	 */
	public static PrintWriter fileWrite(String fname) {
		File file = new File(fname);
		PrintWriter output = null;

		try {

			output = new PrintWriter(file);

		} catch (FileNotFoundException ex) {

			System.out.println("Cant open file: " + ex.getMessage() + " " + fname);
			return null;

		}

		return output;

	}
	/**
	 * 
	 * @param out
	 *
	 *void
	 */
	
	public static void writeHeader(PrintWriter out) {
		out.println("public class RamblecsDictionary\n{"
				+ "\tprivate String[] words = \n\t{");
	}
	
	/**
	 * 
	 * @param out
	 *
	 *void
	 */
	public static void writeFooter(PrintWriter out) {
		out.println("\t};\n}");
	}
	
	/**
	 * 
	 * @param in takes in a Scanner
	 * @param out takes in a PrintWriter
	 *
	 *void
	 */
	public static void writeJava(Scanner in, PrintWriter out) {

		while (in.hasNextLine()) {
			String word = in.nextLine().toUpperCase();
			if (word.length() >= 3 && word.length() <= 5)
				out.println("\t\t\"" + word + "\",");
		}

	}

	/**
	 * @param args CL Arguments
	 *
	 * 
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Not enough files my dude");
			System.exit(1);
		}
		
		Scanner in = fileRead(args[0]);
		if (in == null)
			System.exit(1);

		PrintWriter out = fileWrite(args[1]);
		
		writeHeader(out);
		writeJava(in, out);
		writeFooter(out);
		
		in.close();
		out.close();

	}

}
