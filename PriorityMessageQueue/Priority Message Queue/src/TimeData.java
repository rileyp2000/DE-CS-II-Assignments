/**
 * This class represents the data of a removed message
 * @author Patrick
 *
 */
public class TimeData {
	private int timeRemoved, waitTime;
	
	public TimeData(int tr, int wt){
		timeRemoved = tr;
		waitTime = wt;
		
	}
	
	@Override
	public String toString(){
		return "R: " + timeRemoved + " W:" + waitTime;
	}

	/**
	 * @return the timeRemoved
	 */
	public int getTimeRemoved() {
		return timeRemoved;
	}

	/**
	 * @return the waitTime
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * @param timeRemoved the timeRemoved to set
	 */
	public void setTimeRemoved(int timeRemoved) {
		this.timeRemoved = timeRemoved;
	}

	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	
	
}
