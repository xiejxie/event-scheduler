package tasks;

public class Courses extends Task {
	private String courseName;
	private int priority;
	private String startTime;
	private String endTime;
	private char day;
	
	public Courses (String name, int p, String sT, String eT, char d){
		courseName = name;
		priority = p;
		startTime = sT;
		endTime = eT;
		day = d;
	}
}
