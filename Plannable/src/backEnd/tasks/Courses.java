package backEnd.tasks;

import java.time.LocalTime;

public class Courses extends Task {
	
	private char day;
	
	public Courses (String name, LocalTime sT, LocalTime eT, int p, char day){
		super(name, sT, eT, p);
	}
	
	public char getDay(){
		return this.day;
	}
}
