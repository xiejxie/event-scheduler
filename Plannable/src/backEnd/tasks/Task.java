package backEnd.tasks;

public class Task {
	private int priority;
	private String startTime;
	private String endTime;
	
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
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
}
