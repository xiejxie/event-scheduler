package tasks;

public class Commute extends Task {
	private int priority;
	private String startTime;
	private String endTime;
	
	public Commute (int p, String sT, String eT){
		priority = p;
		startTime = sT;
		endTime = eT;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public String getStartTime(){
		return startTime;
	}
}
