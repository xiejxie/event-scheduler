package backEnd.tasks;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Set;

import backEnd.tasks.Task;

public class StudyTimeTask extends Task {
	
	private long duration;
	private HashMap <String, Integer> work;
	private char day;
	/**
	 * Constructor for StudyTimeTask, which is a subclass of task, and
	 * takes the following arguments
	 * @param sT 
	 * The start time of the task
	 * @param eT
	 * The end time of the task
	 * @param p
	 * The priority given to the task
	 * @param day
	 * The day the task is assigned to
	 * @param d
	 * The difficulty of the task
	 * @param w
	 * The weighting of the task
	 */
	public StudyTimeTask(LocalTime sT, LocalTime eT, int p ,char day){
		super("Study Time", sT, eT, p);
		work = new HashMap<>();
		duration = sT.until(eT, ChronoUnit.HOURS);
		this.day = day;
	}
	
	public char getDay(){
		return day;
	}
	
	public int getDuration(){
		return (int)duration;
	}
	
	public void addWork(String item, int time){
		work.put(item, time);
	}
	
	public String toString(){
		String answer = "Task StudyTime [startTime=" + getStartTime() + ", endTime=" + getEndTime();
		for(String key: work.keySet()){
			if(work.get(key)!=0){
				answer = answer + " " + key + ":" + work.get(key) + ",";
			}
		}
		answer = answer + "]";
		return answer;
	}
	
	public Set<String> getWorkKeys () {
		return work.keySet();
	}
}
