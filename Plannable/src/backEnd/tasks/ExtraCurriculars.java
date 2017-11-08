package backEnd.tasks;

import java.time.LocalTime;

public class ExtraCurriculars extends Task {	
	
	private char day;
	
	public ExtraCurriculars(LocalTime sT, LocalTime eT, int p, String name, char day){
		super(name, sT, eT, p);
	}
	
	public char getDay(){
		return this.day;
	}
}
