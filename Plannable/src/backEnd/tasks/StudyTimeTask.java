package backEnd.tasks;

import backEnd.tasks.Task;

public class StudyTimeTask extends Task {

	private int priority;
	private String startTime;
	private String endTime;
	
	public StudyTimeTask(int p, String sT, String eT){
		super(sT, eT, p);
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public String getStartTime(){
		return startTime;
	}
}
