package backEnd.tasks;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Sleep extends Task {

	/**
	 * Constructor for the sleep class which is a subclass of Task
	 * 
	 * @param startTime
	 * @param endTime
	 * @param sleepTime
	 */
	public Sleep(LocalTime startTime, LocalTime endTime, int sleepTime){
		super("Sleep", startTime, endTime, 0);
	}
	
	/**
	 * Calculates the amount of sleep time in HOURS for this block by subtracting startTime from endTime
	 * 
	 * 
	 * @return
	 */
	public long getSleepInHours(){
		LocalTime beginning = this.getStartTime();
		LocalTime ending = this.getEndTime();
	
		return beginning.until(ending, ChronoUnit.HOURS);
		
	}
	
	
}
