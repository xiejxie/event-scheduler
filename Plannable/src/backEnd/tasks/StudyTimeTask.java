package backEnd.tasks;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import backEnd.tasks.Task;

public class StudyTimeTask extends Task {
	
	private long duration;
	private HashMap <String, Integer> work;
	
	public StudyTimeTask(LocalTime sT, LocalTime eT, int p, char day){
		super("StudyTime", sT, eT, p);
		work = new HashMap<>();
		duration = sT.until(eT, ChronoUnit.HOURS);
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
}
