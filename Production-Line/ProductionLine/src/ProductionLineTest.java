import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Patrick
 *
 */
public class ProductionLineTest {

	/**
	 * @param args command line args
	 */
	public static void main(String[] args) {
		String fileName = "";
		Scanner keyboard = new Scanner(System.in);

		if (args.length == 1)
			fileName = args[0];
		else {
			System.out.print("\nEnter output file name: ");
			fileName = keyboard.nextLine().trim();
		}

		PrintWriter out = null;

		try {
			out = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Random rand = new Random(1388420);
		Random rand = new Random();
		/*
		out.println("Testing Disks: ");
		Disk d1 = new Disk(5);
		out.println("d1: " + d1);
		Disk d2 = new Disk(4);
		out.println("d2: " + d2);
		Disk d3 = new Disk(3);
		out.println("d3: " + d3);
		Disk d4 = new Disk(5);
		out.println("d4: " + d4);
		Tower t1 = new Tower();
		t1.add(d1);
		t1.add(d2);
		t1.add(d3);
		t1.add(d4);
		out.println("Tower of all previous disks: " + t1);
*/
		out.println("Testing ProductionLine: ");
		ProductionLine p1 = new ProductionLine();
		for (int i = 0; i < 20; i++)
			p1.addDisk(new Disk(rand.nextInt(9)+1));
		
		out.println("Input Queue before start: " + p1.getInput());
		out.println("Output Queue before start: " + p1.getOutput());
		
		p1.run();
		
		out.println("Input Queue after Processing: " + p1.getInput());
		out.println("Output Queue after Processing: ");
		while(!p1.getOutput().isEmpty())
			out.println(p1.removeTower());
		
		
		keyboard.close();
		out.close();
	}

}
