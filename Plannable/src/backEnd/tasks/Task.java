package backEnd.tasks;

import java.time.LocalTime;

/**
 * Task is the abstract base class for all events.
 * Each Task has a name for easy identification, priority
 * which is for use in the calendar algorithm, startTime and
 * endTime which signify the boundary of the task block. 
 */
abstract public class Task {
	
	private String name;
	private int priority;
	private LocalTime startTime;
	private LocalTime endTime;
	
	/**
	 * The Task constructor.
	 * 
	 * @param n		the name of the task
	 * @param sT	the start time
	 * @param eT	the end time
	 * @param p		the priority
	 */
	public Task(String n, LocalTime sT, LocalTime eT, int p){
		this.name = n;
		this.priority = p;
		this.startTime = sT;
		this.endTime = eT;
	}
	
	public int getPriority(){
		return this.priority;
	} 
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	/*
	public int getStartTimeAsInt(String startTime){
		int result = 0;
		String hour = startTime.substring(0, startTime.indexOf(":"));
		result = result + (Integer.parseInt(hour)*2);
		String minutes = startTime.substring(startTime.indexOf(":")+1);
		if(minutes.equals("30"))
			result++;
		return result;
	}
	
	public int getEndTimeAsInt(String endTime){
		int result = 0;
		String hour = endTime.substring(0, endTime.indexOf(":"));
		result = result + (Integer.parseInt(hour)*2);
		String minutes = endTime.substring(endTime.indexOf(":")+1);
		if(minutes.equals("30"))
			result++;
		return result;
	}
	*/

	@Override
	public String toString() {
		return "Task " + name + " [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
