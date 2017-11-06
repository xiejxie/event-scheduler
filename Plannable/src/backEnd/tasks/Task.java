package backEnd.tasks;

import java.time.LocalTime;

public class Task {
	private int priority;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public Task(LocalTime sT, LocalTime eT, int p){
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
		return "Task [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
