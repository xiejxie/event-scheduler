package backEnd.tasks;

public class Sleep extends Task {
	private int amount;
	private String startTime;
	private String endTime;
	
	public Sleep(int sleepTime){
		amount = sleepTime;
	}
	public String getEndTime(){
		return endTime;
	}
	
	public String getStartTime(){
		return startTime;
	}
}
