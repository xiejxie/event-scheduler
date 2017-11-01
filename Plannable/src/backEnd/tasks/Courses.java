package backEnd.tasks;

public class Courses extends Task {
	private String courseName;
	private char day;
	
	public Courses (String name, int p, String sT, String eT, char d){
		super(sT, eT, p);
		courseName = name;
		day = d;
	}
	
}
