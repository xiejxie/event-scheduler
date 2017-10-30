package backEnd.tasks;

public class ExtraCurriculars extends Task {
	private String activityName;
	private int priority;
	private String startTime;
	private String endTime;
	private char day;
	
	
	public ExtraCurriculars(String name, int p, String sT, String eT, char d){
		activityName = name;
		priority = p;
		startTime = sT;
		endTime = eT;
		day = d;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public String getStartTime(){
		return startTime;
	}
}
