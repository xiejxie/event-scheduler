package backEnd.tasks;

public class FreeTime extends Task {
	private String startTime;
	private String endTime;
	private int priority;
	
	public FreeTime(String sT, String eT, int p) {
		startTime = sT;
		endTime = eT;
		priority = p;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getStartTime() {
		return startTime;
	}

}
