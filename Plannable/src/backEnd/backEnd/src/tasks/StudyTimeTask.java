package tasks;

public class FreeTimeTask extends Task {

	private int priority;
	private String startTime;
	private String endTime;
	
	public FreeTimeTask(int p, String sT, String eT){
		priority = p;
		sT = startTime;
		eT = endTime;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public String getStartTime(){
		return startTime;
	}
}
