import java.util.LinkedList;
/**
 * This class represents a Production line, where disks are assembled into ascending towers
 * @author Patrick Riley
 *
 */
public class ProductionLine {
	
	private LinkedList<Disk> input;
	private LinkedList<Tower> output;
	private Tower robotArm;

	public ProductionLine() {
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
	}
	
	/**
	 * gets the input queue
	 * @return the input queue
	 */
	public LinkedList<Disk> getInput() {
		return input;
	}


	/**
	 * gets the output queue
	 * @return the output queue
	 */
	public LinkedList<Tower> getOutput() {
		return output;
	}


	/**
	 * gets the disks on the "robot arm"
	 * @return the disks on the arm
	 */
	public Tower getRobotArm() {
		return robotArm;
	}

	
	/**
	 * adds a disk to the input queue
	 * @param d the disk to be added
	 */
	public void addDisk(Disk d) {
		input.add(d);
	}
	
	
	/**
	 * this creates the inverted disk tower on the robot's arm if there are things left in the input queue and then removes it from it
	 */
	public void process() {
		if (!input.isEmpty())
			robotArm.push(input.remove());
		while (!input.isEmpty() && input.peek().getRadius() >= robotArm.peek().getRadius())
			robotArm.push(input.remove());
	}
	
	
	/**
	 * This unloads the tower from the robot arm to the output queue in the correct way
	 */
	public void unloadRobot() {
		Tower toOutQueue = new Tower();
		while(!robotArm.isEmpty())
			toOutQueue.push(robotArm.pop());
		output.add(toOutQueue);
	}
	
	/**
	 * this will operate the robot until there are not input disks left
	 */
	public void run(){
		while(!input.isEmpty()){
			process();
			unloadRobot();
		}		
	}
	
	/**
	 * removes a tower from the output queue and returns it
	 * @return the first tower in the queue
	 */
	public Tower removeTower() {
		return output.remove();
	}

}