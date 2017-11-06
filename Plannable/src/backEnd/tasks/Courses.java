package backEnd.tasks;

import java.time.LocalTime;

public class Courses extends Task {
	
	private String name;
	private char day;
	
	public Courses (LocalTime sT, LocalTime eT, int p, String name, char day){
		super(sT, eT, p);
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public char getDay(){
		return this.day;
	}
}
